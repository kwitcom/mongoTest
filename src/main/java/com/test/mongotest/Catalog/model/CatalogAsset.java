package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@Document(collection = "catalog_asset")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CatalogAsset {

    private String name;

    private Instant createTime;
    private Instant updateTime;
    private String location;
    private String registrationSourceSystem;
    private String territory;
    private String restrictedTerritories;
    private String primarySubjects;
    private Boolean searchable;
    private String resourceStatus;
    private String accessRequestUrl;
    private String accessRequestInstructions;
    private String previewInfo;
    private Boolean deIdentified;
    private TypeFile typeFile;
    private TypeDatabase typeDatabase;





}
