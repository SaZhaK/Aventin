package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "metro")
@Data
@ToString
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
}
