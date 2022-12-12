package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspaceUser {
    private String userType;
    private String userId;
    private String userName;
    private String email;
    private Date userAddedDateTime;
    private List<WorkspaceRoles> roles;
}

