package com.test.mongotest.Viz.repository;

import com.test.mongotest.Viz.model.EmailModel;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailModelRepository extends MongoRepository<EmailModel, String> {

    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    EmailModel selectSampleRecord();

    @Query(value = "{'emailAddress': { $regex: ?0, $options: 'i' } }")
    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    EmailModel selectSampleRecordByDomain(String domain);

    @Aggregation(value = "{ $sample: { size: 1.0 } }")
    EmailModel findByEmailAddressEndsWith(String domain);
}
