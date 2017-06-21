package controller;

import model.Member;
import model.Race;
import model.Team;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

public class Controller {

    private static void populateDb(EntityManagerFactory emf, EntityManager em){
        Race firstRace = new Race(new Date(), "Zalaegerszeg");
        Race secondRace = new Race(new Date(), "Miskolc");

        Team zegiek = new Team("Zegi puhányok", firstRace);
        Team miskolciak = new Team("miskolci csapat", secondRace);
        Team tesco = new Team("gazdaságos", secondRace);

        Member gergo = new Member("Kelemen", "Gergő", "Nekeresdi utca 26", zegiek);
        Member dani = new Member("Kelemen", "Dani", "Nekeresdi utca 26", miskolciak);
        Member peti = new Member("Kelemen", "Péter", "Nekeresdi utca 26", tesco);
        Member pista = new Member("Kelemen", "Pista", "Nekeresdi utca 26", zegiek);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.persist(firstRace);
        em.persist(secondRace);

        em.persist(gergo);
        em.persist(dani);
        em.persist(peti);
        em.persist(pista);

        em.persist(zegiek);
        em.persist(miskolciak);
        em.persist(tesco);

        transaction.commit();
    }

    public static void findWithCriteriaApi(EntityManagerFactory emf, EntityManager em){
        CriteriaBuilder cb =  em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(String.class);    // retrieve as String

        Root<Member> member = cq.from(Member.class);
        cq.select(member).where(cb.equal(member.get("lastName"), "Gergő"));

        TypedQuery<Member> query = em.createQuery(cq);
        List<Member> list = query.getResultList();
        Member gergo = query.getSingleResult();
        System.out.println(gergo.getAddress());
        for (Member m : list){
            System.out.println(m.getLastName());
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("red-cross-orm");
        EntityManager em = emf.createEntityManager();

        populateDb(emf, em);
//        findWithJPQL(emf, em);
        findWithCriteriaApi(emf, em);

        em.close();
        emf.close();
    }

    public static void findWithJPQL(EntityManagerFactory emf, EntityManager em){
        List list = em.createQuery("SELECT m.lastName FROM Member m").getResultList();
        for (Object member : list){
            System.out.println(member);
        }

        Query query = em.createQuery("SELECT m.firstName from Member m WHERE m.lastName = 'Dani' ");
        for (Object m : query.getResultList()){
            System.out.println(m);
        }
    }


}
