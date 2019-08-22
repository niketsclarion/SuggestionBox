package com.clarion.hackathon.backend.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.clarion.hackathon.backend.dao.Impl.ModuleDAOImpl;
import com.clarion.hackathon.backend.model.ModuleMaster;
import com.clarion.hackathon.backend.service.ModuleService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a Service implementation in this class. it has a facility to connect
 * with DAO layer and get a data from dynamoDB and process it and return to call
 * object.
 * 
 * @author niket
 *
 */
public class ModuleServiceImpl implements ModuleService {

	static ModuleDAOImpl moduleDaoImpl = ModuleDAOImpl.Instance();

	private static volatile ModuleServiceImpl instance;

	public static ModuleServiceImpl Instance() {

		if (instance == null) {
			instance = new ModuleServiceImpl();
			moduleDaoImpl = moduleDaoImpl.Instance();
		}

		return instance;
	}

	/**
	 * This method is used to get List of Customers in which we provided ids as
	 * input field.
	 * 
	 * @param ids requested parameter as comma separated like (12,1214)
	 * @return it is returning a list of customer Object.
	 * @throws JsonParseException
	 */
	@Override
	public List<ModuleMaster> getAllModules() throws JsonParseException {

		return getListOfModule(moduleDaoImpl.getAllModules());

	}

	private List<ModuleMaster> getListOfModule(List<Item> allModules) throws JsonParseException {

		List<ModuleMaster> modules = new ArrayList<ModuleMaster>();

		for (Item module : allModules) {
			modules.add(getModuleMaster(module));
		}

		return modules;

	}

	private ModuleMaster getModuleMaster(Item item) throws JsonParseException {
		ModuleMaster module = new ModuleMaster();
		if (item == null) {
			return module;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {

			module = mapper.readValue(item.toJSONPretty(), ModuleMaster.class);
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		return module;
	}

}
