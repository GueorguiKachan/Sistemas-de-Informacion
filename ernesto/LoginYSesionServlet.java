package es.unizar.sisinf.grp1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.unizar.sisinf.grp1.model.EquipoFacade;
import es.unizar.sisinf.grp1.model.EquipoVO;
import es.unizar.sisinf.grp1.model.JugadorFacade;
import es.unizar.sisinf.grp1.model.JugadorVO;
import es.unizar.sisinf.grp1.model.UserFacade;
import es.unizar.sisinf.grp1.model.UserVO;
import es.unizar.sisinf.grp1.model.GrupoFacade;
import es.unizar.sisinf.grp1.model.GrupoVO;

/**
 * Servlet implementation class BusquedaJugadorSerlvet
 */
@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/login","/registro" })

public class LoginYSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginYSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("FUNCIONA EL SERVLET");
		UserFacade dao = new UserFacade();		
		if (request.getParameter("username") == null) {
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		} else {
			UserVO user = new UserVO(request.getParameter("username"), request.getParameter("password"));
			boolean valido = dao.validateUser(user);
			if (valido) {
				boolean esAdmin = dao.esAdmin(user);
				if (esAdmin) {
					user.setEsAdmin(true);
				}
				user.setPassword(null);
				request.getSession().setAttribute("user",user);
				request.getRequestDispatcher("paginaPrincipal.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "invalid password");
				request.getRequestDispatcher("paginaPrincipal.jsp").forward(request, response);
			}
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}