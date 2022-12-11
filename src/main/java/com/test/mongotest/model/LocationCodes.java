package com.test.mongotest.model;

import lombok.Builder;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Builder
public class LocationCodes {
    public static List<String> LOCATION_CODES;

    static {
        LOCATION_CODES = Arrays.asList(Locale.getISOCountries());
    }

}
