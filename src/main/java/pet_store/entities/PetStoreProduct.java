package pet_store.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import pet_store.keys.PetStoreProductKey;

@Entity
@Table(name = "pet_store_product")
public class PetStoreProduct {

	@EmbeddedId
	private PetStoreProductKey id = new PetStoreProductKey();
	
	@ManyToOne
	@MapsId("idPetStore")
	@JoinColumn(name = "id_pet_store")
	private PetStore petStore;
	
	@ManyToOne
	@MapsId("idProduct")
	@JoinColumn(name = "id_product")
	private Product product;
	
	public PetStoreProduct() {}
	
	public PetStoreProduct(PetStore petStore, Product product) {
		this.id = new PetStoreProductKey(petStore.getId(), product.getId());
		this.petStore = petStore;
		this.product = product;
	}

	public PetStoreProductKey getId() {
		return id;
	}

	public PetStore getPetStore() {
		return petStore;
	}

	public Product getProduct() {
		return product;
	}
	
}
