package com.autoscanner.service.scan.avby.make.impl;

import com.autoscanner.model.autoscanner.Make;
import com.autoscanner.service.scan.avby.make.MakeAvByProcess;
import com.autoscanner.utils.DocumentUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class MakeAvByProcessImpl implements MakeAvByProcess {
    private final static String avByBaseUrl = "https://cars.av.by";

    @Override
    public Set<Make> getListOfMakes() throws IOException {
        final Document document = DocumentUtils.getDocument(avByBaseUrl);
        Element el = document.getElementById("__NEXT_DATA__");
        String jsonStr = Objects.requireNonNull(el).html();
        Gson gson = new GsonBuilder().create();
        JsonObject job = gson.fromJson(jsonStr, JsonObject.class);
        JsonElement entry = job.getAsJsonObject("props")
                .getAsJsonObject("initialState")
                .getAsJsonObject("landing")
                .getAsJsonObject("seo")
                .getAsJsonArray("links");
        Gson gson1 = new Gson();
        Make[] makes = gson1.fromJson(entry, Make[].class);
        return new HashSet<>(Arrays.asList(makes));
    }
}
