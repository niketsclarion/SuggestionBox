package com.clarion.hackathon.backend.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.util.StringUtils;
import com.clarion.hackathon.backend.dao.RecommendationDAO;
import com.clarion.hackathon.backend.dao.Impl.RecommendationDAOImpl;
import com.clarion.hackathon.backend.model.Recommendation;
import com.clarion.hackathon.backend.service.RecommendationService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RecommendationServiceImpl implements RecommendationService {

    static RecommendationDAO recommendationDao = RecommendationDAOImpl.Instance();

    private static volatile RecommendationServiceImpl instance;

    public static RecommendationServiceImpl Instance() {

        if (instance == null) {
            instance = new RecommendationServiceImpl();
            recommendationDao = RecommendationDAOImpl.Instance();
        }
        return instance;
    }

    @Override
    public String postRecommendation(Recommendation recommendation) {
        String primaryKey1 = "Recom-" + System.currentTimeMillis();
        return recommendationDao.postRecommendation(getItem(recommendation), primaryKey1, primaryKey1);
    }


    private Item getItem(Recommendation recommendation) {

        Item item = new Item();

        item = item.withString("created_date", String.valueOf(new Date()));
        item = item.withString("ObjectSearchKey", "recommendation");

        if (!StringUtils.isNullOrEmpty(recommendation.getModule()))
            item = item.withString("module", recommendation.getModule());
        if (!StringUtils.isNullOrEmpty(recommendation.getRecommendation()))
            item = item.withString("recommendation", recommendation.getRecommendation());

        if (!StringUtils.isNullOrEmpty(recommendation.getRecommendationDetails()))
            item = item.withString("recommendationDetails", recommendation.getRecommendationDetails());

        if (!StringUtils.isNullOrEmpty(recommendation.getRecommendationTitle()))
            item = item.withString("recommendationTitle", recommendation.getRecommendationTitle());
        if (!StringUtils.isNullOrEmpty(recommendation.getScope()))
            item = item.withString("scope", recommendation.getScope());

        if (!StringUtils.isNullOrEmpty(recommendation.getUserName()))
            item = item.withString("userName", recommendation.getUserName());

        if (!StringUtils.isNullOrEmpty(recommendation.getTanentName()))
            item = item.withString("tenantName", recommendation.getTanentName());

        return item;

    }

    @Override
    public List<Recommendation> getAllRecommendation() throws JsonParseException {
        return getListOfRecommendation(recommendationDao.getAllRecommendation());
    }

    private List<Recommendation> getListOfRecommendation(List<Item> allRecommendation) throws JsonParseException {

        List<Recommendation> recommendations = new ArrayList<>();

        for (Item recommedation : allRecommendation) {
            recommendations.add(getRecommendation(recommedation));
        }
        return recommendations;
    }

    private Recommendation getRecommendation(Item item) throws JsonParseException {
        Recommendation recommendation = new Recommendation();
        if (item == null) {
            return recommendation;
        }

        ObjectMapper mapper = new ObjectMapper();
        try {

            recommendation = mapper.readValue(item.toJSONPretty(), Recommendation.class);

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
        return recommendation;
    }

}
