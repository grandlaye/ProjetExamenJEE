package sn.demandeur.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.ICategorie;
import sn.demandeur.dao.IEntreprise;
import sn.demandeur.dao.IOffre;
import sn.demandeur.entities.Categorie;
import sn.demandeur.entities.CvDemandeur;
import sn.demandeur.entities.Entreprise;
import sn.demandeur.entities.Offre;

/**
 * Servlet implementation class OffreServlet
 */
@WebServlet("/Offre")
public class OffreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IOffre offredao;
	@EJB
	private IEntreprise entreprisedao;
	@EJB
	private ICategorie categoriedao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OffreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_session") != null) {
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("demandeur", request.getSession().getAttribute("user_session"));
			request.setAttribute("offres", offredao.getAll());
			request.setAttribute("entreprises", entreprisedao.getAll());
			request.setAttribute("categories", categoriedao.getAll());
			request.getRequestDispatcher("view/offre/liste.jsp").forward(request, response);	
		} else 
			if(request.getSession().getAttribute("admin_session") != null) {
				
				if(request.getParameter("action") != null) {
					String action = request.getParameter("action").toString();
					int id = Integer.parseInt(request.getParameter("id").toString());
					switch (action) {
					case "edit":
							Offre c = offredao.get(id);
							request.setAttribute("offre", c);
						break;
					}
					
				}
				request.setAttribute("page", request.getParameter("page"));
				request.setAttribute("entreprise", request.getSession().getAttribute("admin_session"));
				request.setAttribute("offres", offredao.getAll());
				request.setAttribute("entreprises", entreprisedao.getAll());
				request.setAttribute("categories", categoriedao.getAll());
				request.getRequestDispatcher("view/offre2/liste.jsp").forward(request, response);	
			} else{
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  nom = request.getParameter("nomOffre");
		String  type = request.getParameter("type");
		int id = Integer.parseInt(request.getParameter("entreprise"));
		int id1 = Integer.parseInt(request.getParameter("categorie"));
		Offre o = new Offre();
		o.setNomOffre(nom);
		o.setType(type);
		o.setEntreprise(entreprisedao.get(id));
		o.setCategorie(categoriedao.get(id1));
		
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id2= Integer.parseInt(request.getParameter("id").toString());
			o.setId(id2);
			offredao.update(o);
		} else { // pour l'ajout dans la base 
			offredao.add(o);
		}
		doGet(request, response);
	}

}
