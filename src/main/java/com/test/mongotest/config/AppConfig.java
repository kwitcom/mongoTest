package com.test.mongotest.config;

import com.test.mongotest.Viz.service.VizAssetService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class AppConfig {

    @Bean(name = "vizAssetServiceConfigured")
    @DependsOn("mongoTemplate")
    public VizAssetService vizAssetService() {
        VizAssetService service = new VizAssetService();
        service.setupDB();
        return service;
    }
}
