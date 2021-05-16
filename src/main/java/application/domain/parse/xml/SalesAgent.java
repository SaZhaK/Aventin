package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sales-agent")
@Data
@ToString
@EqualsAndHashCode
public class SalesAgent {
	private String name;
	private String category;
	private String organization;
	private String url;
	private String email;
	private String phone;

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "category")
	public void setCategory(String category) {
		this.category = category;
	}

	@XmlElement(name = "organization")
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	@XmlElement(name = "url")
	public void setUrl(String url) {
		this.url = url;
	}

	@XmlElement(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement(name = "phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
