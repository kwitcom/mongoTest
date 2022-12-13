package com.test.mongotest.Catalog.repository;

import com.test.mongotest.Catalog.model.CatalogAsset;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogAssetRepository extends MongoRepository<CatalogAsset, String> {

}
