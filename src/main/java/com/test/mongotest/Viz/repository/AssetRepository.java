package com.test.mongotest.Viz.repository;

import com.test.mongotest.Viz.model.asset.AssetItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends MongoRepository<AssetItem, String> {
    AssetItem findAssetItemByName(String name);
    AssetItem findAssetItemByAssetId(String assetId);
    public long count();

    @Query("{ 'accessList.email': ?0 }")
    public List<AssetItem> findByEmail(String email);

}
