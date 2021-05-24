package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "living-space")
@Data
@EqualsAndHashCode
public class LivingSpace {
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

	@Override
	public String toString() {
		StringBuilder livingSpace = new StringBuilder();
		if (value != null) {
			livingSpace.append(value).append(" ").append(unit);
		}
		return livingSpace.toString();
	}
}
