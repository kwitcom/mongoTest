package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Builder
@Document(collection = "workspaces")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Workspace {
    @Id
    private String _id;
    private String workspaceId;
    private String workspaceName;
    private String workspaceType;
    private String originatingSite;
    private LineOfService lineOfService;
    private DataClassification dataClassification;
    private DataConsentLevel dataConsentLevel;
    private WorkspaceClient client;
    private WorkspaceCountry country;
    private String location;
    private String metadata;
    private List<String> tags;
    private List<WorkspaceUser> users;
    private Date startDate;
    private Date endDate;
    private String version;
    private WorkspaceStatus status;
    private String createdBy;
    private String lastModifiedBy;

}