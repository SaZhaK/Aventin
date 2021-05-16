package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "price")
@Data
@ToString
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
}
