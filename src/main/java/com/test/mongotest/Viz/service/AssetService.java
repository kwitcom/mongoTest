package com.test.mongotest.Viz.service;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.repository.AssetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public String save(AssetItem asset) {
        return assetRepository.save(asset).getAssetId();
    }

    public void delete(String id) {
        assetRepository.deleteById(id);
    }
}
