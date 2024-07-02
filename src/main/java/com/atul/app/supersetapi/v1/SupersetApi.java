package com.atul.app.supersetapi.v1;

import java.util.HashMap;
import org.json.JSONObject;

import com.atul.app.supersetapi.util.Utilities;

public class SupersetApi {

	public static String fetchAuthToken() throws Exception {

		String loginPayload = "{\"password\": \"" + SupersetConfig.getAdminPassword()
				+ "\",\"provider\": \"db\",\"refresh\": true,\"username\": \"" + SupersetConfig.getAdminUsername() + "\"}";

		String resp = Utilities.callApi(SupersetConfig.getLoginUrl(), loginPayload, "POST", null);

		JSONObject obj = new JSONObject(resp);

		return obj.getString("access_token");
	}

	public static String fetchCsrfToken(String accessToken) throws Exception {

		HashMap<String, String> header = new HashMap<>();

		header.put("Authorization", "Bearer " + accessToken);

		String resp = Utilities.callApi(SupersetConfig.getCsrfUrl(), null, "GET", header);

		JSONObject obj = new JSONObject(resp);

		return obj.getString("result");
	}

	public static String fetchGuestToken(String payload, String accessToken, String csrfToken) throws Exception {

		HashMap<String, String> header = new HashMap<>();
		header.put("Authorization", "Bearer " + accessToken);
		header.put("X-CSRFToken", csrfToken);

		String resp = Utilities.callApi(SupersetConfig.getGuestTokenUrl(), payload, "POST", header);

		return resp;
	}
}
