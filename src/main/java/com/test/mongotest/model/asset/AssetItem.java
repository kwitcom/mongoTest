package com.test.mongotest.model.asset;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "asset")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AssetItem {

    private String assetId;
    private String biToolAssetId;
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
    private List<Access> accessList;

}
