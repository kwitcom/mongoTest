package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureSearchRequest {

    private String search;
    private String queryType;
    private String searchMode;
    private String searchFields;
    private List<String> facets;
    private String filter;
    private String skip;
    private String top;
    //    private String highlight;
    private String orderby;
    private Boolean count;
}
