package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;
import java.util.List;

@Data
@Builder@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspaceUser {
    private String userType;
    @Indexed
    private String userId;
    @Indexed
    private String userName;
    @Indexed
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant userAddedDateTime;
    private List<WorkspaceRoles> roles;
}

