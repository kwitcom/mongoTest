package com.test.mongotest.Viz.model.asset;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.List;

@Data
@Builder
@Document(collection = "viz_assets")
@CompoundIndex(def = "{'location': 1, 'assetId': 1}")
@Sharded(shardKey = {"location", "assetId"}, immutableKey = true)
public class AssetItem {

    @Id
    private String id;
    @Field
    private List<Access> accessList;
    @Indexed
    private String assetId;
    @Indexed
    private String biToolAssetId;
    @Indexed
    private String name;
    private String location;
    private String description;
    private AssetType assetType;
    private String biType;
    private String workspaceId;
    private String thumbnailImagePath;
    private Boolean isReadOnly;
    private Boolean isVisible;
    private Boolean isShared;
    private String shareLink;
    @Field
    private AccessRole sharedToAllInternalRole;
    @Field
    private AccessRole externalContactsShareAccessRole;

}
