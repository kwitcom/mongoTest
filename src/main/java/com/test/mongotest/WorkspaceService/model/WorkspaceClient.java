package com.test.mongotest.WorkspaceService.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "workspace_clients")
public class WorkspaceClient {
    private String source = "MDM";
    @Indexed
    private String clientId;
    @Indexed
    private String clientName;
}
