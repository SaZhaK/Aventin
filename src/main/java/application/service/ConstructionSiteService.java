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
			constructionSiteJSON.put("Name", offer.getCategory());
			constructionSiteJSON.put("Image", images.get(0));
			constructionSiteJSON.put("Description", formDescription(offer));

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

	private String formDescription(Offer offer) {
		StringBuilder description = new StringBuilder();
		if (offer.getPrice() != null) {
			description.
					append("Цена: ").
					append(offer.getPrice().toString()).
					append(offer.getMortgage() != null && offer.getMortgage().equals("да") ? "\nВозможна ипотека" : "");
		}

		description.append("\n\nОбщая информация:");

		if (offer.getArea() != null) {
			description.
					append("\nОбщая площадь: ").
					append(offer.getArea().toString());
		}

		if (offer.getLivingSpace() != null) {
			description.
					append("\nПлощадь комнат: ").
					append(offer.getLivingSpace().toString());
		}

		if (offer.getKitchenSpace() != null) {
			description.
					append("\nПлощадь кухни: ").
					append(offer.getKitchenSpace().toString());
		}

		if (offer.getFloor() != null) {
			description.
					append("\nЭтаж: ").
					append(offer.getFloor());
		}

		if (offer.getDealStatus() != null) {
			description.
					append("\nТип сделки: ").
					append(offer.getDealStatus());
		}

		description.append("\n\nИнформация о доме:");

		if (offer.getBuildingType() != null) {
			description.
					append("\nТип: ").
					append(offer.getBuildingType());
		}

		if (offer.getBuiltYear() != null) {
			description.
					append("\nГод постройки: ").
					append(offer.getBuiltYear());
		}

		if (offer.getSalesAgent() != null) {
			description.
					append("\n\nКонтакты: ").
					append(offer.getSalesAgent().toString());
		}

		if (offer.getLocation() != null) {
			description.
					append("\n\nРасположение: ").
					append(offer.getLocation().toString());
		}

		if (offer.getDescription() != null) {
			description.
					append("\n\nОписание: ").
					append(offer.getDescription());
		}

		return description.toString();
	}
}
