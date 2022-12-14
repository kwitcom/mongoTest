package com.test.mongotest.WorkspaceService.service;

import com.test.mongotest.Viz.repository.EmailModelRepository;
import com.test.mongotest.WorkspaceService.model.WorkspaceRoles;
import com.test.mongotest.WorkspaceService.model.WorkspaceUser;
import com.test.mongotest.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class WorkspaceUserService {
    @Autowired
    private EmailModelRepository emailModelRepository;

    public List<WorkspaceUser> generateSampleWorkspaceUsers(int numUsers) {
        List<WorkspaceUser> users = new ArrayList<>();
        IntStream.range(0, numUsers)
                .parallel()
                .forEach(i -> {
                    String email = emailModelRepository.findByEmailAddressEndsWith("pwc.com").getEmailAddress();
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
                });
        return users;
    }



}
