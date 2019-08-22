package com.clarion.hackathon.backend.dao;

import java.util.List;

import com.amazonaws.services.dynamodbv2.document.Item;


/**
 * This is a CustomerDAO Which provide facility to connect with DynamoDB and return list of Item(s) on base of different parameter.
 *
 * @author niket
 */
public interface ModuleDAO {
    List<Item> getAllModules();
}
