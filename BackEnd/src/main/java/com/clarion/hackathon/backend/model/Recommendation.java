package com.clarion.hackathon.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Recommendation {

    private String primaryKey1;
    private String primaryKey2;
    private String recommendation;
    
    private String module;
    private String scope;
    private String userName;
    private String tanentName;
    private String recommendationTitle;
    private String recommendationDetails;

    private String  objectSearchKey;
    private String created_date;


    public String getPrimaryKey1() {
        return primaryKey1;
    }

    public void setPrimaryKey1(String primaryKey1) {
        this.primaryKey1 = primaryKey1;
    }

    public String getPrimaryKey2() {
        return primaryKey2;
    }

    public void setPrimaryKey2(String primaryKey2) {
        this.primaryKey2 = primaryKey2;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTanentName() {
        return tanentName;
    }

    public void setTanentName(String tanentName) {
        this.tanentName = tanentName;
    }

    public String getRecommendationTitle() {
        return recommendationTitle;
    }

    public void setRecommendationTitle(String recommendationTitle) {
        this.recommendationTitle = recommendationTitle;
    }

    public String getRecommendationDetails() {
        return recommendationDetails;
    }

    public void setRecommendationDetails(String recommendationDetails) {
        this.recommendationDetails = recommendationDetails;
    }

    public String getObjectSearchKey() {
        return objectSearchKey;
    }

    public void setObjectSearchKey(String objectSearchKey) {
        objectSearchKey = objectSearchKey;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

}
