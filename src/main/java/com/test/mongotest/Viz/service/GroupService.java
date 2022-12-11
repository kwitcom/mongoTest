package com.test.mongotest.Viz.service;

import com.test.mongotest.Viz.model.group.Group;
import com.test.mongotest.Viz.model.group.GroupType;
import com.test.mongotest.Viz.repository.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class GroupService {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    GroupRepository groupRepository;

    // Use the GroupRepository to get all groups
    public List<Group> allGroups(){
        return groupRepository.findAll();
    }

    public String save(Group group) {
        return groupRepository.save(group).get_id();
    }

    public void delete(String id) {
        groupRepository.deleteById(id);
    }

    public Group getByEmail(String email) {
        try {
            return groupRepository.findGroupByEmail(email);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Group> getGroupsByWorkspaceIdAndGroupType(String workspaceId, String groupType) {
        return groupRepository.findGroupsByWorkspaceIdAndGroupType(workspaceId, groupType);
    }

    public void loadSampleData() {
        int batchSize = 100; // Number of records to generate and save per batch
        int numBatches = 5; // Number of batches to generate and save

        for (int i = 0; i < numBatches; i++) {
            List<Group> googleSample = generateSampleGroupMembership(batchSize, GroupType.GOOGLE);
            mongoTemplate.insertAll(googleSample);

            List<Group> externalSample = generateSampleGroupMembership(batchSize, GroupType.EXTERNAL_CONTACTS);
            mongoTemplate.insertAll(externalSample);

        }
    }

    private List<Group> generateSampleGroupMembership(int batchSize, GroupType groupType) {
        List<Group> sampleData = new ArrayList<>();

        for (int i = 0; i < batchSize; i++) {
            Group group = Group.builder()
                    .groupType(groupType)
                    .memberList(com.test.mongotest.Viz.utils.Utilities.generateSampleGroupMembership(groupType))
                    .build();
            sampleData.add(group);
        }
        return sampleData;
    }

    public Group getRandomGroup(){
        Random random = new Random();

        // Use the GroupService instance to get all groups
        List<Group> allGroups = this.allGroups();

        // Generate a random index between 0 and the size of the list
        int randomIndex = random.nextInt(allGroups.size());

        // Get the group at the random index
        Group randomGroup = allGroups.get(randomIndex);

        return randomGroup;
    }
}