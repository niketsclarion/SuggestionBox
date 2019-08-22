package com.clarion.hackathon.backend.service;

import com.clarion.hackathon.backend.model.Recommendation;
import com.fasterxml.jackson.core.JsonParseException;

import java.util.List;

public interface RecommendationService {


   // static RecommendationService Instance() throws JsonParseException;

    String postRecommendation(Recommendation recommendation);

    List<Recommendation> getAllRecommendation() throws JsonParseException;
}
