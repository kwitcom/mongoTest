package com.test.mongotest.WorkspaceService.service;

import com.test.mongotest.WorkspaceService.model.WorkspaceRoles;
import com.test.mongotest.WorkspaceService.model.WorkspaceUser;
import com.test.mongotest.WorkspaceService.repository.WorkspaceUserRepository;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class WorkspaceUserService {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private WorkspaceUserRepository workspaceUserRepository;

    public static List<WorkspaceUser> generateSampleWorkspaceUsers(int numUsers) {
        List<WorkspaceUser> users = new ArrayList<>();

        // Generate a number of WorkspaceUser objects and add them to the list
        for (int i = 0; i < numUsers; i++) {
            String email = Utilities.generateRandomEmail("pwc.com");
            List<WorkspaceRoles> roles = new ArrayList<>();
            roles.add(WorkspaceRoles.MEMBER);

            WorkspaceUser user = WorkspaceUser.builder()
                    .userId(email)
                    .email(email)
                    .userType("InternalUser")
                    .roles(roles)
                    .userName(email)
                    .userAddedDateTime(Utilities.generateStartDate())
                    .build();
            users.add(user);
        }

        return users;
    }



}
