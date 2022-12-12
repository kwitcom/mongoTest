package com.test.mongotest.WorkspaceService.repository;

import com.test.mongotest.WorkspaceService.model.WorkspaceClient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<WorkspaceClient, String> {


}
