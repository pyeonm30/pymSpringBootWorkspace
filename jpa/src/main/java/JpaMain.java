import entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        // 객체 sessitonFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-ex");
        EntityManager em = emf.createEntityManager(); // session 객체
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Customer c = new Customer("ID001" , "KIM");
        em.persist(c);
        tx.commit();

    }
}
