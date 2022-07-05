package com.autoscanner.service.scan.avby.model.impl;

import com.autoscanner.model.autoscanner.Make;
import com.autoscanner.model.autoscanner.Model;
import com.autoscanner.service.scan.avby.model.ModelAvByProcess;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static com.autoscanner.utils.DocumentUtils.getDocument;
import static com.autoscanner.utils.LinksBuilder.buildLink;
import static java.util.Objects.requireNonNull;

@Service
public class ModelAvByProcessImpl implements ModelAvByProcess {

    @Override
    public Set<Model> getListOfModels(final Make make) throws IOException {
        Elements body = getDocument(make.getLink()).getElementsByClass("catalog__list").select("li.catalog__item");
        Set<Model> models = new HashSet<>();
        body.forEach(element -> {
            final String modelLink = buildLink(element.getElementsByClass("catalog__link").attr("href"));
            final String modelName = requireNonNull(element.select("span.catalog__title").select("span").first()).text();
            models.add(new Model(modelName, modelLink, make));
        });
        return models;
    }
}
