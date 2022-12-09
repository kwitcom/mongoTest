package com.test.mongotest.Catalog.repository;

import com.test.mongotest.Viz.model.group.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CatalogAssetRepository extends MongoRepository<Group, String> {

}
