package pet_store.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pet_store.enums.ProdType;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@Column(nullable = false)
	private String label;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ProdType type;
	
	@Column(nullable = false)
	private double price;
	
	@OneToMany(mappedBy = "product")
	private Set<PetStoreProduct> petStoresProducts;
	
	public Product() {}
	
	public Product(String code, String label, ProdType type, double price) {
		this.code = code;
		this.label = label;
		this.type = type;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getLabel() {
		return label;
	}

	public ProdType getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	public Set<PetStoreProduct> getPetStoresProducts() {
		return petStoresProducts;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setType(ProdType type) {
		this.type = type;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
