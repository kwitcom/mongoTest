package com.test.mongotest.Viz.model.asset;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class Access {
    @Field
    private String email;
    private String type;
    private String fullName;
    private AccessRole accessRole;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXXXX", timezone = "Z")
    private Instant lastUserAccessDate;
    @Indexed
    private Object approvalTrackingId;
    @Indexed
    private ApprovalStatus approvalStatus;
    @Field
    private List<AccessVia> accessVia;
}
