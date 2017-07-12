package com.walmart.vendor.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

//import com.walmart.product.model.Product;

/*import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;*/



@Document(indexName = "walmart", type = "vendor")
public class Vendor {

    @Id
    private String vendorID;

	private String name;

	private String email;

	private String phone;

	private String rating;

	private String city;

	private String state;

	private String country;

	public Vendor() {

	}

	public Vendor(String vendorID ,String name, String email, String phone, String rating, String city, String state, String country) {
		this.vendorID =vendorID;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.rating = rating;
		this.city = city;
		this.state = state;
		this.country = country;
		
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getEmail() {
		return email;
	}

	public String getVendorID() {
		return vendorID;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getRating() {
		return rating;
	}

	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setVendorID(String vendorId) {
		this.vendorID = vendorId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public void setState(String state) {
		this.state = state;
	}


    @Override
    public String toString() {
        return "Vendor{" +
                "vendorid='" + vendorID + '\'' +
                ", name='" + name + '\'' +
		", city='" +city +'\''+
		", country='" +country +'\''+
		", state='" +state +'\''+
		", email='" +email +'\''+
		", phone='" +phone +'\''+
		", rating='" +rating +'\''+
                '}';
    }
}
