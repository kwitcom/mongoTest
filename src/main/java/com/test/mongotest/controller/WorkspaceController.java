package com.test.mongotest.controller;

import com.test.mongotest.WorkspaceService.model.DataConsentLevel;
import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.WorkspaceService.service.ClientService;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.model.OriginatingSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {
    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping("/workspace/{workspaceId}")
    Workspace findByWorkspaceId(
            @PathVariable final String workspaceId
    ) {
        return workspaceService.findByWorkspaceId(workspaceId);
    }

    @GetMapping("/findByClientClientId")
    Page<Workspace> findByClientClientId(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Client Id") String clientId
    ) {
        return workspaceService.findByClientClientId(clientId, pageNumber, pageSize);
    }

    @GetMapping("/findByUsersEmail")
    Page<Workspace> findByUsersEmail(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "email") String email
    ) {
        return workspaceService.findByUsersEmail(email, pageNumber, pageSize);
    }

    @GetMapping("/findByClientClientIdAndDataConsentLevel")
    Page<Workspace> findByClientClientIdAndDataConsentLevel(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Client Id") String clientId,
            @RequestParam(name = "DataConsentLevel") DataConsentLevel dataConsentLevel
    ) {
        return workspaceService.findByClientClientIdAndDataConsentLevel(clientId, dataConsentLevel, pageNumber, pageSize);
    }

    @GetMapping("/findByOriginatingSite")
    Page<Workspace> findByOriginatingSite(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "OriginatingSite") OriginatingSite originatingSite
    ) {
        return workspaceService.findByOriginatingSite(originatingSite, pageNumber, pageSize);
    }

    @GetMapping("/findByMetadataWbsCode")
    Page<Workspace> findByMetadataWbsCode(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "wbscode") String wbscode
    ) {
        return workspaceService.findByMetadataWbsCode(wbscode, pageNumber, pageSize);
    }

    @GetMapping("/findByTagsIn")
    Page<Workspace> findByTagsIn(
            @RequestParam(name = "Page Number: Starting 0", defaultValue = "0") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "wbscode") List<String> tags
    ) {
        return workspaceService.findByTagsIn(tags, pageNumber, pageSize);
    }
}
