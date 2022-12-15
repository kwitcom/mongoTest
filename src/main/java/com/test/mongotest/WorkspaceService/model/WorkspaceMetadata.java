package com.test.mongotest.WorkspaceService.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;

@Data
@Builder
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
