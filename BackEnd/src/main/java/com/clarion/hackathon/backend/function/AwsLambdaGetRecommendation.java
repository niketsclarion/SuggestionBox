package com.clarion.hackathon.backend.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.clarion.hackathon.backend.model.Recommendation;
import com.clarion.hackathon.backend.service.RecommendationService;
import com.clarion.hackathon.backend.service.impl.RecommendationServiceImpl;

import java.util.List;

public class AwsLambdaGetRecommendation implements RequestHandler<Recommendation, List<Recommendation>> {

    @Override
    public List<Recommendation> handleRequest(Recommendation recommendation, Context context) {
        RecommendationService recommendationService = RecommendationServiceImpl.Instance();
        try {
            List<Recommendation> result = recommendationService.getAllRecommendation();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}


