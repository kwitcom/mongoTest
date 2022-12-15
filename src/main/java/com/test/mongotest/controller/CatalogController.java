package com.test.mongotest.controller;

import com.test.mongotest.Catalog.model.CatalogAsset;
import com.test.mongotest.Catalog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("test3")
    public List<CatalogAsset> search1(){
        return catalogService.search1();
    }

}

