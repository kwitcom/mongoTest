package com.test.mongotest.model.group;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test.mongotest.model.Member;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "group")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group {
    @Id
    private String _id;
    private String groupId;
    private GroupType groupType;
    private String email;
    private String workspaceId;
    private List<Member> memberList;
}
