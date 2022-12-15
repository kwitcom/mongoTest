package com.test.mongotest.WorkspaceService.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
public class WorkspaceCountry {
    private String countryName;
    @Indexed
    private String countryCode;
}
