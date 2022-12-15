package com.test.mongotest.controller;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.service.VizAssetService;
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
            @RequestParam(name = "userEmail", defaultValue = "a43@aliceinwonderland.com") String userEmail,
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ) {
        return vizAssetService.findByEmail(userEmail,pageNumber,pageSize);
    }

    @GetMapping("/{assetId}")
    AssetItem getAssetById(@PathVariable final String assetId){
        return vizAssetService.findAssetItemByAssetId(assetId);
    }

    @GetMapping("/AllInternal")
    List<AssetItem> getAssetItemsBySharedToAllInternalRoleNotNONE(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ){
        List<AssetItem> assetItems = vizAssetService.findAssetItemsBySharedToAllInternalRole(pageNumber, pageSize);
        return assetItems;
    }
}
