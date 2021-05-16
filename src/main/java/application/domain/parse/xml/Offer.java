package application.domain.parse.xml;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "offer")
@Data
@ToString
@EqualsAndHashCode
public class Offer {
	private Long internalId;
	private String type;
	private String cadastralNumber;
	private String propertyType;
	private String category;
	private String mortgage;
	private String buildingType;
	private String builtYear;
	private String creationDate;
	private String lastUpdateDate;
	private Location location;
	private Price price;
	private SalesAgent salesAgent;
	private String description;
	private String bathroomUnit;
	private String lift;
	private String apartments;
	private Area area;
	private LivingSpace livingSpace;
	private RoomSpace roomSpace;
	private KitchenSpace kitchenSpace;
	private String floor;
	private String floorsTotal;
	private String rooms;
	private String roomsOffered;
	private String dealStatus;
	private List<String> images;

	@XmlAttribute(name = "internal-id")
	public void setInternalId(Long internalId) {
		this.internalId = internalId;
	}

	@XmlElement(name = "type")
	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "cadastral-number")
	public void setCadastralNumber(String cadastralNumber) {
		this.cadastralNumber = cadastralNumber;
	}

	@XmlElement(name = "property-type")
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	@XmlElement(name = "category")
	public void setCategory(String category) {
		this.category = category;
	}

	@XmlElement(name = "mortgage")
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	@XmlElement(name = "building-type")
	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	@XmlElement(name = "built-year")
	public void setBuiltYear(String builtYear) {
		this.builtYear = builtYear;
	}

	@XmlElement(name = "creation-date")
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@XmlElement(name = "last-update-date")
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	@XmlElement(name = "location")
	public void setLocation(Location location) {
		this.location = location;
	}

	@XmlElement(name = "price")
	public void setPrice(Price price) {
		this.price = price;
	}

	@XmlElement(name = "sales-agent")
	public void setSalesAgent(SalesAgent salesAgent) {
		this.salesAgent = salesAgent;
	}

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "bathroom-unit")
	public void setBathroomUnit(String bathroomUnit) {
		this.bathroomUnit = bathroomUnit;
	}

	@XmlElement(name = "lift")
	public void setLift(String lift) {
		this.lift = lift;
	}

	@XmlElement(name = "apartments")
	public void setApartments(String apartments) {
		this.apartments = apartments;
	}

	@XmlElement(name = "area")
	public void setArea(Area area) {
		this.area = area;
	}

	@XmlElement(name = "living-space")
	public void setLivingSpace(LivingSpace livingSpace) {
		this.livingSpace = livingSpace;
	}

	@XmlElement(name = "room-space")
	public void setRoomSpace(RoomSpace roomSpace) {
		this.roomSpace = roomSpace;
	}

	@XmlElement(name = "kitchen-space")
	public void setKitchenSpace(KitchenSpace kitchenSpace) {
		this.kitchenSpace = kitchenSpace;
	}

	@XmlElement(name = "floor")
	public void setFloor(String floor) {
		this.floor = floor;
	}

	@XmlElement(name = "floors-total")
	public void setFloorsTotal(String floorsTotal) {
		this.floorsTotal = floorsTotal;
	}

	@XmlElement(name = "rooms")
	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	@XmlElement(name = "rooms-offered")
	public void setRoomsOffered(String roomsOffered) {
		this.roomsOffered = roomsOffered;
	}

	@XmlElement(name = "deal-status")
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}

	@XmlElement(name = "image")
	public void setImages(List<String> images) {
		this.images = images;
	}
}
