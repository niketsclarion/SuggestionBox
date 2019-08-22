package com.clarion.hackathon.backend.model;

import java.util.HashMap;
import com.clarion.hackathon.backend.model.Recommendation;

public class HttpRequestDataWithRecommendation {

	private Recommendation recom;

	private HttpAwsContext context;

	private HashMap<String, Object> params;
	private HashMap<String, Object> stageVariables;
	
	private boolean warmer;
	

	public HttpAwsContext getContext() {
		return context;
	}

	public void setContext(HttpAwsContext context) {
		this.context = context;
	}

	public HashMap<String, Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}

	public HashMap<String, Object> getStageVariables() {
		return stageVariables;
	}

	public void setStageVariables(HashMap<String, Object> stageVariables) {
		this.stageVariables = stageVariables;
	}

	public boolean isWarmer() {
		return warmer;
	}

	public void setWarmer(boolean warmer) {
		this.warmer = warmer;
	}

	public Recommendation getRecom() {
		return recom;
	}

	public void setRecom(Recommendation recom) {
		this.recom = recom;
	}
	
}
