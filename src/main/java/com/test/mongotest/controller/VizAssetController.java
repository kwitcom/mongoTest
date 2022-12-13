package com.test.mongotest.controller;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.service.VizAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/viz/asset")
public class VizAssetController {
    @Autowired
    private VizAssetService vizAssetService;

    @PostMapping
    public String save(@RequestBody AssetItem asset) {
        return vizAssetService.save(asset);
    }


//    @GetMapping("")
//    List<AssetItem> getAssetsByUser(
//            @Parameter(name = "userEmail", description = "Email Address", in = ParameterIn.QUERY) Optional<String> userEmail
//    ) {
//        return vizAssetService.getAssetsByEmail(String.valueOf(userEmail));
//    }



}
