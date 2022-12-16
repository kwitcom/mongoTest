package com.test.mongotest.controller;

import com.test.mongotest.Catalog.model.CatalogAsset;
import com.test.mongotest.Catalog.service.CatalogService;
import com.test.mongotest.WorkspaceService.model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/findByWorkspaceId")
    Page<CatalogAsset> findByWorkspaceId(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "WorkspaceId") String workspaceId
    ) {
        return catalogService.findByWorkspaceId(workspaceId, pageNumber, pageSize);
    }

    @GetMapping("/findByPwcTags")
    Page<CatalogAsset> findByPwcTags(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "tags") List<String> tags
    ) {
        return catalogService.findByPwcTags(tags, pageNumber, pageSize);
    }

    @GetMapping("/findByClientId")
    Page<CatalogAsset> findByClientId(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "clientId") String clientId
    ) {
        return catalogService.findByClientId(clientId, pageNumber, pageSize);
    }

    @GetMapping("/findByClientId")
    Page<CatalogAsset> findByLocation(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Location ISO Code") String location
    ) {
        return catalogService.findByLocation(location, pageNumber, pageSize);
    }
}

