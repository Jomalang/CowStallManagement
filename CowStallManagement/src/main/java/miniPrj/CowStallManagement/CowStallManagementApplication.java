package miniPrj.CowStallManagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CowStallManagementApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("StallManagement");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.close();
		emf.close();
		SpringApplication.run(CowStallManagementApplication.class, args);
	}

}
