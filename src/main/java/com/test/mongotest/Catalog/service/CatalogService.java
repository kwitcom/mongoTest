package com.test.mongotest.Catalog.service;

import com.test.mongotest.Catalog.model.CatalogAsset;
import com.test.mongotest.model.WorkspaceIds;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CatalogService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void createAndSaveCatalogAsset(CatalogAsset catalogAsset) {
        mongoTemplate.insert(catalogAsset);
    }

    public void loadSampleWorkspace() {
        List<CatalogAsset> sampleData = new ArrayList<>();

        List<String> workspaceList = WorkspaceIds.Ids;

        workspaceList.forEach(id -> {
            String loc = Utilities.getRandomLocCode();
            CatalogAsset asset = CatalogAsset.builder()
                    .qualifiedName("https://workbench-us.pwclabs.pwcglb.com/" + id + "/")
                    .AssetId(id)
                    .name("Workspace Name: " + id)
                    .location(loc)
                    .territory(loc)
                    .description("Workspace : " + id)
                    .resourceStatus("AVAILABLE")
                    .searchable(Utilities.generateRandomBoolean())
                    .build();
            sampleData.add(asset);

        });
        mongoTemplate.insertAll(sampleData);
    }

    public void loadSampleData() {
        int batchSize = 100; // Number of records to generate and save per batch
        int numBatches = 5; // Number of batches to generate and save

        for (int i = 0; i < numBatches; i++) {
            List<CatalogAsset> sampleData = generateSampleData(batchSize);
            mongoTemplate.insertAll(sampleData);
        }
    }

    private List<CatalogAsset> generateSampleData(int numRecords) {
        List<CatalogAsset> sampleData = new ArrayList<>();

        for (int i = 0; i < numRecords; i++) {
            String randomLocationIsoCode = Utilities.getRandomLocCode();
            String description = Utilities.generateSampleDescription();
            String randomId = Utilities.generateRandomUUID();

            CatalogAsset asset = CatalogAsset.builder()
                    .qualifiedName("asset " + i + " " + randomId)
                    .AssetId(randomId)
                    .name("asset " + i + " " + randomId)
                    .location(randomLocationIsoCode)
                    .territory(randomLocationIsoCode)
                    .description(description)
                    .resourceStatus("AVAILABLE")
                    .deIdentified(Utilities.generateRandomBoolean())
                    .searchable(Utilities.generateRandomBoolean())
                    .pwcTags(Utilities.generateRandomTagList())
                    .build();
            sampleData.add(asset);
        }
        return sampleData;
    }
}
