package sn.demandeur.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.ICvDemandeur;
import sn.demandeur.dao.IEntreprise;
import sn.demandeur.dao.IOffre;
import sn.demandeur.entities.CvDemandeur;
import sn.demandeur.entities.Entreprise;

/**
 * Servlet implementation class CvDemandeurServlet
 */
@WebServlet("/CvDemandeur")
public class CvDemandeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private ICvDemandeur cvDamandeurdao;
	@EJB
	private IEntreprise entreprisedao;
	@EJB
	private IOffre offredao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CvDemandeurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_session") != null) {
			
			if(request.getParameter("action") != null) {
				String action = request.getParameter("action").toString();
				int id = Integer.parseInt(request.getParameter("id").toString());
				switch (action) {
				case "edit":
						CvDemandeur c = cvDamandeurdao.get(id);
						request.setAttribute("cvdemandeur", c);
					break;
				}
				
			}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("demandeur", request.getSession().getAttribute("user_session"));
			request.setAttribute("cvDemandeurs", cvDamandeurdao.getAll());
			request.setAttribute("entreprises", entreprisedao.getAll());
			request.setAttribute("offres", offredao.getAll());
			request.getRequestDispatcher("view/cvDemandeur/liste.jsp").forward(request, response);	
		} else 
			
			if(request.getSession().getAttribute("admin_session") != null) {
				if(request.getParameter("action") != null) {
					String action = request.getParameter("action").toString();
					int id = Integer.parseInt(request.getParameter("id").toString());
					switch (action) {
					case "edit":
							CvDemandeur c = cvDamandeurdao.get(id);
							request.setAttribute("cvdemandeur", c);
						break;
					}
					
				}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("entreprise", request.getSession().getAttribute("admin_session"));
			request.setAttribute("cvDemandeurs", cvDamandeurdao.getAll());
			request.setAttribute("entreprises", entreprisedao.getAll());
			request.setAttribute("offres", offredao.getAll());
			request.getRequestDispatcher("view/cvDemandeur2/liste.jsp").forward(request, response);	
		} else{
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  nom = request.getParameter("nomCV");
		String  prenom = request.getParameter("prenomCV");
		String  email = request.getParameter("emailCV");
		String  addr = request.getParameter("addresse");
		String  speci = request.getParameter("specialite");
		String  tel = request.getParameter("tel");
		String  niv = request.getParameter("niveau");
		String  exp = request.getParameter("experience");
		int id = Integer.parseInt(request.getParameter("entreprise"));
		int ido = Integer.parseInt(request.getParameter("offre"));
		CvDemandeur c = new CvDemandeur();
		c.setNomCV(nom);
		c.setPrenomCV(prenom);
		c.setEmailCV(email);
		c.setAddresse(addr);
		c.setSpecialite(speci);
		c.setTel(tel);
		c.setNiveau(niv);
		c.setExperience(exp);
		c.setEntreprise(entreprisedao.get(id));
		c.setOffre(offredao.get(ido));
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id1= Integer.parseInt(request.getParameter("id").toString());
			c.setId(id1);
			cvDamandeurdao.update(c);
		} else { // pour l'ajout dans la base 
			cvDamandeurdao.add(c);
		}
		doGet(request, response);
	}

}
