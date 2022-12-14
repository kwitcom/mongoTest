package com.test.mongotest.Viz.model.asset;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Sharded;

import java.util.List;

@Data
@Builder
@Document(collection = "test")
@CompoundIndex(def = "{'location': 1, 'assetId': 1}")
@Sharded(shardKey = {"location", "assetId"}, immutableKey = true)
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
