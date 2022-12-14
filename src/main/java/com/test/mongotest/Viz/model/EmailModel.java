package com.test.mongotest.Viz.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "email_collection")
public class EmailModel {
    @Id
    private String _id;
    @Indexed
    private String emailAddress;
}
