package com.test.mongotest.Catalog.repository;

import com.test.mongotest.Catalog.model.CatalogAsset;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CatalogAssetRepository extends MongoRepository<CatalogAsset, String> {

    @Override
    Optional<CatalogAsset> findById(String s);

    //    @Query(value = "{ $sample: { size: 1.0 } }")
    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    CatalogAsset selectSampleRecord();

    Page<CatalogAsset> findByWorkspaceId(String workspaceId, Pageable pageable);

    Page<CatalogAsset> findByClientId(String clientId, Pageable pageable);

    Page<CatalogAsset> findByAssetId(String assetId, Pageable pageable);

    Page<CatalogAsset> findByWorkspaceIdAndTypeFile(String workspaceId, String typeFile, Pageable pageable);

    Page<CatalogAsset> findBySearchableIsTrue(Pageable pageable);

    Page<CatalogAsset> findByPwcTags(List<String> tags, Pageable pageable);

    Page<CatalogAsset> findByLocation(String location, Pageable pageable);

    List<CatalogAsset> searchCatalogAssetByNameOrDescription(String query);

    //TODO: Need to to filter searches based on searchable is true
    //TODO: Need to be able to search by Tags
    //TODO: Need to be able to search by atlas search on description
    //TODO: Need list of assets that are for single workspace, then all for the sample client if searchable is true and any other details user provides

}
