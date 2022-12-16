package com.test.mongotest.Catalog.model;

import com.test.mongotest.model.LocationCodes;
import com.test.mongotest.model.WordList;
import com.test.mongotest.utils.Utilities;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class TypeDatabase {
    private String databaseType;
    private String connectionString;
    private String environment;

    static List<String> databaseTypes = Arrays.asList(
            "relational", "non-relational", "flat-file",
            "graph", "document", "in-memory", "object-oriented",
            "columnar", "key-value", "network"
    );

    public TypeDatabase selectRandomType(){
        Random random = new Random();

        // Select a random index from the list of database types
        int index = random.nextInt(databaseTypes.size());
        this.databaseType = databaseTypes.get(index);
        this.connectionString = Utilities.generateRandomUUID() + WordList.generateSampleDescription();
        this.environment = LocationCodes.getRandomLocCode();

        return this;
    }
}

