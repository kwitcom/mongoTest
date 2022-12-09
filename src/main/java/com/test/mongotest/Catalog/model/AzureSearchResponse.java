package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureSearchResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    // @JsonProperty(value="@odata.context")
    // private String data_context;

    @JsonProperty(value = "@odata.count")
    private Integer count;

    @JsonProperty(value="@search.facets")
    private Map<String, List<PwcFacet>> facets;

    @JsonProperty(value = "value")
    private List<Map<String, Object>> assets;

    @JsonProperty(value = "@odata.nextLink")
    private String nextLink;

}
