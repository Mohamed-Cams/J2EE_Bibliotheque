package bib;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction ef = em.getTransaction();

        try {

            ef.begin();


            livre livre1 = new livre();
            livre1.setTitre("La tempete");
            livre1.setAuteur("Mohamed Zall");
            livre1.setAnneePublication(2062);

            livre livre2 = new livre();
            livre2.setTitre("1984 Meurtre");
            livre2.setAuteur("Chaire de poule");
            livre2.setAnneePublication(1999);


            em.persist(livre1);
            em.persist(livre2);

            ef.commit();
        } catch (Exception e) {

            if (ef.isActive()) {
                ef.rollback();
            }

            e.printStackTrace();
        } finally {

            em.close();
            emf.close();
        }
        }
}