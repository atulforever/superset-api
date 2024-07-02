package com.atul.app.supersetapi.v1;

public class SupersetConfig {

	private static final String loginUrl = "http://103.180.186.246:8080/api/v1/security/login";
	private static final String csrfUrl = "http://103.180.186.246:8080/api/v1/security/csrf_token/";
	private static final String guestTokenUrl = "http://103.180.186.246:8080/api/v1/security/guest_token/";

	private static final String adminUsername = "admin";
	private static final String adminPassword = "adminadmin";
	
	static String getLoginUrl() {
		return loginUrl;
	}
	static String getCsrfUrl() {
		return csrfUrl;
	}
	static String getGuestTokenUrl() {
		return guestTokenUrl;
	}
	static String getAdminUsername() {
		return adminUsername;
	}
	static String getAdminPassword() {
		return adminPassword;
	}
}
