package com.atul.app.supersetapi.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utilities {

	private static final Logger logger = LoggerFactory.getLogger(Utilities.class);

	public static String callApi(String _url, String params, String method, HashMap<String, String> header)
			throws Exception {

		try {

			URL url = new URL(_url);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			if (method == "POST")
				conn.setDoOutput(true);

			conn.setRequestMethod(method);
			conn.setRequestProperty("Content-Type", "application/json");
			
			if (header != null) {
				for (Map.Entry<String, String> m : header.entrySet()) {
					conn.setRequestProperty(m.getKey(), m.getValue());
				}
			}

			if (method == "POST") {
				OutputStream os = conn.getOutputStream();
				os.write(params.getBytes());
				os.flush();
			}

			if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
				if (conn.getResponseCode() != 200) {
					logger.error("[Api HTTP Error] " + conn.getResponseCode() + " " + conn.getResponseMessage());
					return "{ \"error\" : true, \"code\": " + conn.getResponseCode()
							+ ", \"msg\":\"Api has encountered an error.\"}";
				}
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = "";
			String resp = "";

			while ((output = br.readLine()) != null) {
				resp = resp + output;
			}

			conn.disconnect();
			logger.info("[Api Response] " + resp);
			return resp;

		} catch (Exception e) {
			logger.error("[Api Error] ", e);
			throw e;
		}
	}
}
