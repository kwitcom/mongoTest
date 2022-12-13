package com.test.mongotest.utils;

import com.test.mongotest.model.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utilities {

    private static LocationCodes loc;
    private static WordList words;
    private static PwCTags pwCTags;
    private static LineOfService lineOfService;
    private static ClientNames clientNames;
    private static WorkspaceNameSamples workspaceNameSamples;

    public static OriginatingSite selectRandomOriginatingSite(){
        Random random = new Random();
        // Create a list of all the possible LineOfService values
        OriginatingSite[] values = OriginatingSite.values();
        // Check if the list of values is empty
        if (values.length == 0) {
            // If the list is empty, throw an exception
            throw new IllegalArgumentException("The list of values cannot be empty");
        }
        int index = random.nextInt(values.length);
        return values[index];
    }

    public static LineOfService selectRandomLineOfService(){
        Random random = new Random();
        // Create a list of all the possible LineOfService values
        LineOfService[] values = LineOfService.values();
        // Check if the list of values is empty
        if (values.length == 0) {
            // If the list is empty, throw an exception
            throw new IllegalArgumentException("The list of values cannot be empty");
        }
        int index = random.nextInt(values.length);
        return values[index];
    }

    public static Boolean generateRandomBoolean(){
        Random random = new Random();
        return random.nextBoolean();
    }
    public static String generateRandomUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    public static List<String> generateRandomTagList(){
        // Create a Random object to generate random numbers
        Random random = new Random();

        // Generate a random number of tags between 0 and 3
        int numTags = random.nextInt(4);

        // Use the PwCTags class to get a list of tags
        List<String> tags = pwCTags.Tags;

        // Create a sublist of the selected number of tags from the list of tags
        List<String> randomTags = tags.subList(0, numTags);

        return randomTags;
    }

    public static String generateRandomEmail(String domainName){

        String emailAddress = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while (emailAddress.length() < 5) {
            int character = (int) (Math.random() * 26);
            emailAddress += alphabet.substring(character, character + 1);
            emailAddress += Integer.valueOf((int) (Math.random() * 99)).toString();
            emailAddress += "@" + domainName;
        }
        return emailAddress;
    }


    public static Instant generateStartDate() {
        Random random = new Random();

        // Generate random year, month, and day for start date
        int startYear = 1970 + random.nextInt(50); // 1970-2019
        int startMonth = random.nextInt(12) + 1; // 1-12
        int startDay = random.nextInt(28) + 1; // 1-28

        // Create start date using random year, month, and day
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        // Convert LocalDate to Instant
        Instant instant = startDate.atStartOfDay().toInstant(ZoneOffset.UTC);

        return instant;
    }

    public static Instant generateEndDate(Instant startdate) {
        Random random = new Random();

        ZonedDateTime zonedStartDateTime = startdate.atZone(ZoneOffset.UTC);

        // Generate random year, month, and day for end date
        int endYear = zonedStartDateTime.getYear() + random.nextInt(5); // startYear-startYear+4
        int endMonth = random.nextInt(12) + 1; // 1-12
        int endDay = random.nextInt(28) + 1; // 1-28

        // Create end date using random year, month, and day
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
        // Convert LocalDate to Instant
        Instant instant = endDate.atStartOfDay().toInstant(ZoneOffset.UTC);
        return instant;
    }


}
