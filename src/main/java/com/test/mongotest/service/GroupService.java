package com.test.mongotest.service;

import com.test.mongotest.model.group.Group;
import com.test.mongotest.repository.GroupRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GroupService {

    @Autowired
    GroupRepository groupRepository;

    public String save(Group group) {
        return groupRepository.save(group).get_id();
    }

    public void delete(String id) {
        groupRepository.deleteById(id);
    }

    public Group getByEmail(String email)  {
        try {
            return groupRepository.findGroupByEmail(email);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Group> getGroupByWorkspaceIdAAndTAndGroupType(String workspaceId, String groupType){
        return groupRepository.findGroupByWorkspaceIdAAndTAndGroupType(workspaceId,groupType);
    }
}
