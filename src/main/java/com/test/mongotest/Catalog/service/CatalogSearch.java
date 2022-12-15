package com.test.mongotest.Catalog.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.test.mongotest.Catalog.repository.CatalogAssetRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

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

    // Atlas Search Query - Search across name and description
    private static void searchCatalog(MongoCollection<Document> catalog_assets) {
        List<Document> result = catalog_assets.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "default")
                        .append("text",
                                new Document("query", "Productivity")
                                        .append("path", Arrays.asList("name", "description"))
                                        .append("fuzzy",
                                                new Document("maxEdits", 2L)))))).into(new ArrayList<>());
        result.forEach(printDocuments());
    }

    private static Consumer<Document> printDocuments() {
        return doc -> System.out.println(doc.toJson(JsonWriterSettings.builder().indent(true).build()));
    }
}
