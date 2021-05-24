package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "area")
@Data
@EqualsAndHashCode
public class Area {
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
		StringBuilder area = new StringBuilder();
		if (value != null) {
			area.append(value).append(" ").append(unit);
		}
		return area.toString();
	}
}
