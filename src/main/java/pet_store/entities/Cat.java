package pet_store.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

	@Column(name = "chip_id", nullable = false, unique = true) 
	private String chipId;
	
	@Override
	public String toString() {
		return String.format(
			"Cat [id = %d, chipId = %s, birth = %s, color = %s, petStore = %s]",
			id,
			chipId,
			birth,
			color,
			petStore.getName()
		);
	}

	public Cat() {}
	
	public Cat(LocalDate birth, String color, String chipId, PetStore petStore) {
		super(birth, color, petStore);
		this.chipId = chipId;
	}

	public String getChipId() {
		return chipId;
	}

	public void setChipId(String chipId) {
		this.chipId = chipId;
	}
	
}
