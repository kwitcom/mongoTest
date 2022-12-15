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


    @GetMapping("/findByEmailPaged")
    List<AssetItem> findByEmailPaged(
            @RequestParam(name = "userEmail", defaultValue = "a43@aliceinwonderland.com") String userEmail,
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ) {
        return vizAssetService.findByEmailPaged(userEmail,pageNumber,pageSize);
    }
    @GetMapping("/findByEmail")
    List<AssetItem> findByEmail(
            @RequestParam(name = "userEmail", defaultValue = "a43@aliceinwonderland.com") String userEmail
    ) {
        return vizAssetService.findByEmail(userEmail);
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

    @GetMapping("/findAll")
    List<AssetItem> findAll(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ){
        List<AssetItem> assetItems = vizAssetService.findAll(pageNumber, pageSize);
        return assetItems;
    }
}
