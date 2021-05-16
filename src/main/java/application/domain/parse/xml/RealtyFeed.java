package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "realty-feed", namespace = "http://webmaster.yandex.ru/schemas/feed/realty/2010-06")
@Data
@ToString
@EqualsAndHashCode
public class RealtyFeed {
	private String generationDate;
	private List<Offer> offers;

	@XmlElement(name = "generation-date")
	public void setGenerationDate(String generationDate) {
		this.generationDate = generationDate;
	}

	@XmlElement(name = "offer")
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}
