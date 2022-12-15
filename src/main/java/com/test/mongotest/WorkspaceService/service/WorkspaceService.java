package com.test.mongotest.WorkspaceService.service;

import com.mongodb.client.MongoDatabase;
import com.test.mongotest.WorkspaceService.model.*;
import com.test.mongotest.WorkspaceService.repository.WorkspaceRepository;
import com.test.mongotest.model.LocationCodes;
import com.test.mongotest.model.OriginatingSite;
import com.test.mongotest.model.WorkspaceNameSamples;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Slf4j
@Service
public class WorkspaceService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkspaceUserService workspaceUserService;

    public void setupDB() {
        MongoDatabase adminDB = mongoTemplate.getMongoDbFactory().getMongoDatabase("admin");

        Document shardCmd = new Document("shardCollection", "glb-dev-test.workspaces")
                .append("key", new Document("location", 1).append("workspaceId", 1));

        adminDB.runCommand(shardCmd);
    }

    public List<Workspace> allWorkspaces() {
        return workspaceRepository.findAll();
    }

    public void loadSampleData(Integer batchSize, Integer numBatches) {
        for (int i = 0; i < numBatches; i++) {
            generateWorkspaces(batchSize);
        }
    }

    private void generateWorkspaces(int numRecords) {
        IntStream.range(0, numRecords)
                .parallel()
                .forEach(i -> {
                    Random random = new Random();
                    String randomLocationIsoCode = LocationCodes.getRandomLocCode();
                    String workspaceName = WorkspaceNameSamples.selectRandomWorkspaceName();
                    String workspaceId = Utilities.generateRandomUUID();
                    Instant startDate = Utilities.generateStartDate();
                    Instant endDate = Utilities.generateEndDate(startDate);
                    WorkspaceMetadata workspaceMetadata = WorkspaceMetadata.builder()
                            .allowInternalSharing(true)
                            .limitToWorkspaceOnly(false)
                            .approval(false)
                            .apptioId("xx000")
                            .externalLimitData(false)
                            .systemOnly(false)
                            .wbsCode("15263")
                            .externalLimitSharing(false)
                            .domainLimitData(null)
                            .domainLimitSharing(null)
                            .searchable(true)
                            .visibility(true)
                            .build();

                    List<WorkspaceUser> users = workspaceUserService.generateSampleWorkspaceUsers(random.nextInt(20) + 1);

                    Workspace workspace = Workspace.builder()
                            .workspaceId(workspaceId)
                            .country(WorkspaceCountry.builder().countryCode(randomLocationIsoCode).countryName(randomLocationIsoCode).build())
                            .location(randomLocationIsoCode)
                            .tags(Utilities.generateRandomTagList())
                            .lineOfService(Utilities.selectRandomLineOfService())
                            .originatingSite(Utilities.selectRandomOriginatingSite())
                            .dataClassification(DataClassification.CONFIDENTIAL)
                            .dataConsentLevel(DataConsentLevel.CLIENT_ONLY)
                            .startDate(startDate)
                            .endDate(endDate)
                            .client(clientService.getRandomClient())
                            .version("WS-2.0")
                            .metadata(workspaceMetadata)
                            .workspaceType(selectRandomWorkspaceType())
                            .users(users)
                            .workspaceName(workspaceName)
                            .status(WorkspaceStatus.ACTIVE)
                            .build();

                    workspaceRepository.save(workspace);
                });
    }

    public Workspace getRandomWorkspace() {
        Random random = new Random();

        // Use the GroupService instance to get all groups
        List<Workspace> allWorkspaces = this.allWorkspaces();

        // Generate a random index between 0 and the size of the list
        int randomIndex = random.nextInt(allWorkspaces.size());

        // Get the group at the random index
        Workspace randomWorkspace = allWorkspaces.get(randomIndex);

        return randomWorkspace;
    }

    public static WorkspaceType selectRandomWorkspaceType() {
        Random random = new Random();
        WorkspaceType[] values = WorkspaceType.values();
        if (values.length == 0) {
            // If the list is empty, throw an exception
            throw new IllegalArgumentException("The list of values cannot be empty");
        }
        int index = random.nextInt(values.length);
        return values[index];

    }

    public List<Workspace> findByTagsIn(List<String> tags) {
        return workspaceRepository.findByTagsIn(tags);
    }

    public List<Workspace> findByMetadataWbsCode(String wbscode) {
        return workspaceRepository.findByMetadataWbsCode(wbscode);
    }

    public List<Workspace> findByUsersEmail(String email) {
        return workspaceRepository.findByUsersEmail(email);
    }

    public List<Workspace> findByClientClientIdAndDataConsentLevel(String clientId, DataConsentLevel dataConsentLevel) {
        return workspaceRepository.findByClientClientIdAndDataConsentLevel(clientId, dataConsentLevel);
    }

    public List<Workspace> findByOriginatingSite(OriginatingSite originatingSite) {
        return workspaceRepository.findByOriginatingSite(originatingSite);
    }

    public List<Workspace> findByClientClientId(String clientId) {
        return workspaceRepository.findByClientClientId(clientId);
    }

    public Workspace findByWorkspaceId(String workspaceId) {
        return workspaceRepository.findByWorkspaceId(workspaceId);
    }
}
