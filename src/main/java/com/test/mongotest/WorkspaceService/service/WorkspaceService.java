package com.test.mongotest.WorkspaceService.service;

import com.test.mongotest.WorkspaceService.model.*;
import com.test.mongotest.WorkspaceService.repository.WorkspaceRepository;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    public List<Workspace> allWorkspaces() {
        return workspaceRepository.findAll();
    }

    public void loadSampleData() {
        int batchSize = 30; // Number of records to generate and save per batch
        int numBatches = 1; // Number of batches to generate and save

        for (int i = 0; i < numBatches; i++) {
            List<Workspace> workspaces = generateWorkspaces(batchSize);
            mongoTemplate.insertAll(workspaces);
        }
    }

    private List<Workspace> generateWorkspaces(int numRecords) {
        // Initialize the list to store the generated Workspace objects
        List<Workspace> sampleData = new ArrayList<>();
        // Generate the Workspace objects and add them to the list
        IntStream.range(0, numRecords)
                .parallel()
                .forEach(i -> {
                    Random random = new Random();
                    String randomLocationIsoCode = Utilities.getRandomLocCode();
                    //TODO Clean-up names Use different list of names for clients
                    String workspaceName = Utilities.generateSampleDescription();
                    String workspaceId = Utilities.generateRandomUUID();
                    Date startDate = Utilities.generateStartDate();
                    Date endDate = Utilities.generateEndDate(startDate);
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

                    List<WorkspaceUser> users = WorkspaceUserService.generateSampleWorkspaceUsers(random.nextInt(200) + 1);

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
                    sampleData.add(workspace);
                });
        return sampleData;
    }

    //        List<Workspace> sampleData = new ArrayList<>();

//        for (int i = 0; i < numRecords; i++) {
//            Random random = new Random();
//            String randomLocationIsoCode = Utilities.getRandomLocCode();
//            //TODO Clean-up names Use different list of names for clients
//            String workspaceName = Utilities.generateSampleDescription();
//            String workspaceId = Utilities.generateRandomUUID();
//            Date startDate = Utilities.generateStartDate();
//            Date endDate = Utilities.generateEndDate(startDate);
//            WorkspaceMetadata workspaceMetadata = WorkspaceMetadata.builder()
//                    .allowInternalSharing(true)
//                    .limitToWorkspaceOnly(false)
//                    .approval(false)
//                    .apptioId("xx000")
//                    .externalLimitData(false)
//                    .systemOnly(false)
//                    .wbsCode("15263")
//                    .externalLimitSharing(false)
//                    .domainLimitData(null)
//                    .domainLimitSharing(null)
//                    .searchable(true)
//                    .visibility(true)
//                    .build();

//            List<WorkspaceUser> users = WorkspaceUserService.generateSampleWorkspaceUsers(random.nextInt(200) + 1);

//            Workspace workspace = Workspace.builder()
//                    .workspaceId(workspaceId)
//                    .country(WorkspaceCountry.builder().countryCode(randomLocationIsoCode).countryName(randomLocationIsoCode).build())
//                    .location(randomLocationIsoCode)
//                    .tags(Utilities.generateRandomTagList())
//                    .lineOfService(Utilities.selectRandomLineOfService())
//                    .originatingSite(Utilities.selectRandomOriginatingSite())
//                    .dataClassification(DataClassification.CONFIDENTIAL)
//                    .dataConsentLevel(DataConsentLevel.CLIENT_ONLY)
//                    .startDate(startDate)
//                    .endDate(endDate)
//                    .client(clientService.getRandomClient())
//                    .version("WS-2.0")
//                    .metadata(workspaceMetadata)
//                    .workspaceType(selectRandomWorkspaceType())
//                    .users(users)
//                    .workspaceName(workspaceName)
//                    .status(WorkspaceStatus.ACTIVE)
//                    .build();
//            sampleData.add(workspace);
//        }

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
}
