package com.test.mongotest.utils;

import com.test.mongotest.model.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utilities {

    private static LocationCodes loc;
    private static WordList words;
    private static PwCTags pwCTags;

    public static String getRandomLocCode(){
        Random random = new Random();
        // Generate a random number within the range of the size of the list of location ISO codes
        int randomIndex = random.nextInt(loc.LOCATION_CODES.size());

        // Use the random number as the index to select a location ISO code from the list
        String randomLocationIsoCode = loc.LOCATION_CODES.get(randomIndex);

        return randomLocationIsoCode;
    }

    public static String generateSampleDescription(){
        // Create a Random object to generate random numbers
        Random random1 = new Random();

        // Use a StringBuilder to build the description
        StringBuilder descriptionBuilder = new StringBuilder();

        // Add a random number of words to the description
        int numWords = random1.nextInt(30) + 3;
        for (int n = 0; n < numWords; n++) {
            // Generate a random number within the range of the size of the list of words
            int randomIndex1 = random1.nextInt(words.Words.size());

            // Use the random number as the index to select a word from the list
            String word = words.Words.get(randomIndex1);

            // Append the word to the description
            descriptionBuilder.append(word);

            // Add a space after the word, unless it's the last word
            if (n < numWords - 1) {
                descriptionBuilder.append(" ");
            }
        }
        String description = descriptionBuilder.toString();
        return description;
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
    public static String selectRandomDomain(){
        // Create a new Random instance
        Random random = new Random();

        // Select a random index from the list of domains
        int index = random.nextInt(Domains.Domains.size());

        // Get the domain at the selected index
        String domain = Domains.Domains.get(index);
        return domain;
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

    public static String selectRandomWorkspaceId(){
        // Create a new Random instance
        Random random = new Random();

        // Select a random index from the list of domains
        int index = random.nextInt(WorkspaceIds.Ids.size());

        // Get the domain at the selected index
        String workspaceId = WorkspaceIds.Ids.get(index);
        return workspaceId;
    }
}
