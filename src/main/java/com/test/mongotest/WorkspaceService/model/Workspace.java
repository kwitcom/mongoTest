package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.mongotest.model.LineOfService;
import com.test.mongotest.model.OriginatingSite;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Document(collection = "workspaces")
@CompoundIndex(def = "{'location': 1, 'workspaceId': 1}")
@Sharded(shardKey = {"location", "workspaceId"}, immutableKey = true)
public class Workspace {
    @Id
    private String _id;
    @Indexed
    private String workspaceId;
    private String workspaceName;
    private WorkspaceType workspaceType;
    @Indexed
    private OriginatingSite originatingSite;
    @Indexed
    private LineOfService lineOfService;
    private DataClassification dataClassification;
    private DataConsentLevel dataConsentLevel;
    private WorkspaceClient client;
    private WorkspaceCountry country;
    private String location;
    private WorkspaceMetadata metadata;
    private List<String> tags;
    private List<WorkspaceUser> users;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant startDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant endDate;
    private String version;
    private WorkspaceStatus status;
    private String createdBy;
    private String lastModifiedBy;

}