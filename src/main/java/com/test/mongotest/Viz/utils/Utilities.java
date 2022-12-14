package com.test.mongotest.Viz.utils;

import com.test.mongotest.Viz.model.Member;
import com.test.mongotest.Viz.model.asset.Access;
import com.test.mongotest.Viz.model.asset.AccessRole;
import com.test.mongotest.Viz.model.asset.ApprovalStatus;
import com.test.mongotest.Viz.model.asset.AssetType;
import com.test.mongotest.Viz.model.group.GroupType;
import com.test.mongotest.Viz.repository.EmailModelRepository;
import com.test.mongotest.model.Domains;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class Utilities {
    @Autowired
    private EmailModelRepository emailModelRepository;

    public List<Access> generateSampleAccessList() {
        List<Access>  accessList = new ArrayList<>();
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate a random number between 0 and 10 (inclusive)
        int count = random.nextInt(31);
        for (int n = 0; n < count; n++) {

                String randomEmail = emailModelRepository.findByEmailAddressEndsWith("").getEmailAddress();
                Access reportAccess = Access.builder()
                        .accessRole(selectRandomAccessRole())
                        .email(randomEmail)
                        .fullName(randomEmail)
                        .type("USER")
                        .approvalTrackingId(UUID.randomUUID().toString())
                        .approvalStatus(selectApprovalStatus())
                        .build();
                accessList.add(reportAccess);
        }
        return accessList;
    }


    public List<Member> generateSampleGroupMembership(GroupType groupType) {
        List<Member> Members = new ArrayList<>();
        Random random = new Random();

        // Generate a random number between 0 and 10 (inclusive)
        int count = random.nextInt(31);
        for (int n = 0; n < count; n++) {
            String domainName = "pwc.com";
            if (groupType == GroupType.GOOGLE) {
                domainName = "pwc.com";
            } else {
                domainName = Domains.selectRandomDomain();
            }
            String randomEmail = emailModelRepository.findByEmailAddressEndsWith(domainName).getEmailAddress();
            Member member = Member.builder()
                    .email(randomEmail)
                    .fullName(randomEmail)
                    .build();
            Members.add(member);
        }
        return Members;
    }

    public static AccessRole selectRandomAccessRole() {
        // Create a new Random instance
        Random random = new Random();

        // Get all the values of the AccessRole enum
        Set<AccessRole> accessRoles = EnumSet.allOf(AccessRole.class);

        // Select a random index from the set of access roles
        int index = random.nextInt(accessRoles.size());

        // Get the access role at the selected index
        AccessRole accessRole = accessRoles.toArray(new AccessRole[accessRoles.size()])[index];

        return accessRole;
    }

    public static ApprovalStatus selectApprovalStatus() {
        // Create a new Random instance
        Random random = new Random();

        // Get all the values of the AccessRole enum
        Set<ApprovalStatus> approvalStatuses = EnumSet.allOf(ApprovalStatus.class);

        // Select a random index from the set of access roles
        int index = random.nextInt(approvalStatuses.size());

        // Get the access role at the selected index
        ApprovalStatus approvalStatus = approvalStatuses.toArray(new ApprovalStatus[approvalStatuses.size()])[index];

        return approvalStatus;
    }

    public static AssetType selectAssetType() {
        // Create a new Random instance
        Random random = new Random();

        // Get all the values of the AccessRole enum
        Set<AssetType> assetTypes = EnumSet.allOf(AssetType.class);

        // Select a random index from the set of access roles
        int index = random.nextInt(assetTypes.size());

        // Get the access role at the selected index
        AssetType assetType = assetTypes.toArray(new AssetType[assetTypes.size()])[index];

        return assetType;
    }


}
