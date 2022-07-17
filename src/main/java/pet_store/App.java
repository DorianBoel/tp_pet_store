package pet_store;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import pet_store.entities.Address;
import pet_store.entities.Animal;
import pet_store.entities.Cat;
import pet_store.entities.Fish;
import pet_store.entities.PetStore;
import pet_store.entities.PetStoreProduct;
import pet_store.entities.Product;
import pet_store.enums.FishLivEnv;
import pet_store.enums.ProdType;

public class App {

	public static void main(String[] args) {
		
		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("mariadb_pet_store");
		EntityManager entityManager = emFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Address address1 = new Address("3060", "Willow Greene Drive", "36104", "Montgomery");
		Address address2 = new Address("364", "Elliot Avenue", "98108", "Washington");
		Address address3 = new Address("4830", "Red Bud Lane", "07662", "Rochelle Park");
		entityManager.persist(address1);
		entityManager.persist(address2);
		entityManager.persist(address3);
		
		PetStore petStore1 = new PetStore("Shear Critters", "Kenneth Reed", address1);
		PetStore petStore2 = new PetStore("For Pet's Sake", "Ethel Vaughn", address2);
		PetStore petStore3 = new PetStore("Welcome Whiskers", "Jeffery Alston", address3);
		entityManager.persist(petStore1);
		entityManager.persist(petStore2);
		entityManager.persist(petStore3);

		Cat cat1 = new Cat(LocalDate.of(2021, 12, 17), "gray", "8567429103", petStore1);
		Cat cat2 = new Cat(LocalDate.of(2022, 05, 22), "white", "6379502481", petStore3);
		Cat cat3 = new Cat(LocalDate.of(2022, 05, 15), "orange", "2391470568", petStore3);
		entityManager.persist(cat1);
		entityManager.persist(cat2);
		entityManager.persist(cat3);

		Fish fish1 = new Fish(LocalDate.of(2020, 05, 29), "blue", FishLivEnv.SEA_WATER, petStore1);
		Fish fish2 = new Fish(LocalDate.of(2021, 02, 11), "orange", FishLivEnv.FRESH_WATER, petStore2);
		Fish fish3 = new Fish(LocalDate.of(2021, 01, 21), "black", FishLivEnv.FRESH_WATER, petStore2);
		entityManager.persist(fish1);
		entityManager.persist(fish2);
		entityManager.persist(fish3);

		Product product1 = new Product("1887564017410", "Medium dog basket", ProdType.ACCESSORY, 24.99);
		Product product2 = new Product("8076309245680", "Aquarium purifier", ProdType.CLEANING, 379.99);
		Product product3 = new Product("2070621418407", "Seed bars for birds", ProdType.FOOD, 4.89);
		entityManager.persist(product1);
		entityManager.persist(product2);
		entityManager.persist(product3);

		PetStoreProduct petStoreProduct1 = new PetStoreProduct(petStore1, product1);
		PetStoreProduct petStoreProduct2 = new PetStoreProduct(petStore2, product2);
		PetStoreProduct petStoreProduct3 = new PetStoreProduct(petStore3, product3);
		entityManager.persist(petStoreProduct1);
		entityManager.persist(petStoreProduct2);
		entityManager.persist(petStoreProduct3);

		entityManager.getTransaction().commit();
		
		TypedQuery<Animal> query = entityManager.createQuery("SELECT an FROM Animal an JOIN an.petStore ps WHERE ps.id = :id", Animal.class);
		query.setParameter("id", 1L);
		List<Animal> results = query.getResultList();
		
		for (Animal an: results) {
			System.out.println(an.toString());
		}
		
		entityManager.close();
		emFactory.close();
		
	}

}
