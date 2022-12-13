package com.test.mongotest.Viz.model.asset;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessVia {
    @NonNull
    @Indexed
    private AccessViaType type;
    @NonNull
    private AccessRole accessRole;
    @Indexed
    private String email;
    @Indexed
    private String groupName;
    @Indexed
    private String groupObjectId;
    @Indexed
    private String workspaceId;
}
