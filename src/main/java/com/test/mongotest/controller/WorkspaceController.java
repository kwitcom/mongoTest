package com.test.mongotest.controller;

import com.test.mongotest.WorkspaceService.model.DataConsentLevel;
import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.WorkspaceService.service.ClientService;
import com.test.mongotest.WorkspaceService.service.WorkspaceService;
import com.test.mongotest.model.OriginatingSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping("/workspace/{workspaceId}")
    Workspace findByWorkspaceId(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @PathVariable final String workspaceId
    ) {
        Workspace workspace = workspaceService.findByWorkspaceId(workspaceId);
        return workspace;
    }

    @GetMapping("/findByClientClientId")
    List<Workspace> findByClientClientId(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Client Id") String clientId
    ) {
        List<Workspace> workspaces = workspaceService.findByClientClientId(clientId);
        return workspaces;
    }
    @GetMapping("/findByUsersEmail")
    List<Workspace> findByUsersEmail(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "email") String email
    ) {
        List<Workspace> workspaces = workspaceService.findByUsersEmail(email);
        return workspaces;
    }
    @GetMapping("/findByClientClientIdAndDataConsentLevel")
    List<Workspace> findByClientClientIdAndDataConsentLevel(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "Client Id") String clientId,
            @RequestParam(name = "DataConsentLevel") DataConsentLevel dataConsentLevel
    ) {
        List<Workspace> workspaces = workspaceService.findByClientClientIdAndDataConsentLevel(clientId, dataConsentLevel);
        return workspaces;
    }

    @GetMapping("/findByOriginatingSite")
    List<Workspace> findByOriginatingSite(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "OriginatingSite") OriginatingSite originatingSite
    ) {
        List<Workspace> workspaces = workspaceService.findByOriginatingSite(originatingSite);
        return workspaces;
    }

    @GetMapping("/findByMetadataWbsCode")
    List<Workspace> findByMetadataWbsCode(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "wbscode") String wbscode
    ) {
        List<Workspace> workspaces = workspaceService.findByMetadataWbsCode(wbscode);
        return workspaces;
    }

    @GetMapping("/findByTagsIn")
    List<Workspace> findByTagsIn(
            @RequestParam(name = "Page Number", defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "Page Size", defaultValue = "10") Integer pageSize,
            @RequestParam(name = "wbscode") List<String> tags
    ) {
        List<Workspace> workspaces = workspaceService.findByTagsIn(tags);
        return workspaces;
    }
}
