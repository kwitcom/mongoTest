package com.test.mongotest.Viz.service;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.repository.AssetRepository;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VizAssetService {

    @Autowired
    private AssetRepository assetRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WorkspaceService workspaceService;

    public String save(AssetItem asset) {
        return assetRepository.save(asset).getAssetId();
    }

    public void delete(String id) {
        assetRepository.deleteById(id);
    }

    public void loadSampleData() {
        int batchSize = 30; // Number of records to generate and save per batch
        int numBatches = 1; // Number of batches to generate and save

        for (int i = 0; i < numBatches; i++) {
            generateSampleData(batchSize);
        }
    }

    private void generateSampleData(int numRecords) {
        for (int i = 0; i < numRecords; i++) {
            String randomLocationIsoCode = Utilities.getRandomLocCode();
            String description = Utilities.generateSampleDescription();
            String randomId = Utilities.generateRandomUUID();

            AssetItem asset = AssetItem.builder()
                    .assetId(randomId)
                    .name("Report " + randomId)
                    .description(description)
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
            this.save(asset);
        }
    }
}
