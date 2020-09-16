package sn.demandeur.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.demandeur.dao.ICvDemandeur;
import sn.demandeur.dao.IEntreprise;
import sn.demandeur.dao.IUser;
import sn.demandeur.entities.CvDemandeur;
import sn.demandeur.entities.Entreprise;
import sn.demandeur.entities.Offre;
import sn.demandeur.entities.User;

/**
 * Servlet implementation class EntrepriseServlet
 */
@WebServlet("/Entreprise")
public class EntrepriseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private IEntreprise entreprisedao;
	@EJB
	private IUser userdao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntrepriseServlet() {
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
						Entreprise c = entreprisedao.get(id);
						request.setAttribute("entreprise", c);
					break;
				}
			}
			
			request.setAttribute("page", request.getParameter("page"));
			request.setAttribute("entreprise", request.getSession().getAttribute("admin_session"));
			request.setAttribute("entreprises", entreprisedao.getAll());
			//request.setAttribute("utilisateurs", userdao.getAll());
			request.getRequestDispatcher("view/entreprise/liste.jsp").forward(request, response);
		}else {
			
			response.sendRedirect("Login");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  nomE = request.getParameter("nomEse");
		String  lieu = request.getParameter("lieu");
		String  codni = request.getParameter("codeNinea");
		String  email = request.getParameter("email");
		String  mdp = request.getParameter("password");
		//int id = Integer.parseInt(request.getParameter("user"));
		Entreprise c = new Entreprise();
		c.setNomEse(nomE);
		c.setLieu(lieu);
		c.setCodeNinea(codni);
		c.setEmail(email);
		c.setPassword(mdp);
		//c.setOffre((List<Offre>) request.getSession().getAttribute("user_session"));
		//c.setCvDemandeur((List<CvDemandeur>) request.getSession().getAttribute("user_session"));
		//c.setUser((List<User>)request.getSession().getAttribute("user_session"));
		if(request.getParameter("id") != null) { // pour la modification d'un cv
			int id1= Integer.parseInt(request.getParameter("id").toString());
			c.setId(id1);
			entreprisedao.update(c);
		}else {
			entreprisedao.add(c);
		}
		doGet(request, response);
	}

}
