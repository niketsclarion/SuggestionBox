package com.clarion.hackathon.backend.dao;

import com.amazonaws.services.dynamodbv2.document.Item;

import java.util.List;

public interface RecommendationDAO {
    String postRecommendation(Item data,String primaryKey1,String primaryKey2);
    List<Item> getAllRecommendation();
}
