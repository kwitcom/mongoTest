package com.test.mongotest.Viz.service;

import com.test.mongotest.Viz.model.group.Group;
import com.test.mongotest.Viz.model.group.GroupType;
import com.test.mongotest.Viz.repository.GroupRepository;
import com.test.mongotest.Viz.utils.Utilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private EmailModelService emailModelService;
    @Autowired
    private Utilities util;

    public List<Group> allGroups() {
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

    public void loadSampleData(Integer batchSize, Integer numBatches) {
        for (int i = 0; i < numBatches; i++) {
            generateSampleGroupMembership(batchSize, GroupType.GOOGLE);
            generateSampleGroupMembership(batchSize, GroupType.EXTERNAL_CONTACTS);
        }
    }
    private void generateSampleGroupMembership(int batchSize, GroupType groupType) {
        IntStream.range(0, batchSize)
                // Use parallel stream to process the elements in parallel
                .parallel()
                // For each integer in the stream, generate a sample email model and save it
                .forEach(i -> {
                    Group group = Group.builder()
                            .groupType(groupType)
                            .memberList(util.generateSampleGroupMembership(groupType))
                            .build();
                    groupRepository.save(group);
                });
    }

    public Group getRandomGroup() {
        return groupRepository.selectSampleRecord();
    }
}