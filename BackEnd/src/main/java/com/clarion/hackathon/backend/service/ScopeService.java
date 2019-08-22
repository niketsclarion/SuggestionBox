package com.clarion.hackathon.backend.service;

import com.clarion.hackathon.backend.model.ScopeMaster;
import com.fasterxml.jackson.core.JsonParseException;

import java.util.List;

public interface ScopeService {

    List<ScopeMaster> getAllScopeMaster() throws JsonParseException;
}
