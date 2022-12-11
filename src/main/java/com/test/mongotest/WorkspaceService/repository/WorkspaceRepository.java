package com.test.mongotest.WorkspaceService.repository;


import com.test.mongotest.WorkspaceService.model.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace, String> {

    public long count();

}
