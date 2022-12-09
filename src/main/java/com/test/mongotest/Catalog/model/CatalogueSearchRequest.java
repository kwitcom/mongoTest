package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogueSearchRequest {
	
	private String search;
    private Map<String, Object> filter = new HashMap<>();
    private Map<String, Object> excludeFilter = new HashMap<>();
    private Integer limit;
    private Integer offset;
    private Map<String, String> orderBy;
    @Schema(hidden = true)
    private Object facets;
}
