package bib.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import bib.livre;
import bib.livreservice;

import javax.ejb.EJB;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "livreServlet", urlPatterns = {"/livreservlet", "/ajoutlivre"})
public class livreservlet extends HttpServlet {

    @EJB
    livreservice livreService = new livreservice() {
        @Override
        public void ajouterLivre(livre livre) {

        }

        @Override
        public void supprimerLivre(Long id) {

        }

        @Override
        public List<livre> obtenirTousLesLivres() {

            return List.of();
        }
    };

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/livreservlet".equals(path)) {
            List<livre> livres = livreService.obtenirTousLesLivres();
            request.setAttribute("livre", livres);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if ("/ajoutlivre".equals(path)) {
            request.getRequestDispatcher("/ajoutlivre.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur");
        int anneePublication = Integer.parseInt(request.getParameter("anneePublication"));

        livre l1 = new livre();
        l1.setTitre(titre);
        l1.setAuteur(auteur);
        l1.setAnneePublication(anneePublication);

        livreService.ajouterLivre(l1);

        response.sendRedirect(request.getContextPath() + "/livreservlet");
    }
}

