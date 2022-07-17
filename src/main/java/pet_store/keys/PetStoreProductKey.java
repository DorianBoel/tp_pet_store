package pet_store.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PetStoreProductKey implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_pet_store")
    long idPetStore;

    @Column(name = "id_product")
    long idProduct;
    
    public PetStoreProductKey() {}
    
    public PetStoreProductKey(long idPetStore, long idProduct) {
    	this.idPetStore = idPetStore;
    	this.idProduct = idProduct;
    }

	public long getIdPetStore() {
		return idPetStore;
	}

	public long getIdProduct() {
		return idProduct;
	}

}
