package com.test.mongotest.repository;

import com.test.mongotest.model.group.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

    List<Group> findGroupByWorkspaceIdAAndTAndGroupType(String workspaceId, String groupType);

    Group findGroupByEmail(String email);

    public long count();
}
