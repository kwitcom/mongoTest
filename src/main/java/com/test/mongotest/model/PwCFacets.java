package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class PwCFacets {

    public static List<String> Facets;

    static {
        Facets = Arrays.asList(
                "name",
                "territory",
                "resourceStatus",
                "description",
                "deIdentified",
                "extension",
                "ownership_type",
                "typeName");
    }
}
