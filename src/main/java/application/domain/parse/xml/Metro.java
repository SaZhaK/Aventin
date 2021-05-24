package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metro")
@Data
@EqualsAndHashCode
public class Metro {
	private String name;
	private String timeOnFoot;

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "time-on-foot")
	public void setTimeOnFoot(String timeOnFoot) {
		this.timeOnFoot = timeOnFoot;
	}

	@Override
	public String toString() {
		StringBuilder metro = new StringBuilder();

		if (name != null && timeOnFoot != null) {
			metro.append(timeOnFoot).append(" минут от метро ").append(name);
		} else if (name != null) {
			metro.append(name);
		}

		return metro.toString();
	}
}
