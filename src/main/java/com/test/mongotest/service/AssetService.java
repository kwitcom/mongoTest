package com.test.mongotest.service;

import com.test.mongotest.model.asset.AssetItem;

public interface AssetService {

    String save(AssetItem asset);

    void delete(String id);
}
