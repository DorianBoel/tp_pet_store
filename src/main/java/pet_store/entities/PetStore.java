package pet_store.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet_store")
public class PetStore {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(name = "manager_name", nullable = false)
	private String managerName;
	
	@OneToOne
	private Address address;
	
	@OneToMany(mappedBy = "petStore")
	private Set<Animal> animals;
	
	@OneToMany(mappedBy = "product")
	private Set<PetStoreProduct> petStoresProducts;
	
	public PetStore() {}
	
	public PetStore(String name, String managerName, Address address) {
		this.name = name;
		this.managerName = name;
		this.address = address;
	}
	
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getManagerName() {
		return managerName;
	}

	public Address getAddress() {
		return address;
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	public Set<PetStoreProduct> getPetStoresProducts() {
		return petStoresProducts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
