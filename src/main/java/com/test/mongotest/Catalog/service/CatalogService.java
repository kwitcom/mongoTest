package com.test.mongotest.Catalog.service;

import com.mongodb.client.model.*;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.test.mongotest.Catalog.model.CatalogAsset;
import com.test.mongotest.Catalog.model.TypeDatabase;
import com.test.mongotest.Catalog.repository.CatalogAssetRepository;
import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.model.LocationCodes;
import com.test.mongotest.model.TypeFile;
import com.test.mongotest.model.WordList;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@Slf4j
@Service
public class CatalogService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private WorkspaceService workspaceService;
    @Autowired
    private CatalogAssetRepository catalogAssetRepository;

    public void setupDB() {
        MongoDatabase adminDB = mongoTemplate.getMongoDatabaseFactory().getMongoDatabase("admin");

        Document shardCmd = new Document("shardCollection", "glb-dev-test.catalog_assets")
                .append("key", new Document("location", 1).append("assetId", 1));

        adminDB.runCommand(shardCmd);
    }

    public void createAndSaveCatalogAsset(CatalogAsset catalogAsset) {
        catalogAssetRepository.save(catalogAsset);
    }

    public void loadSampleWorkspace() {

        List<Workspace> workspaceList = workspaceService.allWorkspaces();

        workspaceList.parallelStream().forEach(ws -> {
            CatalogAsset asset = CatalogAsset.builder()
                    .qualifiedName("https://workbench-us.pwclabs.pwcglb.com/" + ws.getWorkspaceId() + "/")
                    .assetId(ws.getWorkspaceId())
                    .name(ws.getWorkspaceName())
                    .location(ws.getLocation())
                    .territory(ws.getLocation())
                    .description(ws.getWorkspaceName())
                    .resourceStatus("AVAILABLE")
                    .searchable(Utilities.generateRandomBoolean())
                    .pwcTags(null)
                    .deIdentified(false)
                    .build();
            catalogAssetRepository.save(asset);
        });
    }

    public void loadSampleData(Integer batchSize, Integer numBatches) {
        for (int i = 0; i < numBatches; i++) {
            generateSampleData(batchSize);
        }
    }

    private void generateSampleData(int numRecords) {
        IntStream.range(0, numRecords)
                // Use parallel stream to process the elements in parallel
                .parallel()
                // For each integer in the stream, generate a sample email model and save it
                .forEach(i -> {
                    String randomLocationIsoCode = LocationCodes.getRandomLocCode();
                    String description = WordList.generateSampleDescription();
                    String randomId = Utilities.generateRandomUUID();
                    Workspace workspace = workspaceService.getRandomWorkspace();

                    CatalogAsset asset = CatalogAsset.builder()
                            .qualifiedName(WordList.generateRandomAssetName())
                            .assetId(randomId)
                            .name(WordList.generateRandomAssetName())
                            .location(randomLocationIsoCode)
                            .territory(randomLocationIsoCode)
                            .description(description)
                            .resourceStatus("AVAILABLE")
                            .deIdentified(Utilities.generateRandomBoolean())
                            .searchable(Utilities.generateRandomBoolean())
                            .pwcTags(Utilities.generateRandomTagList())
                            .accessRequestUrl(WordList.generateSampleDescription())
                            .accessRequestInstructions(WordList.generateSampleDescription())
                            .previewInfo(WordList.generateSampleDescription())
                            .typeFile(TypeFile.selectRandomExtension())
                            .dataCopyright(WordList.generateSampleDescription())
                            .typeDatabase(new TypeDatabase())
                            .size(Utilities.generateRandomSize())
                            .clientName(workspace.getClient().getClientName())
                            .workspaceId(workspace.getWorkspaceId())
                            .workspaceName(workspace.getWorkspaceName())
                            .additionalReferencesUrl(WordList.generateSampleDescription())
                            .additionalReferencesLabel(WordList.generateSampleDescription())
                            .relations(buildRandomRelationshipList())
                            .build();
                    catalogAssetRepository.save(asset);
                });
    }

    private List<String> buildRandomRelationshipList() {
        List<String> relationships = new ArrayList<>();

        Random random = new Random();
        int numItems = random.nextInt(51);
        for (int i = 0; i < numItems; i++) {
            CatalogAsset a = catalogAssetRepository.selectSampleRecord();
            if (a != null) {
                relationships.add(a.getAssetId());
            } else {
                return relationships;
            }
        }
        return relationships;
    }

    public Page<CatalogAsset> findBySearchableIsTrue(int pageNumber, int pageSize) {

        PageRequest request = PageRequest.of(pageNumber, pageSize);

        return catalogAssetRepository.findBySearchableIsTrue(request);
    }

    public Page<CatalogAsset> findByClientId(String clientId, int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC, "assetId");
        PageRequest request = PageRequest.of(pageNumber, pageSize, sort);

        return catalogAssetRepository.findByClientId(clientId, request);
    }

    public Page<CatalogAsset> findByWorkspaceId(String workspaceId, int pageNumber, int pageSize) {

        PageRequest request = PageRequest.of(pageNumber, pageSize);

        return catalogAssetRepository.findByWorkspaceId(workspaceId, request);
    }

    public Page<CatalogAsset> findByPwcTags(List<String> tags, int pageNumber, int pageSize) {

        PageRequest request = PageRequest.of(pageNumber, pageSize);

        return catalogAssetRepository.findByPwcTags(tags, request);
    }

    public Page<CatalogAsset> findByLocation(String location, int pageNumber, int pageSize) {

        PageRequest request = PageRequest.of(pageNumber, pageSize);

        return catalogAssetRepository.findByLocation(location, request);
    }

    public AggregateIterable<Document> search1() {
        Document query = new Document("$search",
                new Document("index", "default")
                        .append("text",
                                new Document("query", "Productivity")
                                        .append("path", Arrays.asList("name", "description"))
                                        .append("fuzzy",
                                                new Document("maxEdits", 2L))));
        MongoCollection<Document> catalogAssets = mongoTemplate.getCollection("catalog_assets");

        return catalogAssets.aggregate(List.of(query));
    }

    public Page<Document> search2(String searchTerm, int page, int size) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").regex(searchTerm, "i")
                .orOperator(Criteria.where("description").regex(searchTerm, "i")));

        PageRequest pageRequest = PageRequest.of(page, size);
        List<Document> documents = mongoTemplate.find(query.with(pageRequest), Document.class, "catalog_assets");
        return new PageImpl<>(documents, pageRequest, documents.size());
    }


    private Consumer<Document> printDocuments() {
        return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
    }

    private Collection<Document> searchCatalogTest1(MongoCollection<Document> catalogCollection) {
        Collection<Document> result = catalogCollection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "default")
                        .append("text",
                                new Document("query", "Productivity")
                                        .append("path", Arrays.asList("name", "description"))
                                        .append("fuzzy",
                                                new Document("maxEdits", 2L)))))).into(new ArrayList<>());
        return result;
    }

}
