package com.autoscanner.utils;

import org.jsoup.nodes.Document;

import java.io.IOException;

import static org.jsoup.Jsoup.connect;

public class DocumentUtils {
    public static Document getDocument(final String url) throws IOException {
        return connect(url).timeout(6000).get();
    }
}
