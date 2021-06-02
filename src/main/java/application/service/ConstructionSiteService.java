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
		StringBuilder info = new StringBuilder();
		if (offer.getPrice() != null) {
			if (offer.getType().equals("продажа")) {
				info.
						append("Цена: ").
						append(offer.getPrice().toString()).
						append(offer.getMortgage() != null && offer.getMortgage().equals("да") ? "\nВозможна ипотека" : "");
			} else if (offer.getType().equals("аренда")) {
				info.
						append("Стоимость аренды: ").
						append(offer.getPrice().toString());
			}
		}

		if (offer.getArea() != null ||
				offer.getLivingSpace() != null ||
				offer.getKitchenSpace() != null ||
				offer.getFloor() != null ||
				offer.getDealStatus() != null
		) {
			info.append("\n\nОбщая информация:");
		}

		if (offer.getArea() != null) {
			info.
					append("\nОбщая площадь: ").
					append(offer.getArea().toString());
		}

		if (offer.getLivingSpace() != null) {
			info.
					append("\nПлощадь комнат: ").
					append(offer.getLivingSpace().toString());
		}

		if (offer.getKitchenSpace() != null) {
			info.
					append("\nПлощадь кухни: ").
					append(offer.getKitchenSpace().toString());
		}

		if (offer.getFloor() != null) {
			info.
					append("\nЭтаж: ").
					append(offer.getFloor());
		}

		if (offer.getDealStatus() != null) {
			info.
					append("\nТип сделки: ").
					append(offer.getDealStatus());
		}

		if (offer.getBuildingType() != null ||
				offer.getBuiltYear() != null) {
			info.append("\n\nИнформация о доме:");

		}

		if (offer.getBuildingType() != null) {
			info.
					append("\nТип: ").
					append(offer.getBuildingType());
		}

		if (offer.getBuiltYear() != null) {
			info.
					append("\nГод постройки: ").
					append(offer.getBuiltYear());
		}

		if (offer.getLocation() != null) {
			info.
					append("\n\nРасположение: ").
					append(offer.getLocation().toString());
		}

		if (offer.getDescription() != null) {
			String description = offer.getDescription();
			description = description.replaceAll("<br>", "");
			description = description.replaceAll("<b>", "");
			description = description.replaceAll("</b>", "");
			description = description.replaceAll("<u>", "");
			description = description.replaceAll("</u>", "");
			description = description.replaceAll("<i>", "");
			description = description.replaceAll("</i>", "");

			info.
					append("\n\nОписание: ").
					append("\n").
					append(description);
		}

		if (offer.getSalesAgent() != null) {
			info.
					append("\n\nКонтакты: ").
					append(offer.getSalesAgent().toString());
		}

		return info.toString();
	}
}
