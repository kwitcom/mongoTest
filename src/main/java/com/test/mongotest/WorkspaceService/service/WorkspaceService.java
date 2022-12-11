package com.test.mongotest.WorkspaceService.service;

import com.test.mongotest.WorkspaceService.repository.WorkspaceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class WorkspaceService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private WorkspaceRepository workspaceRepository;

}
