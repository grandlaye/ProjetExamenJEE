package sn.demandeur.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.IDemandeur;
import sn.demandeur.entities.Demandeur;
import sn.demandeur.entities.Entreprise;

/**
 * Servlet implementation class DemandeurServlet
 */
@WebServlet("/Demandeur")
public class DemandeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IDemandeur demandeurdao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeurServlet() {
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
						Demandeur c = demandeurdao.get(id);
						request.setAttribute("demandeur", c);
					break;
				}
			}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("demandeur", request.getSession().getAttribute("user_session"));
			request.setAttribute("demandeurs", demandeurdao.getAll());
			//request.setAttribute("utilisateurs", userdao.getAll());
			request.getRequestDispatcher("view/demandeur/liste.jsp").forward(request, response);
		}else {
			
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
		Demandeur u = new Demandeur();
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setEmail(email);
		u.setPassword(mdp);
		u.setAddresse(addr);
		u.setTel(tel);
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id1= Integer.parseInt(request.getParameter("id").toString());
			u.setId(id1);
			demandeurdao.update(u);
		}else {
			demandeurdao.add(u);
		}
		doGet(request, response);
	}

}
