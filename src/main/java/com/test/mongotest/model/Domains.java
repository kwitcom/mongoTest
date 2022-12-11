package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;

@Builder
public class Domains {

    public static List<String> Domains;

    static {
        Domains = Arrays.asList("gmail.com", "bofa.com", "hotmail.com", "wxfy.org", "kg-exs.net"

        );
    }
}
