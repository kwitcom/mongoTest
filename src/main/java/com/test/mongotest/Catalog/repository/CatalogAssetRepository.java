package com.test.mongotest.Catalog.repository;

import com.test.mongotest.Catalog.model.CatalogAsset;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CatalogAssetRepository extends MongoRepository<CatalogAsset, String> {

    @Override
    Optional<CatalogAsset> findById(String s);

}
