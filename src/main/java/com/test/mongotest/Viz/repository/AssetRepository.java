package com.test.mongotest.Viz.repository;

import com.test.mongotest.Viz.model.asset.AssetItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends MongoRepository<AssetItem, String> {
    AssetItem findAssetItemByAssetId(String assetId);

    // Recommended way
    List<AssetItem> findByAccessListEmail(String email);

    List<AssetItem> findByWorkspaceId(String workspaceId);

    //TODO: If email is of (x Domain and externalContactsShareAccessRole is something other than 'NONE') or is in accessList return in array

    // Backup way
    @Query(value = "{'accessList.email': ?0}")
    List<AssetItem> getAssetsByUser(String email);


}
