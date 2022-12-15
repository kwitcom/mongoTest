package com.test.mongotest.Catalog.service;

import com.mongodb.client.MongoDatabase;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        MongoDatabase adminDB = mongoTemplate.getMongoDbFactory().getMongoDatabase("admin");

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

    public List<CatalogAsset> findBySearchableIsTrue(int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC, "assetId");
        PageRequest request = PageRequest.of(pageNumber, pageSize, sort);
        Page<CatalogAsset> page = catalogAssetRepository.findBySearchableIsTrue(request);

        return page.getContent();
    }

//    public List<CatalogAsset> search1(){
//        return catalogAssetRepository.test3();
//    }

//
//
//    // NOTE: Catalog Search doesn't have tags only workspace - query below is to execute atlas search by tags in workspace
//    private static void searchTags(MongoCollection<Document> workspaces){
//        SearchPath path = SearchPath.fieldPath("tags");
//        String query = "accountings"; // <-- typo!
//        SearchOperator operator = SearchOperator.text(path, query).fuzzy(FuzzySearchOptions.fuzzySearchOptions().maxEdits(2));
//        // Options, what goes outside $text
//        SearchOptions options = SearchOptions.searchOptions()
//                .index("default");
//        Bson textSearch = Aggregates.search(operator, options);
//        catalog_assets.aggregate(Arrays.asList(textSearch)).forEach(doc -> System.out.println(doc.toJson()));
//    }
//    //TODO: Need to be able to search by atlas search on description
//    // NOTE: Note sure where you'll put the below code for search query
//    private static void searchDescription(MongoCollection<Document> catalog_assets){
//        SearchPath path = SearchPath.fieldPath("description");
//        String query = "Productvty"; // <-- typo!
//        SearchOperator operator = SearchOperator.text(path, query).fuzzy(FuzzySearchOptions.fuzzySearchOptions().maxEdits(2));
//        // Options, what goes outside $text
//        SearchOptions options = SearchOptions.searchOptions()
//                .index("default");
//        Bson textSearch = Aggregates.search(operator, options);
//        catalog_assets.aggregate(Arrays.asList(textSearch)).forEach(doc -> System.out.println(doc.toJson()));
//    }
//
//    //TODO: Need list of access that are for single workspace, then all for the sample client if searchable is true and any other details user provides
//    // NOTE: Need to execute queries from workspace collection since it has client & searchable fields
//    @Query(value = "{client.clientName = 'Goldman Sachs : QRSTUVWXYZ'}")
//    @Query(value = "{client.clientName = 'Goldman Sachs : QRSTUVWXYZ', metadata.searchable = true}", fields = "{ 'client.clientName' : 1, 'metadata.searchable' : 1}")

}
