package com.clarion.hackathon.backend.function;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.clarion.hackathon.backend.model.HttpRequestDataWithRecommendation;
import com.clarion.hackathon.backend.model.Recommendation;
import com.clarion.hackathon.backend.model.ResponseStatus;
import com.clarion.hackathon.backend.service.RecommendationService;
import com.clarion.hackathon.backend.service.impl.RecommendationServiceImpl;

public class AwsLambdaPostRecommendation implements RequestHandler<HttpRequestDataWithRecommendation, ResponseStatus> {

	@Override
	public ResponseStatus handleRequest(HttpRequestDataWithRecommendation httpRecommendation, Context context) {
		RecommendationService recommendationService = RecommendationServiceImpl.Instance();

		ResponseStatus status = validate(httpRecommendation.getRecom());

		if (!status.getStatus().equalsIgnoreCase("Fail")) {
			try {
				String result = recommendationService.postRecommendation(httpRecommendation.getRecom());
				status.setStatus("Pass");

			} catch (Exception e) {
				e.printStackTrace();
				status.setStatus("Fail");
				status.setMeessage(e.getMessage());
				;
			}

		}
		return status;
	}
	private ResponseStatus validate(Recommendation recom) {
		ResponseStatus status = new ResponseStatus();
		status.setStatus("Pass");
		String resMessage = "";
		if (recom.getModule() == null || recom.getModule().trim().length() == 0) {
			status.setStatus("Fail");
			resMessage = resMessage +" " +"Module Cannot be Blank";
		}
		if (recom.getRecommendationTitle() == null || recom.getRecommendationTitle().trim().length() == 0) {
			status.setStatus("Fail");
			resMessage = resMessage +" " +"Title Cannot be Blank";
		}
		if (recom.getRecommendationDetails() == null || recom.getRecommendationDetails().trim().length() == 0) {
			status.setStatus("Fail");
			resMessage = resMessage + " " +"Description Cannot be Blank";
		}
		if (recom.getScope() == null || recom.getScope().trim().length() == 0) {
			status.setStatus("Fail");
			resMessage = resMessage + " " + "Scope Cannot be Blank";
		} 
		if (recom.getUserName() == null || recom.getUserName().trim().length() == 0) {
			status.setStatus("Fail");
			resMessage = resMessage + " " + "User Cannot be Blank";
		} 
		if (recom.getTanentName() == null || recom.getTanentName().trim().length() == 0) {
			status.setStatus("Fail");
			resMessage = resMessage + " " + "Tanent Cannot be Blank";
		}
		status.setMeessage(resMessage);
		return status;
	}
}
