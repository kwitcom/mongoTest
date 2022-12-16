package com.test.mongotest.Catalog.model;

import lombok.Data;

@Data
public class PwCWorkspace {
    private PwCClient pwCClient;
    private String workspaceId;
    private String workspaceName;

}
