package com.test.mongotest.controller;

import com.test.mongotest.Catalog.service.CatalogService;
import com.test.mongotest.Viz.model.asset.MainObject;
import com.test.mongotest.Viz.service.EmailModelService;
import com.test.mongotest.Viz.service.GroupService;
import com.test.mongotest.Viz.service.MainService;
import com.test.mongotest.Viz.service.VizAssetService;
import com.test.mongotest.WorkspaceService.service.ClientService;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    @Autowired
    private MainService mainService;
    @Autowired
    private EmailModelService emailModelService;

    //        mainService.setupDB();
//        mainService.loadSampleData(100, 1);

//    @PostMapping("/loadSamples")
//    public void loadSampleVizAssets() {
//        emailModelService.loadSampleData(100, 1);
//        clientService.loadSampleData(100, 1);
//        workspaceService.loadSampleData(100, 1);
//        catalogService.loadSampleWorkspace();
//        groupService.loadSampleData(100,1);
//        vizAssetService.loadSampleData(30, 1);
//        catalogService.loadSampleData(100,1);
//    }
    @PostMapping("/loadSamples")
    public void loadSampleVizAssets() {
        workspaceService.setupDB();
        vizAssetService.setupDB();
        catalogService.setupDB();

        emailModelService.loadSampleData(100, 1);
        clientService.loadSampleData(100, 1);
        workspaceService.loadSampleData(100, 1);

        // Create a fixed thread pool with the number of threads equal to the number of submethods
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit the submethods to the executor to be run in parallel
        executor.submit(() -> catalogService.loadSampleWorkspace());
        executor.submit(() -> groupService.loadSampleData(100,1));
        executor.submit(() -> vizAssetService.loadSampleData(30,1 ));
        executor.submit(() -> catalogService.loadSampleData(100,1));

        // Shut down the executor
        executor.shutdown();
    }

    @GetMapping("/")
    List<MainObject> getAssetByEmail(
            @Parameter(name = "userEmail",
            description = "Email Address",
            in = ParameterIn.QUERY) String userEmail) {
        return mainService.findByEmail(userEmail);
    }
}
