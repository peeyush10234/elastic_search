package com.walmart.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/*import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/



@Document(indexName = "walmart", type = "product")
public class Product {

    @Id
	private String id;

	private String name;

	private String type;

	private String quantity;

	private String imageLocation;

	private String description;

	//@Temporal(TemporalType.DATE)
	private String harvestDate;

	//@Temporal(TemporalType.DATE)
	private String shipmentDate;

	private String latitue;

	private String longitude;

	private String city;

	private String state;

	private String country;
	
	//@ManyToOne
	private String vendorID;

	public Product() {

	}

	public Product(String id,String name, String type, String quantity, String imageLocation, String description,
			String harvestDate, String shipmentDate, String latitue, String longitude, String city, String state,
			String country, String vendorID) {
		//super();
		this.id   = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.imageLocation = imageLocation;
		this.description = description;
		this.harvestDate = harvestDate;
		this.shipmentDate = shipmentDate;
		this.latitue = latitue;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
		this.country = country;
		this.vendorID = vendorID;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getDescription() {
		return description;
	}

	public String getHarvestDate() {
		return harvestDate;
	}

	public String getId() {
		return id;
	}

	public String getImageLocation() {
		return imageLocation;
	}

	public String getLatitue() {
		return latitue;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public String getQuantity() {
		return quantity;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public String getState() {
		return state;
	}

	public String getType() {
		return type;
	}

	public String getVendorID() {
		return vendorID;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHarvestDate(String harvestDate) {
		this.harvestDate = harvestDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public void setLatitue(String latitue) {
		this.latitue = latitue;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", quantity='" + quantity + '\'' +
		", imagelocation='" +imageLocation + '\'' +
		", description='" + description +'\'' +
		", harvestDate='" + harvestDate +'\'' +
		", shipmentDate='" + shipmentDate +'\'' +
		", latitude='" +latitue +'\''+
		", longitude='" +longitude +'\''+
		", city='" +city +'\''+
		", country='" +country +'\''+
		", state='" +state +'\''+
		", vendorID='" +vendorID +'\''+
		
                '}';
    }
}
