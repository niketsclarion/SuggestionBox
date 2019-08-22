package com.clarion.hackathon.backend.dao.Impl;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.clarion.hackathon.backend.dao.RecommendationDAO;
import com.clarion.hackathon.connector.DynamoDbConnector;
import com.amazonaws.services.dynamodbv2.document.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendationDAOImpl implements RecommendationDAO {

    private static volatile RecommendationDAOImpl instance;

    static DynamoDB dynamoDB = DynamoDbConnector.instance().getDynamo();

    final Table table = dynamoDB.getTable("Recomandation");

    public static RecommendationDAOImpl Instance() {
        if (instance == null) {
            instance = new RecommendationDAOImpl();

        }

        return instance;
    }


    @Override
    public String postRecommendation(Item item, String primaryKey1, String primaryKey2) throws ConditionalCheckFailedException {
        PutItemOutcome outcome = table
                .putItem(item.withPrimaryKey("PrimaryKey1", primaryKey1, "PrimaryKey2", primaryKey2));
        return outcome.toString();
    }


    @Override
    public List<Item> getAllRecommendation() {
        return getItemsByQueryIndexSearch();
    }

    private List<Item> getItemsByQueryIndexSearch() {
        List<Item> items = new ArrayList<Item>();

        Index index = table.getIndex("ObjectSearchKey-created_date-index");
        KeyAttribute keyAttribute = new KeyAttribute("ObjectSearchKey", "recommendation");
        QuerySpec spec = new QuerySpec().withHashKey(keyAttribute);
        ItemCollection<QueryOutcome> outCome = index.query(spec);
        Iterator<Item> iter = outCome.iterator();
        iter.forEachRemaining(items::add);
        System.out.println("Item " + items.size());
        return items;
    }
}

