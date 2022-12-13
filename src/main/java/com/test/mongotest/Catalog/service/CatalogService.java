package com.test.mongotest.Catalog.service;

import com.test.mongotest.Catalog.model.CatalogAsset;
import com.test.mongotest.Catalog.repository.CatalogAssetRepository;
import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.model.LocationCodes;
import com.test.mongotest.model.WordList;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CatalogService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private WorkspaceService workspaceService;
    @Autowired
    private CatalogAssetRepository catalogAssetRepository;

    public void createAndSaveCatalogAsset(CatalogAsset catalogAsset) {
        mongoTemplate.insert(catalogAsset);
    }

    public void loadSampleWorkspace() {

        List<Workspace> workspaceList = workspaceService.allWorkspaces();

        workspaceList.forEach(ws -> {
            CatalogAsset asset = CatalogAsset.builder()
                    .qualifiedName("https://workbench-us.pwclabs.pwcglb.com/" + ws.getWorkspaceId() + "/")
                    .AssetId(ws.getWorkspaceId() )
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
        for (int i = 0; i < numRecords; i++) {
            String randomLocationIsoCode = LocationCodes.getRandomLocCode();
            String description = WordList.generateSampleDescription();
            String randomId = Utilities.generateRandomUUID();

            CatalogAsset asset = CatalogAsset.builder()
                    .qualifiedName("asset " + i + " " + randomId)
                    .AssetId(randomId)
                    .name(WordList.generateRandomAssetName())
                    .location(randomLocationIsoCode)
                    .territory(randomLocationIsoCode)
                    .description(description)
                    .resourceStatus("AVAILABLE")
                    .deIdentified(Utilities.generateRandomBoolean())
                    .searchable(Utilities.generateRandomBoolean())
                    .pwcTags(Utilities.generateRandomTagList())
                    .build();
            catalogAssetRepository.save(asset);
        }
    }
}
