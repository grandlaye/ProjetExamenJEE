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
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IUser userdao;
	@EJB
	private IDemandeur demandeurdao;
	@EJB
	private IEntreprise entreprisedao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user_session") != null) {
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("demandeurs", request.getSession().getAttribute("user_session"));
			request.getRequestDispatcher("acceuil.jsp").forward(request, response);	
		} else if(request.getSession().getAttribute("admin_session") != null) {
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("entreprises", request.getSession().getAttribute("admin_session"));
			request.getRequestDispatcher("acceuilAdmin.jsp").forward(request, response);	
		} else{
			
			response.sendRedirect("Login");
		}
		/*request.getRequestDispatcher("acceuil.jsp").forward(request, response);	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email").toString();
		String password = request.getParameter("password").toString();
		

		User utilisateurs = userdao.getLogin(email, password);
		Demandeur demandeur = new Demandeur();
		Entreprise entreprise = new Entreprise();
		entreprise = entreprisedao.getLogin(email,password);
		demandeur = demandeurdao.getLogin(email, password);
		
		
		if (demandeur != null) {
			request.getSession().setAttribute("user_session", demandeur);
			response.sendRedirect("acceuil.jsp");
		}else if (entreprise != null) {
			request.getSession().setAttribute("admin_session", entreprise);
			response.sendRedirect("acceuilAdmin.jsp");
		} 
		else
		{
			response.sendRedirect("Login");
		}
	}

}
