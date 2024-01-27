package com.app.service;

import java.util.List;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appbindings.DashboardBinding;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DashboardServiceImpl implements DashboardService {

	 DashboardBinding[] quotesList = null;

	String urlEndPoint = "https://type.fit/api/quotes";

	@Override
	public DashboardBinding generateQuote() {

		/*
		 * WebClient create = WebClient.create();
		 * 
		 * List<DashboardBinding> quotesList = create.get() .uri(urlEndPoint)
		 * .retrieve() .bodyToFlux(DashboardBinding.class) .collectList().block();
		 * 
		 * Random random = new Random(); int randomIndex =
		 * random.nextInt(quotesList.size());
		 * 
		 * return quotesList.get(randomIndex);
		 */

		if (quotesList == null) {

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> entity = restTemplate.getForEntity(urlEndPoint, String.class);

			String body = entity.getBody();
			
			System.out.println(body);

			ObjectMapper mapper = new ObjectMapper();
			try {
				  quotesList = mapper.readValue(body, DashboardBinding[].class);
				List<DashboardBinding> readValue = mapper.readValue(body,new TypeReference<List<DashboardBinding>>() {});
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		Random random = new Random();
		int randomIndex = random.nextInt(quotesList.length);

		return quotesList[randomIndex];
	}
}
