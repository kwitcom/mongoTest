package com.test.mongotest.Catalog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.test.mongotest.model.OriginatingSite;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@Document(collection = "catalog_assets")
@CompoundIndex(def = "{'location': 1, 'assetId': 1}")
@Sharded(shardKey = {"location", "assetId"}, immutableKey = true)
public class CatalogAsset {
    @Indexed
    private String qualifiedName;
    private String assetId;
    private String name;
    private String description;
    private String userDescription;
    private String owner;
    @Field
    private List<CatalogAssetTypeName> typeName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant createTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant updateTime;
    private String location; //This will be an issue with Mongo
    private OriginatingSite registrationSourceSystem;
    private String territory;
    private List<String> restrictedTerritories;
    private List<String> primarySubjects;
    private Boolean searchable;
    private String resourceStatus;
    private String accessRequestUrl;
    private String accessRequestInstructions;
    private String previewInfo;
    private Boolean deIdentified;
    private String typeFile;
    private TypeDatabase typeDatabase;
    private List<String> relations;
    @Field
    private List<String> pwcTags;
    private String size;
    private String extension;
    private String workspaceId;
    private String workspaceName;
    private String clientId;
    private String clientName;
    private String connectionString;
    private String environment;
    private String dataCitationFormat;
    private String dataCopyright;
    private String dataLicensedUserbase;
    private String dataSource;
    private String dataPublicationFrequency;
    private String thirdPartyDataTermsOfUse;
    private List<String> dataRegulations;
    private String additionalReferencesLabel;
    private String additionalReferencesUrl;
    private String classifications_ownership_type;
    private String classifications_consent_level;
    private String classifications_isp_classification_level;
    private String demoAttr;
    private List<String> dynamicAttributes;
}
