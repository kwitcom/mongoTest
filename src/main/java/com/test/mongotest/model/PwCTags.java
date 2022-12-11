package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class PwCTags {

    public static List<String> Tags;

    static {
        Tags = Arrays.asList(
                "Tax",
                "2022",
                "2021", "2020", "2019", "2023", "audit", "filing", "csv", "xml", "pdf", "tar", "parquet"
        );
    }
}
