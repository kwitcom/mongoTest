package com.test.mongotest.WorkspaceService.repository;


import com.test.mongotest.WorkspaceService.model.Workspace;
import com.test.mongotest.model.OriginatingSite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace, String> {
    List<Workspace> findByWorkspaceId(String workspaceId);
    List<Workspace> findByClientClientId(String clientId);
    List<Workspace> findByOriginatingSite(OriginatingSite originatingSite);
    List<Workspace> findByCountryCountryCode(String countryCode);
    List<Workspace> findByUsersUserId(String userId);
    List<Workspace> findByUsersEmail(String email);

    //TODO: Support filter by Tags
    //TODO: Advance search by items in WorkspaceMetadata
    //TODO: Search by clientId and dataConsentLevel
    //TODO: All that could return a list should be updated to support paging


}
