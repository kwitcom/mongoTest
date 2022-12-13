package com.test.mongotest.Viz.model.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.List;

@Data
@Builder
@Document(collection = "viz_assets")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Sharded(shardKey = {"assetId"})
public class AssetItem {
    @Indexed(name="test_index", direction = IndexDirection.DESCENDING, unique = true, background = true)
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
    private AccessRole sharedToAllInternalRole;
    private AccessRole externalContactsShareAccessRole;
    @Field
    private List<Access> accessList;

}
