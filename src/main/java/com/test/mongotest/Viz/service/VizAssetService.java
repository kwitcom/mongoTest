package com.test.mongotest.Viz.service;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.repository.AssetRepository;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.model.LocationCodes;
import com.test.mongotest.model.WordList;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class VizAssetService {

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private MongoOperations mongoOperations;
    @Autowired
    private WorkspaceService workspaceService;


    public void setupDB() {
//        MongoDatabase adminDB = mongoTemplate.getMongoDbFactory().getMongoDatabase("admin");
//
//        Document shardCmd = new Document("shardCollection", "glb-dev-test.viz_assets")
//                .append("key", new Document("location", 1).append("assetId", 1));
//
//        Document enableShardingCmd = new Document("enableSharding", "glb-dev-test");
//
//        adminDB.runCommand(shardCmd);
//        adminDB.runCommand(enableShardingCmd);
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
        for (int i = 0; i < numRecords; i++) {
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
                    .accessList(com.test.mongotest.Viz.utils.Utilities.generateSampleAccessList())
                    .build();
            assetRepository.save(asset);
        }
    }

    public AssetItem findAssetItemByAssetId(String assetId) {
        return assetRepository.findAssetItemByAssetId(assetId);
    }


    public List<AssetItem> findByEmail(String email) {
        return assetRepository.findByAccessListEmail(email);
    }
}
