package com.test.mongotest.Viz.service;

import com.mongodb.client.MongoDatabase;
import com.test.mongotest.Viz.model.asset.MainObject;
import com.test.mongotest.Viz.model.asset.SubObject;
import com.test.mongotest.Viz.repository.EmailModelRepository;
import com.test.mongotest.Viz.repository.MainRepository;
import com.test.mongotest.model.LocationCodes;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class MainService {
    @Autowired
    private MainRepository mainRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private EmailModelRepository emailModelRepository;

    public void setupDB() {
        MongoDatabase adminDB =mongoTemplate.getMongoDatabaseFactory().getMongoDatabase("admin");

        Document shardCmd = new Document("shardCollection", "glb-dev-test.test")
                .append("key", new Document("location", 1).append("assetId", 1));
//        Document enableShardingCmd = new Document("enableSharding", "glb-dev-test");

        adminDB.runCommand(shardCmd);
//        adminDB.runCommand(enableShardingCmd);
    }

    public void loadSampleData(Integer batchSize, Integer numBatches) {
        for (int i = 0; i < numBatches; i++) {
            generateSampleData(batchSize);
        }
    }

    private void generateSampleData(int numRecords) {
        for (int i = 0; i < numRecords; i++) {
            List<SubObject> subObjects = new ArrayList<>();
            Random random = new Random();
            int count = random.nextInt(31);
            for (int n = 0; n < count; n++) {
                String name = emailModelRepository.findByEmailAddressEndsWith("").getEmailAddress();
                SubObject user = SubObject.builder()
                        .fullName(name)
                        .email(name)
                        .accessRole(com.test.mongotest.Viz.utils.Utilities.selectRandomAccessRole())
                        .build();
                subObjects.add(user);
            }

            MainObject object = MainObject.builder()
                    .id(Utilities.generateRandomUUID())
                    .assetId(Utilities.generateRandomUUID())
                    .location(LocationCodes.getRandomLocCode())
                    .subObject(subObjects)
                    .build();
            mainRepository.save(object);
        }
    }

    public List<MainObject> findByEmail(String email) {
        return mainRepository.findBySubObjectEmail(email);
    }

}
