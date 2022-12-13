package com.test.mongotest.WorkspaceService.service;

import com.test.mongotest.WorkspaceService.model.WorkspaceClient;
import com.test.mongotest.WorkspaceService.repository.ClientRepository;
import com.test.mongotest.model.ClientNames;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class ClientService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private ClientRepository clientRepository;
    public List<WorkspaceClient> allClients(){
        return clientRepository.findAll();
    }
    public void loadSampleData() {
        int batchSize = 100; // Number of records to generate and save per batch
        int numBatches = 10; // Number of batches to generate and save

        for (int i = 0; i < numBatches; i++) {
            generateSampleData(batchSize);
        }
    }

    private void generateSampleData(int numRecords) {
        for (int i = 0; i < numRecords; i++) {
            WorkspaceClient client = WorkspaceClient.builder()
                    .clientId(Utilities.generateRandomUUID())
                    .clientName(ClientNames.generateRandomClientName())
                    .source("MDM")
                    .build();
            clientRepository.save(client);
        }
    }

    public WorkspaceClient getRandomClient(){
        Random random = new Random();

        // Use the GroupService instance to get all groups
        List<WorkspaceClient> allClients = this.allClients();

        // Generate a random index between 0 and the size of the list
        int randomIndex = random.nextInt(allClients.size());

        // Get the group at the random index
        WorkspaceClient randomClient = allClients.get(randomIndex);

        return randomClient;
    }

}
