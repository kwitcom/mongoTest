package com.test.mongotest.WorkspaceService.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.index.Indexed;

@Builder
public class WorkspaceCountry {
    private String countryName;
    @Indexed
    private String countryCode;
}
