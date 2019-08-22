package com.clarion.hackathon.backend.service;

import java.util.List;

import com.clarion.hackathon.backend.model.ModuleMaster;
import com.fasterxml.jackson.core.JsonParseException;


public interface ModuleService {

	
	/**
	 * List of All Customer by IDS given in String as a input..
	 * @param ids
	 * @return
	 * @throws JsonParseException 
	 */
	List<ModuleMaster> getAllModules() throws JsonParseException;
	
	
}
