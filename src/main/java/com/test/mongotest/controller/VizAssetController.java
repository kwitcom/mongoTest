package com.test.mongotest.controller;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.service.VizAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    Page<AssetItem> findByEmailPaged(
            @RequestParam(name = "userEmail", defaultValue = "a43@aliceinwonderland.com") String userEmail,
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ) {
        return vizAssetService.findByEmailPaged(userEmail,pageNumber,pageSize);
    }
//    @GetMapping("/findByEmail")
//    List<AssetItem> findByEmail(
//            @RequestParam(name = "userEmail", defaultValue = "a43@aliceinwonderland.com") String userEmail
//    ) {
//        return vizAssetService.findByEmail(userEmail);
//    }

    @GetMapping("/{assetId}")
    AssetItem getAssetById(@PathVariable final String assetId){
        return vizAssetService.findAssetItemByAssetId(assetId);
    }

    @GetMapping("/AllInternal")
    Page<AssetItem> getAssetItemsBySharedToAllInternalRoleNotNONE(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ){
        Page <AssetItem> assetItems = vizAssetService.findAssetItemsBySharedToAllInternalRole(pageNumber, pageSize);
        return assetItems;
    }

    @GetMapping("/findAll")
    Page<AssetItem> findAll(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize
    ){
        Page<AssetItem> assetItems = vizAssetService.findAll(pageNumber, pageSize);
        return assetItems;
    }
}
