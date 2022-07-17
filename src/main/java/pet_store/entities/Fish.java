package pet_store.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import pet_store.enums.FishLivEnv;

@Entity
@Table(name = "fish")
public class Fish extends Animal {
	
	@Column(name = "living_env")
	@Enumerated(EnumType.STRING)
	private FishLivEnv livingEnv;
	
	public Fish() {}
	
	public Fish(LocalDate birth, String color, FishLivEnv livingEnv, PetStore petStore) {
		super(birth, color, petStore);
		this.livingEnv = livingEnv; 
	}

	@Override
	public String toString() {
		return String.format(
			"Fish [id = %d, birth = %s, color = %s, livingEnv = %s, petStore = %s]",
			id,
			birth,
			color,
			livingEnv,
			petStore.getName()
		);
	}

	public FishLivEnv getLivingEnv() {
		return livingEnv;
	}

	public void setLivingEnv(FishLivEnv livingEnv) {
		this.livingEnv = livingEnv;
	}
	
}
