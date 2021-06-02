package application.controllers;

import application.properties.FileProperties;
import application.service.ConstructionSiteService;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/parse")
public class ParserController {
	private final FileProperties fileProperties;
	private final ConstructionSiteService constructionSiteService;

	@PostMapping(produces = "application/json")
	public String parse() throws JAXBException, IOException {
		List<JSONObject> sites = constructionSiteService.getAllSites();

		for (JSONObject site : sites) {
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request = new HttpEntity<>(site.toString(), headers);
			restTemplate.postForObject(fileProperties.getCrmUrl(), request, String.class);
		}

		return "redirect:/";
	}
}
