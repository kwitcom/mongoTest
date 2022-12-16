package com.test.mongotest.WorkspaceService.repository;


import com.test.mongotest.WorkspaceService.model.DataConsentLevel;
import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.model.OriginatingSite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace, String> {
    Workspace findByWorkspaceId(String workspaceId);

    Page<Workspace> findByClientClientId(String clientId, Pageable pageable);

    Page<Workspace> findByOriginatingSite(OriginatingSite originatingSite, Pageable pageable);

    Page<Workspace> findByCountryCountryCode(String countryCode, Pageable pageable);

    Page<Workspace> findByUsersUserId(String userId, Pageable pageable);

    Page<Workspace> findByUsersEmail(String email, Pageable pageable);

    Page<Workspace> findByMetadataWbsCode(String wbscode, Pageable pageable);

    Page<Workspace> findByTagsIn(List<String> tags, Pageable pageable);

    Page<Workspace> findByClientClientIdAndDataConsentLevel(String clientId, DataConsentLevel dataConsentLevel, Pageable pageable);
    Page<Workspace> findByClientClientIdAndCountryCountryCode(String clientId, String Country, Pageable pageable);

    //TODO: Support filter by Tags
    //TODO: Filter by text by items in WorkspaceMetadata
    //TODO: Filter by clientId and dataConsentLevel
    //TODO: All that could return a list should be updated to support paging
}
