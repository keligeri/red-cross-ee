package controller;

import model.Race;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

/**
 * Created by keli on 2017.06.21..
 */
public class Controller {

    private static void populateDb(EntityManagerFactory emf, EntityManager em){
        Race firstRace = new Race("csapaat neve");
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(firstRace);
        transaction.commit();

        em.close();
        emf.close();
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("red-cross-orm");
        EntityManager em = emf.createEntityManager();

        populateDb(emf, em);

    }
}
