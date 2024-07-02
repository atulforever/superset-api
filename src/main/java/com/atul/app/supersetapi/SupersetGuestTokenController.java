package com.atul.app.supersetapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atul.app.supersetapi.util.Utilities;
import com.atul.app.supersetapi.v1.SupersetApi;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class SupersetGuestTokenController {

	private static final Logger logger = LoggerFactory.getLogger(Utilities.class);
	
	@PostMapping("/guest_token")
	public String guestToken(@RequestBody String payload) throws Exception {

		try {
			logger.info("[Payload] " + payload);
			
			String accessToken = SupersetApi.fetchAuthToken();
			String csrfToken = SupersetApi.fetchCsrfToken(accessToken);
			String resp = SupersetApi.fetchGuestToken(payload.toString(), accessToken, csrfToken);
			return resp;
			
		} catch (Exception e) {
			throw e;
		}
	}
}
