

import common.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestJPA_noboot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PERSISTENCE"); //Factory can initiate many Entity Manager
		EntityManager em =  emf.createEntityManager(); //Entity Manage can start many transaction
		EntityTransaction etransaction = em.getTransaction(); //One Transaction can have many entity
		
		Employee emp = new Employee();
//		emp.setId(1);
		etransaction.begin();
		emp.setName("DukeHo");
		emp.setAge(23);
		emp.setSalary(124503);
		em.persist(emp);
		etransaction.commit(); //database will not be change unless commit();
		em.close();
		emf.close();
	}
}
