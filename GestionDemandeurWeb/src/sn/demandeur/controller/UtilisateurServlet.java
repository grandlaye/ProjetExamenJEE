package sn.demandeur.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.IUser;
import sn.demandeur.entities.User;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/Utilisateur")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	private IUser userdao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
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
						User u = userdao.get(id);
						request.setAttribute("utilisateur", u);
					break;
				}
			}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("user", request.getSession().getAttribute("user_session"));
			request.setAttribute("utilisateurs", userdao.getAll());
			request.getRequestDispatcher("view/utilisateur/liste.jsp").forward(request, response);
		} else {
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
		User u = new User();
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setEmail(email);
		u.setPassword(mdp);
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id1= Integer.parseInt(request.getParameter("id").toString());
			u.setId(id1);
			userdao.update(u);
		} else { // pour l'ajout dans la base 
			userdao.add(u);
		}
		doGet(request, response);
	}

}
