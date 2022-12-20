package com.test.mongotest.controller;

import com.mongodb.client.AggregateIterable;
import com.test.mongotest.Catalog.model.CatalogAsset;
import com.test.mongotest.Catalog.service.CatalogService;
import com.test.mongotest.WorkspaceService.model.Workspace;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findByLocation")
    Page<CatalogAsset> findByLocation(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Location ISO Code") String location
    ) {
        return catalogService.findByLocation(location, pageNumber, pageSize);
    }

    @GetMapping("/search1")
    AggregateIterable<Document> search1() {
        return catalogService.search1();
    }

    @GetMapping("/search2")
    Page<Document> search2(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Search String", defaultValue = "Productivity") String query
    ) {
        return catalogService.search2(query, pageNumber, pageSize);
    }

}

