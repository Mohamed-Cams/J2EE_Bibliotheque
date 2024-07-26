package bib;

import jakarta.persistence.*;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class livreserviceimplement implements livreservice {
    @PersistenceContext(unitName = "biblioPU")
    private EntityManager em;

    @Override
    public void ajouterLivre(livre livre) {
        em.persist(livre);
    }

    @Override
    public void supprimerLivre(Long id) {
        livre livre = em.find(livre.class, id);
        if (livre != null) {
            em.remove(livre);
        }
    }

    @Override
    public List<livre> obtenirTousLesLivres() {
        TypedQuery<livre> query = em.createQuery("SELECT l FROM livre l", livre.class);
        return query.getResultList();
    }
}