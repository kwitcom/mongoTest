package com.test.mongotest.Catalog.repository;

import com.test.mongotest.Catalog.model.CatalogAsset;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CatalogAssetRepository extends MongoRepository<CatalogAsset, String> {

    @Override
    Optional<CatalogAsset> findById(String s);

//    @Query(value = "{ $sample: { size: 1.0 } }")
    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    CatalogAsset selectSampleRecord();


}
