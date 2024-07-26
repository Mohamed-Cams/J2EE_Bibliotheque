package bib;

import java.util.List;

public interface livreservice {
    void ajouterLivre(livre livre);
    void supprimerLivre(Long id);
    List<livre> obtenirTousLesLivres();
}
