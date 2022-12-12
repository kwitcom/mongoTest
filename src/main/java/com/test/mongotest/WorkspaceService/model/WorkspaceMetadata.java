package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "workspace_metadata")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspaceMetadata {
    private String wbsCode;
    private Boolean allowInternalSharing;
    private Boolean systemOnly;
    private Boolean visibility;
    private Boolean limitToWorkspaceOnly;
    private Boolean approval;
    private List<String> domainLimitData;
    private String apptioId;
    private Boolean externalLimitSharing;
    private Boolean externalLimitData;
    private List<String>domainLimitSharing;
    private Boolean searchable;

}
