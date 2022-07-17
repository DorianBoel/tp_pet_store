package pet_store.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long id;
	
	@Column(nullable = false)
	protected LocalDate birth;
	
	@Column(nullable = false)
	protected String color;
	
	@ManyToOne
	@JoinColumn(name = "id_pet_store", nullable = false)
	protected PetStore petStore;
	
	public Animal() {}
	
	public Animal(LocalDate birth, String color, PetStore petStore) {
		this.birth = birth;
		this.color = color;
		this.petStore = petStore;
	}

	public long getId() {
		return id;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public String getColor() {
		return color;
	}

	public PetStore getPetStore() {
		return petStore;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setPetStore(PetStore petStore) {
		this.petStore = petStore;
	} 
	
}
