package com.test.mongotest.model;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Builder
public class TypeFile {
    public static List<String> Extension;

    static {
        Extension = Arrays.asList(
                "txt", "doc", "docx", "xls", "xlsx",
                "pdf", "ppt", "pptx", "odt", "ods",
                "odp", "odg", "jpg", "jpeg", "png",
                "gif", "bmp", "tiff", "psd", "svg",
                "ai", "eps", "indd", "cdr", "raw",
                "mp3", "m4a", "wav", "aac", "wma",
                "flac", "alac", "ogg", "midi", "mp4",
                "m4v", "mov", "wmv", "avi", "mpg",
                "mkv", "flv", "vob", "webm", "3gp",
                "zip", "rar", "7z", "tar", "gz",
                "bz2", "xz"
        );
    }

    public static String selectRandomExtension(){
        Random random = new Random();

        // Select a random index from the list of domains
        int index = random.nextInt(Extension.size());

        // Get the domain at the selected index
        String extension = Extension.get(index);
        return extension;
    }
}
