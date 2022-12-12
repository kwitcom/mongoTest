package com.test.mongotest.controller;

import com.test.mongotest.Viz.model.asset.AssetItem;
import com.test.mongotest.Viz.service.VizAssetService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/viz/asset")
public class VizAssetController {
    @Autowired
    private VizAssetService vizAssetService;

    @PostMapping
    public String save(@RequestBody AssetItem asset) {
        return vizAssetService.save(asset);
    }

    @Operation(
            operationId = "getAssetsByUser",
            summary = "Get list of assets for a user across workspaces",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = AssetItem.class)))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/viz/assets",
            produces = {"application/json"}
    )
    ResponseEntity<List<AssetItem>> getAssetsByUser(
            @Parameter(name = "userEmail", description = "Email Address", in = ParameterIn.QUERY) Optional<String> userEmail
    ) {
        // TODO create service function to this - controller should not directly use a repository
//        List<AssetEntity> la = assetRepository.findAssetsByUserEmail(userEmail.orElse(""));
//        List<SharedAssetDetails> las = la.stream().map(asset -> AssetEntityMapper.INSTANCE.assetEntityToSharedAsset(asset)).collect(Collectors.toList());
//        return ResponseEntity.ok(las);
        throw new RuntimeException("Not Implemented");
    }



}
