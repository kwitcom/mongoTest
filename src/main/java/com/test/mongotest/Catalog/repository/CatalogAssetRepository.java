package com.test.mongotest.Catalog.repository;

import com.test.mongotest.Catalog.model.CatalogAsset;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CatalogAssetRepository extends MongoRepository<CatalogAsset, String> {

    @Override
    Optional<CatalogAsset> findById(String s);

    //    @Query(value = "{ $sample: { size: 1.0 } }")
    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    CatalogAsset selectSampleRecord();

    List<CatalogAsset> findByWorkspaceId(String workspaceId);

    List<CatalogAsset> findByClientId(String clientId);

    List<CatalogAsset> findByAssetId(String assetId);

    List<CatalogAsset> findByWorkspaceIdAndTypeFile(String workspaceId, String typeFile);

    @Aggregation(pipeline = "{}",value = "{}")
    @Query(value = "{}", fields = "{}")
    List<CatalogAsset> test();


    @Aggregation(pipeline = {"{$search: {index: 'default',text: {query: 'Franchise',path: {'wildcard': '*'}}}}"})
    List<CatalogAsset> test3();

    //TODO: Need to to filter searches based on searchable is true
    //TODO: Need to be able to search by Tags
    //TODO: Need to be able to search by atlas search on description
    //TODO: Need list of assets that are for single workspace, then all for the sample client if searchable is true and any other details user provides

}
