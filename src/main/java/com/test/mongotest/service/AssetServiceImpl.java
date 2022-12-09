package com.test.mongotest.service;

import com.test.mongotest.model.asset.AssetItem;
import com.test.mongotest.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

//    @Autowired
//    private MongoTemplate mongoTemplate;


    @Override
    public String save(AssetItem asset) {
        return assetRepository.save(asset).getAssetId();
    }

    @Override
    public void delete(String id) {
        assetRepository.deleteById(id);
    }
}
