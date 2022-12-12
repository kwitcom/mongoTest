package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "workspace_clients")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspaceClient {
    private String source = "MDM";
    private String clientId;
    private String clientName;
}
