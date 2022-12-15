package com.test.mongotest.Viz.service;

import com.mongodb.client.MongoDatabase;
import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.repository.AssetRepository;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.model.LocationCodes;
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

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class VizAssetService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private WorkspaceService workspaceService;
    @Autowired
    private com.test.mongotest.Viz.utils.Utilities util;

    public void setupDB() {
        MongoDatabase adminDB = mongoTemplate.getMongoDbFactory().getMongoDatabase("admin");

        Document shardCmd = new Document("shardCollection", "glb-dev-test.viz_assets")
                .append("key", new Document("location", 1).append("assetId", 1));

        adminDB.runCommand(shardCmd);
    }

    public String save(AssetItem asset) {
        return assetRepository.save(asset).getAssetId();
    }

    public void delete(String id) {
        assetRepository.deleteById(id);
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
                    String randomId = Utilities.generateRandomUUID();

                    AssetItem asset = AssetItem.builder()
                            .assetId(randomId)
                            .name(WordList.generateRandomReportName())
                            .description(WordList.generateSampleDescription())
                            .location(randomLocationIsoCode)
                            .biToolAssetId(Utilities.generateRandomUUID())
                            .isShared(Utilities.generateRandomBoolean())
                            .isVisible(Utilities.generateRandomBoolean())
                            .workspaceId(workspaceService.getRandomWorkspace().getWorkspaceId())
                            .assetType(com.test.mongotest.Viz.utils.Utilities.selectAssetType())
                            .sharedToAllInternalRole(com.test.mongotest.Viz.utils.Utilities.selectRandomAccessRole())
                            .externalContactsShareAccessRole(com.test.mongotest.Viz.utils.Utilities.selectRandomAccessRole())
                            .accessList(util.generateSampleAccessList())
                            .build();
                    assetRepository.save(asset);
                });
    }

    public AssetItem findAssetItemByAssetId(String assetId) {
        return assetRepository.findAssetItemByAssetId(assetId);
    }

    public List<AssetItem> findByEmailPaged(String email,int pageNumber, int pageSize) {
        //TODO: This is not currently working need to troubleshoot
        Sort sort = Sort.by(Sort.Direction.ASC, "assetId");
        PageRequest request = PageRequest.of(pageNumber, pageSize, sort);
        Page<AssetItem> page = assetRepository.findByAccessListEmail(request, email);
        List<AssetItem> list = page.getContent();
        return list;
    }
    public List<AssetItem> findByEmail(String email) {
        return assetRepository.findByAccessListEmail(email);
    }
    public List<AssetItem> findAssetItemsBySharedToAllInternalRole(int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC, "assetId");
        PageRequest request = PageRequest.of(pageNumber, pageSize, sort);
        Page<AssetItem> page = assetRepository.findAssetItemsBySharedToAllInternalRole(request);

        return page.getContent();
    }

    public List<AssetItem> findAll(int pageNumber, int pageSize) {

        Sort sort = Sort.by(Sort.Direction.ASC, "assetId");
        PageRequest request = PageRequest.of(pageNumber, pageSize, sort);
        Page<AssetItem> page = assetRepository.findAll(request);

        return page.getContent();
    }

}
