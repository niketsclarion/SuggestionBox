package com.clarion.hackathon.connector;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

/**
 * This Class is used to Connect with DynamoDB. in which we are Setting Region US-East-1.
 * @author niket
 *
 */
public class DynamoDbConnector {


	
	private static volatile DynamoDbConnector instance;
	private  DynamoDBMapper mapper;
	private AmazonDynamoDBClient client;

	private DynamoDB dynamoDB = null;

	@SuppressWarnings("deprecation")
	private DynamoDbConnector() {
		client = new AmazonDynamoDBClient();
		client.setRegion(Region.getRegion(Regions.US_EAST_1));
		mapper = new DynamoDBMapper(client);
		dynamoDB = new DynamoDB(client);
		
	}

	
	public DynamoDB getDynamo()
	{
		return dynamoDB;
	}
	
	/**
	 * This method is used to call a singleton Instance of class.
	 * @return
	 */
	public static DynamoDbConnector instance() {

		if (instance == null) {
			synchronized (DynamoDbConnector.class) {
				if (instance == null)
					instance = new DynamoDbConnector();
			}
		}

		return instance;
	}

	public static DynamoDBMapper mapper() {

		DynamoDbConnector manager = instance();
		return manager.mapper;
	}

	/**
	 * We are returning a Client of AmazonDynamoDB client for connection with DynamoDB.
	 * @return
	 */
	public AmazonDynamoDBClient getClient() {
		return client;
	}

	public void setClient(AmazonDynamoDBClient client) {
		this.client = client;
	}
}