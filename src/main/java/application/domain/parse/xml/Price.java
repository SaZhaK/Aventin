package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "price")
@Data
@EqualsAndHashCode
public class Price {
	private String value;
	private String currency;

	@XmlElement(name = "value")
	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement(name = "currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		StringBuilder price = new StringBuilder();
		if (value != null) {
			price.append(value).append(" ").append(currency);
		}
		return price.toString();
	}
}
