package com.test.mongotest.Viz.model.asset;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.List;

@Data
@Builder
@Document(collection = "test")
@Sharded(shardKey = {"location","assetId"})
public class MainObject {
    @Id
    private String id;
    @Indexed
    private String assetId;
    @Indexed
    private String location;
    @Field
    private List<SubObject> subObject;
}
