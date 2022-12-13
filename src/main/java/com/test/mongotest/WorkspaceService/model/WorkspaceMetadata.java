package com.test.mongotest.WorkspaceService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "workspace_metadata")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkspaceMetadata {
    @Indexed
    private String wbsCode;
    private Boolean allowInternalSharing;
    private Boolean systemOnly;
    private Boolean visibility;
    private Boolean limitToWorkspaceOnly;
    private Boolean approval;
    private List<String> domainLimitData;
    @Indexed
    private String apptioId;
    private Boolean externalLimitSharing;
    private Boolean externalLimitData;
    private List<String>domainLimitSharing;
    private Boolean searchable;

}
