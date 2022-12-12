package com.test.mongotest.controller;

import com.test.mongotest.WorkspaceService.service.ClientService;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkspaceService workspaceService;


}
