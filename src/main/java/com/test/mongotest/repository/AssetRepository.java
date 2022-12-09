package com.test.mongotest.repository;

import com.test.mongotest.model.asset.AssetItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends MongoRepository<AssetItem, String> {

    AssetItem findAssetItemByName(String name);

    AssetItem findAssetItemByAssetId(String assetId);
    public long count();

}
