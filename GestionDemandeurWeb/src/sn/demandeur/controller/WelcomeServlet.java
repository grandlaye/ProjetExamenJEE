package sn.demandeur.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.IDemandeur;
import sn.demandeur.dao.IEntreprise;
import sn.demandeur.dao.IUser;
import sn.demandeur.entities.Demandeur;
import sn.demandeur.entities.Entreprise;
import sn.demandeur.entities.User;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//@EJB
	//private IUser userdao;
	@EJB
	private IDemandeur demandeurdao;
	@EJB
	private IEntreprise entreprisedao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_session") != null) {
			
			request.setAttribute("demandeur", request.getSession().getAttribute("user_session"));
			request.getRequestDispatcher("accueil.jsp").forward(request, response);	
		} else if(request.getSession().getAttribute("admin_session") != null) {
			
			request.setAttribute("entreprise", request.getSession().getAttribute("admin_session"));
			request.getRequestDispatcher("accueilAdmin.jsp").forward(request, response);	
		} else{
			response.sendRedirect("Login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  nom = request.getParameter("nom");
		String  prenom = request.getParameter("prenom");
		String  email = request.getParameter("email");
		String  mdp = request.getParameter("password");
		String addr = request.getParameter("addresse");
		String tel = request.getParameter("tel");
		
		String  nom2 = request.getParameter("nomEse");
		String  lieu = request.getParameter("lieu");
		String  cdNi = request.getParameter("codeNinea");
		String  email2 = request.getParameter("email");
		String  mdp2 = request.getParameter("password");
		
		Demandeur u = new Demandeur();
		Entreprise d = new Entreprise();
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setEmail(email);
		u.setPassword(mdp);
		u.setAddresse(addr);
		u.setTel(tel);
		d.setNomEse(nom2);
		d.setLieu(lieu);
		d.setCodeNinea(cdNi);
		d.setEmail(email2);
		d.setPassword(mdp2);
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id1= Integer.parseInt(request.getParameter("id").toString());
			u.setId(id1);
			entreprisedao.update(d);
			demandeurdao.update(u);
		} else { // pour l'ajout dans la base 
			demandeurdao.add(u);
			entreprisedao.add(d);
		}
		doGet(request, response);
	}
}
