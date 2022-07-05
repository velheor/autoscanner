package com.autoscanner.utils;

public class LinksBuilder {
    private static final String START_LINK = "https://cars.av.by";

    public static String buildLink(String link) {
        return START_LINK.concat(link);
    }
}
