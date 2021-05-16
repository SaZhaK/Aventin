package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "kitchen-space")
@Data
@ToString
@EqualsAndHashCode
public class KitchenSpace {
	private String value;
	private String unit;

	@XmlElement(name = "value")
	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement(name = "unit")
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
