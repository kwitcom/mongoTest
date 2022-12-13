package com.test.mongotest.model;

import lombok.Builder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@Builder
public class LocationCodes {
    public static List<String> LOCATION_CODES;

    static {
        LOCATION_CODES = Arrays.asList(Locale.getISOCountries());
    }
    public static String getRandomLocCode(){
        Random random = new Random();
        // Generate a random number within the range of the size of the list of location ISO codes
        int randomIndex = random.nextInt(LOCATION_CODES.size());

        // Use the random number as the index to select a location ISO code from the list
        String randomLocationIsoCode = LOCATION_CODES.get(randomIndex);

        return randomLocationIsoCode;
    }
}
