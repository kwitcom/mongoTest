package com.test.mongotest.controller;

import com.test.mongotest.Catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @PostMapping("/sample/assets")
    public void loadSampleData(){
        catalogService.loadSampleData();
    }

    @PostMapping("/sample/workspaces")
    public void loadSampleWorkspaces(){
        catalogService.loadSampleWorkspace();
    }

}

