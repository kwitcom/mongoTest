package com.test.mongotest.WorkspaceService.repository;

import com.test.mongotest.WorkspaceService.model.WorkspaceUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkspaceUserRepository extends MongoRepository<WorkspaceUser, String> {
    public long count();
}

