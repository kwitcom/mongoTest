package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Builder
public class Domains {

    public static List<String> Domains;

    static {
        Domains = Arrays.asList(
                "gmail.com",
                "bofa.com",
                "hotmail.com",
                "wxfy.org",
                "kg-exs.net",
                "adventuretime.com",
                "fantasticjourney.com",
                "mysteriousisland.com",
                "legendofzelda.com",
                "thelastairbender.com",
                "thelittlemermaid.com",
                "theincredibles.com",
                "aladdin.com",
                "thelionking.com",
                "brave.com",
                "frozen.com",
                "cinderella.com",
                "tangled.com",
                "moana.com",
                "theprincessandthefrog.com",
                "beautyandthebeast.com",
                "aliceinwonderland.com",
                "pwc.com"

        );
    }

    public static String selectRandomDomain(){
        Random random = new Random();

        // Select a random index from the list of domains
        int index = random.nextInt(Domains.size());

        // Get the domain at the selected index
        String domain = Domains.get(index);
        return domain;
    }
}
