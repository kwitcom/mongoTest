package com.test.mongotest.model.asset;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.mongotest.model.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Access {
    private String email;
    private String type;
    private String fullName;
    private AccessRole accessRole;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant lastUserAccessDate;
    private Object approvalTrackingId;
    private ApprovalStatus approvalStatus;
    private List<Member> members;
    private String groupId;
}
