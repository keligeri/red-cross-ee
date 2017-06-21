package controller;

import model.Member;
import model.Race;
import model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.util.Date;

/**
 * Created by keli on 2017.06.21..
 */
public class Controller {

    private static void populateDb(EntityManagerFactory emf, EntityManager em){
        Race firstRace = new Race(new Date(), "Zalaegerszeg");
        Race secondRace = new Race(new Date(), "Miskolc");

        Team zegiek = new Team("Zegi puhányok", firstRace);
        Team miskolciak = new Team("miskolci csapat", secondRace);
        Team tesco = new Team("gazdaságos", secondRace);

        Member gergo = new Member("Kelemen", "Gergő", "Nekeresdi utca 26");

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(firstRace);
        em.persist(secondRace);

        em.persist(gergo);

        em.persist(zegiek);
        em.persist(miskolciak);
        em.persist(tesco);

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
