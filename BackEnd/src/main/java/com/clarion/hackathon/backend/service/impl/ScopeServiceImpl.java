package com.clarion.hackathon.backend.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.clarion.hackathon.backend.dao.ScopeDAO;
import com.clarion.hackathon.backend.dao.Impl.ScopeDAOImpl;
import com.clarion.hackathon.backend.model.ScopeMaster;
import com.clarion.hackathon.backend.service.ScopeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScopeServiceImpl implements ScopeService {

	static ScopeDAO scopeDao = ScopeDAOImpl.Instance();

	private static volatile ScopeServiceImpl instance;

	public static ScopeServiceImpl Instance() {

		if (instance == null) {
			instance = new ScopeServiceImpl();
			scopeDao = ScopeDAOImpl.Instance();
		}

		return instance;
	}

	@Override
	public List<ScopeMaster> getAllScopeMaster() throws JsonParseException {
		return getListOfScope(scopeDao.getAllScopes());
	}

	private List<ScopeMaster> getListOfScope(List<Item> allModules) throws JsonParseException {

		List<ScopeMaster> scopes = new ArrayList<ScopeMaster>();

		for (Item scope : allModules) {
			scopes.add(getScopeMaster(scope));
		}

		return scopes;

	}

	private ScopeMaster getScopeMaster(Item item) throws JsonParseException {
		ScopeMaster scope = new ScopeMaster();
		if (item == null) {
			return scope;
		}

		ObjectMapper mapper = new ObjectMapper();
		try {

			scope = mapper.readValue(item.toJSONPretty(), ScopeMaster.class);

		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		return scope;
	}

}
