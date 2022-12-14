package com.test.mongotest.Viz.repository;

import com.test.mongotest.Viz.model.group.Group;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends MongoRepository<Group, String> {

    List<Group> findGroupsByWorkspaceIdAndGroupType(String workspaceId, String groupType);

    Group findGroupByEmail(String email);

    public long count();

    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    Group selectSampleRecord();

}
