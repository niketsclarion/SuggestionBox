package com.clarion.hackathon.backend.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.document.Item;

public interface ScopeDAO {
    List<Item> getAllScopes();
}
