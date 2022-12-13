package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Builder
public class ClientNames {

    public static List<String> Names;

    static {
        Names = Arrays.asList(
                "Apple",
                "Amazon",
                "Facebook",
                "Alphabet",
                "Tesla",
                "Netflix",
                "Disney",
                "Procter & Gamble",
                "Coca-Cola",
                "Johnson & Johnson",
                "Exxon Mobil",
                "PepsiCo",
                "Intel",
                "Nike",
                "IBM",
                "Goldman Sachs",
                "Morgan Stanley",
                "JP Morgan Chase",
                "CVS Health",
                "Walt Disney",
                "Merck",
                "Chevron",
                "Verizon",
                "Cisco Systems",
                "American Express",
                "Philip Morris International",
                "The Home Depot",
                "Comcast",
                "Walmart",
                "Caterpillar",
                "Pfizer",
                "Boeing",
                "AT&T",
                "Dow",
                "3M",
                "Express Scripts",
                "Honeywell",
                "DuPont",
                "Comerica",
                "Citigroup",
                "Delta Air Lines",
                "FedEx",
                "FedEx Corporation",
                "Bristol-Myers Squibb",
                "American Airlines Group",
                "Deere",
                "Lockheed Martin",
                "UnitedHealth Group",
                "State Farm Insurance",
                "Michael Johnson",
                "Emily Smith",
                "Emma Williams",
                "Olivia Brown",
                "Ava Jones",
                "Isabella Davis",
                "Sophia Garcia",
                "Mia Rodriguez",
                "Abigail Martinez",
                "Charlotte Taylor",
                "Amelia Anderson",
                "Evelyn Thomas",
                "Abby Jackson",
                "Harper White",
                "Avery Harris",
                "Lily Scott",
                "Ella Adams",
                "Zoe Thompson",
                "Emily Thompson",
                "Mia Jones",
                "Sofia Davis",
                "Charlotte Brown",
                "Aria Taylor",
                "Scarlett Anderson",
                "Nora Thomas",
                "Sarah Jackson",
                "Avery Harris",
                "Evelyn Adams",
                "Grace Smith",
                "Samantha Wilson",
                "Isabella Johnson",
                "Elizabeth White",
                "Natalie Jones",
                "Chloe Anderson",
                "Nora Taylor",
                "Alexis Thomas",
                "Lily Jackson",
                "Emma Harris",
                "Charlotte Adams",
                "Abigail Smith",
                "Emily Wilson",
                "Mia Johnson",
                "Sofia White",
                "Avery Jones",
                "Abigail Anderson",
                "Evelyn Taylor",
                "Nora Thomas",
                "Isabella Jackson",
                "Natalie Harris",
                "Zoe Adams"
        );
    }
    public static String generateRandomClientName(){
        String clientName = "";
        Random random = new Random();
        int randomIndex = random.nextInt(Names.size());

        clientName = Names.get(randomIndex);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int indexLetter = random.nextInt(alphabet.length());
        clientName = clientName + " : " + alphabet.substring(indexLetter);

        return clientName;
    }
}
