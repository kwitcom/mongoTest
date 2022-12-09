package com.test.mongotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class MongotestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MongotestApplication.class, args);

//        ConnectionString connectionString = new ConnectionString("mongodb+srv://db_user_viz_1:z4Sxd67H9k0Z8pec@glb-dev.g6r6v.mongodb.net/glb-dev-vizinsights?tls=true&tlsInsecure=true");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//        MongoClient mongoClient = MongoClients.create(mongoClientSettings);
//        MongoDatabase db = mongoClient.getDatabase("glb-dev-vizinsights");
//        MongoCollection<Document> col =  db.getCollection("viz_assets");
//        Document doc = new Document();
//        doc.put("name", "josh");
//        doc.put("loc", "MX");
//        col.insertOne(doc);

    }



}
