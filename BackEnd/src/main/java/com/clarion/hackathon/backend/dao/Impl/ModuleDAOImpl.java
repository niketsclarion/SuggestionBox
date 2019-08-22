package com.clarion.hackathon.backend.dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Index;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.KeyAttribute;
import com.amazonaws.services.dynamodbv2.document.QueryOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.clarion.hackathon.backend.dao.ModuleDAO;
import com.clarion.hackathon.connector.DynamoDbConnector;

/**
 * This Class is used to Connect with Customer DAO. and provide a Facility to
 * manage Customer Object.
 *
 * @author niket
 */

public class ModuleDAOImpl implements ModuleDAO {

	private static volatile ModuleDAOImpl instance;

	static DynamoDB dynamoDB = DynamoDbConnector.instance().getDynamo();
	final Table table = dynamoDB.getTable("Recomandation");

	/**
	 * @return
	 */
	public static ModuleDAOImpl Instance() {
		if (instance == null) {
			instance = new ModuleDAOImpl();
			dynamoDB = DynamoDbConnector.instance().getDynamo();
		}

		return instance;
	}

	@Override
	public List<Item> getAllModules() {
		return getItemsByQueryIndexSearch();
	}

	public List<Item> getItemsByQueryIndexSearch() {
		Item item = null;
		List<Item> items = new ArrayList<Item>();

		// As of now we create Separate Table We will merge iin same Table
		Index index = table.getIndex("ObjectSearchKey-created_date-index");
		KeyAttribute keyAttribute = new KeyAttribute("ObjectSearchKey", "module");
		QuerySpec spec = new QuerySpec().withHashKey(keyAttribute);
		ItemCollection<QueryOutcome> outCome = index.query(spec);
		Iterator<Item> iter = outCome.iterator();
		iter.forEachRemaining(items::add);
		System.out.println("Item " + items.size());
		return items;
	}
}
