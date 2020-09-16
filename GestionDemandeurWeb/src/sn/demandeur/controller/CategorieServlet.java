package sn.demandeur.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.ICategorie;
import sn.demandeur.dao.IOffre;
import sn.demandeur.entities.Categorie;

/**
 * Servlet implementation class CategorieServlet
 */
@WebServlet("/Categorie")
public class CategorieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ICategorie categoriedao;
	@EJB
	private IOffre offredao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("admin_session") != null) {
			
			if(request.getParameter("action") != null) {
				String action = request.getParameter("action").toString();
				int id = Integer.parseInt(request.getParameter("id").toString());
				switch (action) {
				case "edit":
						Categorie c = categoriedao.get(id);
						request.setAttribute("categorie", c);
					break;
				}
				
			}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("entreprise", request.getSession().getAttribute("admin_session"));
			request.setAttribute("categories", categoriedao.getAll());
			//request.setAttribute("offres", offredao.getAll());
			request.getRequestDispatcher("view/categorie/liste.jsp").forward(request, response);	
		} else {
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  nom = request.getParameter("nomCat");
		//int id1 = Integer.parseInt(request.getParameter("offre"));
		Categorie c = new Categorie();
		c.setNomCat(nom);
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id= Integer.parseInt(request.getParameter("id").toString());
			c.setId(id);
			categoriedao.update(c);
		}else { // pour l'ajout dans la base 
			categoriedao.add(c);
		}
		doGet(request, response);
	}
}
