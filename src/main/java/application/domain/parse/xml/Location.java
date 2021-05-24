package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "location")
@Data
@EqualsAndHashCode
public class Location {
	private String country;
	private String region;
	private String district;
	private String localityName;
	private String address;
	private Metro metro;

	@XmlElement(name = "country")
	public void setCountry(String country) {
		this.country = country;
	}

	@XmlElement(name = "region")
	public void setRegion(String region) {
		this.region = region;
	}

	@XmlElement(name = "district")
	public void setDistrict(String district) {
		this.district = district;
	}

	@XmlElement(name = "locality-name")
	public void setLocalityName(String localityName) {
		this.localityName = localityName;
	}

	@XmlElement(name = "address")
	public void setAddress(String address) {
		this.address = address;
	}

	@XmlElement(name = "metro")
	public void setMetro(Metro metro) {
		this.metro = metro;
	}

	@Override
	public String toString() {
		StringBuilder location = new StringBuilder();
		if (country != null) {
			location.append("\n").append(country);
		}
		if (region != null) {
			location.append(", ").append(region);
		}
		if (district != null) {
			location.append(", ").append(district);
		}
		if (localityName != null ) {
			location.append(", ").append(localityName);
		}
		if (address != null) {
			location.append(", ").append(address);
		}
		if (metro != null) {
			location.append(", ").append(metro.toString());
		}
		return location.toString();
	}
}
