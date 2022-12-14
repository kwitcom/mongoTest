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

    public List<AssetItem> findByEmail(String email) {
        return assetRepository.findByAccessListEmail(email);
    }
}
