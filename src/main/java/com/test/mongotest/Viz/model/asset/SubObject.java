package com.test.mongotest.Viz.model.asset;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document()
public class SubObject {
    @Field
    private String email;
    private String fullName;
    private AccessRole accessRole;
}
