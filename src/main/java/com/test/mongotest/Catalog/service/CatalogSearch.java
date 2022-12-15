package com.test.mongotest.Catalog.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.test.mongotest.Catalog.repository.CatalogAssetRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CatalogSearch {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private CatalogAssetRepository catalogAssetRepository;


    public void newSearch() {
        MongoCollection<Document> collection = mongoTemplate.getMongoDbFactory()
                .getMongoDatabase("glb-dev-test").
                getCollection("catalog_assets");
        // Create a search query using the MongoDB Query Builder
        Bson query = new Document("assetId", "dd9f13b5-5d9e-4979-9161-3634c57601c7");

        // Use the find() method to execute the search
        FindIterable<Document> result = collection.find(query);

        // Iterate over the search results and print them
        for (Document doc : result) {
            System.out.println(doc.toJson());
        }

    }
}
