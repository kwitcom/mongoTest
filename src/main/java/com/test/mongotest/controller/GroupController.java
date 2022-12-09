package com.test.mongotest.controller;

import com.test.mongotest.model.group.Group;
import com.test.mongotest.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("")
    public Group getGroupByEmail(@RequestParam String email){
        return groupService.getByEmail(email);
    }

}
