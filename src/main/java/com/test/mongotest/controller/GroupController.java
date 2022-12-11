package com.test.mongotest.controller;

import com.test.mongotest.Viz.model.group.Group;
import com.test.mongotest.Viz.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public String save(@RequestBody Group group) {return groupService.save(group);}

    @DeleteMapping("/{id}")
    public void delete( @PathVariable final String id){
        groupService.delete(id);
    }

    @GetMapping("")
    public Group getGroupByEmail(@RequestParam String email){
        return groupService.getByEmail(email);
    }

    @GetMapping("/workspace/{workspaceId}")
    public List<Group> getGroupsByWorkspaceIdAndGroupType(@PathVariable final String workspaceId, @RequestParam String groupType){
        return groupService.getGroupsByWorkspaceIdAndGroupType(workspaceId, groupType);
    }

    @PostMapping("/loadSamples")
    public void loadSampleGroups(){
        groupService.loadSampleData();
    }

    @GetMapping("/getAllGroups")
    public List<Group> getAllGroups(){
        return groupService.allGroups();
    }

    @GetMapping("/getRandomGroup")
    public Group getRandomGroup(){
        return groupService.getRandomGroup();
    }
}
