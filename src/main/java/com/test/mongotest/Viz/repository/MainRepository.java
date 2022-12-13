package com.test.mongotest.Viz.repository;


import com.test.mongotest.Viz.model.asset.MainObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository extends MongoRepository<MainObject, String> {

    public long count();

    @Override
    List<MainObject> findAll();

    List<MainObject> findBySubObjectEmail(String email);

}
