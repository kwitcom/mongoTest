package com.test.mongotest.Viz.model.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.mongotest.Viz.model.Member;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "groups")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group {
    @Id
    private String _id;
//    private String groupId;
    @Indexed
    private GroupType groupType;
    @Indexed
    private String email;
    @Indexed
    private String workspaceId;
    private List<Member> memberList;
}
