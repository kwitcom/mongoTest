package com.test.mongotest.controller;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.service.VizAssetService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viz/asset")
public class VizAssetController {
    @Autowired
    private VizAssetService vizAssetService;

    @PostMapping
    public String save(@RequestBody AssetItem asset) {
        return vizAssetService.save(asset);
    }


    @GetMapping("")
    List<AssetItem> getAssetsByUser(
            @Parameter(name = "userEmail", description = "Email Address", in = ParameterIn.QUERY) String userEmail
    ) {
        return vizAssetService.findByEmail(userEmail);
    }

    @GetMapping("/{assetId}")
    AssetItem getAssetById(@PathVariable final String assetId){
        return vizAssetService.findAssetItemByAssetId(assetId);
    }

}
