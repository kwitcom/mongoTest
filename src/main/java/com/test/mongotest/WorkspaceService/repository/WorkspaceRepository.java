package com.test.mongotest.WorkspaceService.repository;


import com.test.mongotest.WorkspaceService.model.DataConsentLevel;
import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.model.OriginatingSite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace, String> {
    Workspace findByWorkspaceId(String workspaceId);

    List<Workspace> findByClientClientId(String clientId);

    List<Workspace> findByOriginatingSite(OriginatingSite originatingSite);

    List<Workspace> findByCountryCountryCode(String countryCode);

    List<Workspace> findByUsersUserId(String userId);

    List<Workspace> findByUsersEmail(String email);

    List<Workspace> findByMetadataWbsCode(String wbscode);

    List<Workspace> findByTagsIn(List<String> tags);

    List<Workspace> findByClientClientIdAndDataConsentLevel(String clientId, DataConsentLevel dataConsentLevel);
    List<Workspace> findByClientClientIdAndCountryCountryCode(String clientId, String Country);

    //TODO: Support filter by Tags
    //TODO: Filter by text by items in WorkspaceMetadata
    //TODO: Filter by clientId and dataConsentLevel
    //TODO: All that could return a list should be updated to support paging
}
