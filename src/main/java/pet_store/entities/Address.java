package pet_store.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String number;
	
	@Column(nullable = false)
	private String street;
	
	@Column(name = "zip_code", nullable = false)
	private String zipCode;
	
	@Column(nullable = false)
	private String city;
	
	public Address() {}
	
	public Address(String number, String street, String zipCode, String city) {
		this.number = number;
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getStreet() {
		return street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
