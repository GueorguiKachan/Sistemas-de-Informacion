package es.unizar.sisinf.grp1.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.unizar.sisinf.grp1.model.JugadorFacade;
import es.unizar.sisinf.grp1.model.JugadorVO;

/**
 * Servlet implementation class Signin
 */
@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/buscaJugador" })
public class muestraJugador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public muestraJugador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JugadorFacade dao = new JugadorFacade();		
		
		if (request.getParameter("nombre") == null) {
			response.sendRedirect("jugadorInexistente.hmtl");
		} else {
			JugadorVO miJugador = new JugadorVO();
			JugadorVO miJugador = dao.getPlayer(request.getParameter("nombre"));
			boolean valido = dao.validateUser(user);
			if (miJugador != null) { // Se traslada a un jsp, para mostrar la info del jugador
				request.setAttribute("jugador",miJugador);
				request.getRequestDispatcher("infoJugador.jsp").forward(request, response);
			} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
				response.sendRedirect("jugadorInexistente.html"); 
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