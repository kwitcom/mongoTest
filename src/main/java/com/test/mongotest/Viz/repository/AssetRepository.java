package com.test.mongotest.Viz.repository;

import com.test.mongotest.Viz.model.asset.AssetItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface AssetRepository extends MongoRepository<AssetItem, String> {
    AssetItem findAssetItemByName(String name);
    AssetItem findAssetItemByAssetId(String assetId);
    public long count();

    public default List<AssetItem> findByEmail(String email) {
        List<AssetItem> resultList = new ArrayList<>();
        for (AssetItem item : this.findAll()) {
            if (item.getAccessList().contains(email)) {
                resultList.add(item);
            }
        }
        return resultList;
    }

}
