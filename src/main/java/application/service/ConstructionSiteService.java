package application.service;

import application.domain.parse.xml.Offer;
import application.domain.parse.xml.RealtyFeed;
import application.properties.FileProperties;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ConstructionSiteService {
	private final FileProperties fileProperties;

	public List<JSONObject> getAllSites() throws JAXBException, IOException {
		List<JSONObject> sites = new ArrayList<>();

		RealtyFeed realtyFeed = parseXML();
		List<Offer> offers = realtyFeed.getOffers();

		for (Offer offer : offers) {
			List<String> images = offer.getImages();

			JSONObject constructionSiteJSON = new JSONObject();
			constructionSiteJSON.put("Description", offer.getDescription());
			constructionSiteJSON.put("Category", offer.getCategory());
			constructionSiteJSON.put("Image", images.get(0));

			JSONArray imagesArray = new JSONArray();

			for (int i = 1; i < images.size(); i++) {
				JSONObject imagesObject = new JSONObject();
				imagesObject.put("type", "image");
				imagesObject.put("title", "image " + i);
				imagesObject.put("src", images.get(i));

				imagesArray.put(imagesObject);
			}
			constructionSiteJSON.put("Images", imagesArray);

			sites.add(constructionSiteJSON);
		}
		return sites;
	}

	private RealtyFeed parseXML() throws JAXBException, IOException {
		JAXBContext context = JAXBContext.newInstance(RealtyFeed.class);
		return (RealtyFeed) context.createUnmarshaller().unmarshal(new FileReader(fileProperties.getRootDirectory()));
	}
}
