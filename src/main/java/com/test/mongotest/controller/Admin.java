package com.test.mongotest.controller;

import com.test.mongotest.Catalog.service.CatalogService;
import com.test.mongotest.Viz.service.VizAssetService;
import com.test.mongotest.Viz.service.GroupService;
import com.test.mongotest.WorkspaceService.service.ClientService;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class Admin {
    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkspaceService workspaceService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private GroupService groupService;
    @Autowired
    private VizAssetService vizAssetService;

    @PostMapping("/loadSamples")
    public void loadSampleVizAssets() {
        clientService.loadSampleData(10, 1);
        workspaceService.loadSampleData(10, 1);
        catalogService.loadSampleWorkspace();
        groupService.loadSampleData(10,1);
        vizAssetService.loadSampleData(10, 1);
        catalogService.loadSampleData(10,1);
    }

}
