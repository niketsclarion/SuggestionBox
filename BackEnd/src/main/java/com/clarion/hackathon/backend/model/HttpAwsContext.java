package com.clarion.hackathon.backend.model;

import java.util.HashMap;
import java.util.Map;

public class HttpAwsContext {


private String accountId;
private String apiId;
private String apiKey;
private String authorizerPrincipalId;
private String caller;
private String cognitoAuthenticationProvider;
private String cognitoAuthenticationType;
private String cognitoIdentityId;
private String cognitoIdentityPoolId;
private String httpMethod;
private String stage="";
private String sourceIp;
private String user;
private String userAgent;
private String userArn;
private String requestId;
private String resourceId;
private String resourcePath="";
private String url;


private Map<String, Object> additionalProperties = new HashMap<String, Object>();
public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public String getApiId() {
	return apiId;
}
public void setApiId(String apiId) {
	this.apiId = apiId;
}
public String getApiKey() {
	return apiKey;
}
public void setApiKey(String apiKey) {
	this.apiKey = apiKey;
}
public String getAuthorizerPrincipalId() {
	return authorizerPrincipalId;
}
public void setAuthorizerPrincipalId(String authorizerPrincipalId) {
	this.authorizerPrincipalId = authorizerPrincipalId;
}
public String getCaller() {
	return caller;
}
public void setCaller(String caller) {
	this.caller = caller;
}
public String getCognitoAuthenticationProvider() {
	return cognitoAuthenticationProvider;
}
public void setCognitoAuthenticationProvider(String cognitoAuthenticationProvider) {
	this.cognitoAuthenticationProvider = cognitoAuthenticationProvider;
}
public String getCognitoAuthenticationType() {
	return cognitoAuthenticationType;
}
public void setCognitoAuthenticationType(String cognitoAuthenticationType) {
	this.cognitoAuthenticationType = cognitoAuthenticationType;
}
public String getCognitoIdentityId() {
	return cognitoIdentityId;
}
public void setCognitoIdentityId(String cognitoIdentityId) {
	this.cognitoIdentityId = cognitoIdentityId;
}
public String getCognitoIdentityPoolId() {
	return cognitoIdentityPoolId;
}
public void setCognitoIdentityPoolId(String cognitoIdentityPoolId) {
	this.cognitoIdentityPoolId = cognitoIdentityPoolId;
}
public String getHttpMethod() {
	return httpMethod;
}
public void setHttpMethod(String httpMethod) {
	this.httpMethod = httpMethod;
}
public String getStage() {
	return stage;
}
public void setStage(String stage) {
	this.stage = stage;
}
public String getSourceIp() {
	return sourceIp;
}
public void setSourceIp(String sourceIp) {
	this.sourceIp = sourceIp;
}
public String getUser() {
	return user;
}
public void setUser(String user) {
	this.user = user;
}
public String getUserAgent() {
	return userAgent;
}
public void setUserAgent(String userAgent) {
	this.userAgent = userAgent;
}
public String getUserArn() {
	return userArn;
}
public void setUserArn(String userArn) {
	this.userArn = userArn;
}
public String getRequestId() {
	return requestId;
}
public void setRequestId(String requestId) {
	this.requestId = requestId;
}
public String getResourceId() {
	return resourceId;
}
public void setResourceId(String resourceId) {
	this.resourceId = resourceId;
}
public String getResourcePath() {
	return resourcePath;
}
public void setResourcePath(String resourcePath) {
	this.resourcePath = resourcePath;
}
public Map<String, Object> getAdditionalProperties() {
	return additionalProperties;
}
public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}

	
}