package com.test.mongotest.Viz.model.asset;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Access {
    @Indexed
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
    private List<AccessVia> accessVia;
}
