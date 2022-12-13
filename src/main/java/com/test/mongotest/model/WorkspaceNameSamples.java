package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Builder
public class WorkspaceNameSamples {

    public static List<String> Names;

    static {
        Names = Arrays.asList(
                "The Corner Office",
                "The Brainstorming Room",
                "The Creative Cave",
                "The Productivity Hub",
                "The Meeting Place",
                "The Collaboration Station",
                "The Idea Factory",
                "The Innovation Lab",
                "The Think Tank",
                "The Brain Trust",
                "The War Room",
                "The Power House",
                "The Brainstorming Den",
                "The Game Changers",
                "The Trailblazers",
                "The Visionaries",
                "The Mavericks",
                "The Disruptors",
                "The Renegades",
                "The Pioneers",
                "The Wizards")
        ;
    }
    public static String selectRandomWorkspaceName(){
        String workspaceName = "";
        Random random = new Random();
        int randomIndex = random.nextInt(Names.size());

        workspaceName = Names.get(randomIndex);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int indexLetter = random.nextInt(alphabet.length());
        workspaceName = workspaceName + " : " + alphabet.substring(indexLetter);

        return workspaceName;
    }
}
