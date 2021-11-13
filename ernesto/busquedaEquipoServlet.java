package es.unizar.sisinf.grp1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.unizar.sisinf.grp1.model.EquipoFacade;
import es.unizar.sisinf.grp1.model.EquipoVO;
import es.unizar.sisinf.grp1.model.JugadorFacade;
import es.unizar.sisinf.grp1.model.JugadorVO;

/**
 * Servlet implementation class BusquedaJugadorSerlvet
 */
//@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/buscaJugador" })
public class BusquedaEquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaEquipoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
			case "/busquedaEquipo":
				EquipoFacade dao = new EquipoFacade();		
				String nom = request.getParameter("equipo"); //tiene q coincidir equipo
				System.out.println("El equipo que se busca es " + nom);
				if (nom == null) {
					response.sendRedirect("jugadorInexistente.hmtl");
				} else {
					System.out.println("Se va a buscar");
		
					EquipoVO miEquipo = dao.getTeam(nom);
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
		
					if (miEquipo != null) { // Se traslada a un jsp, para mostrar la info del jugador
						//System.out.println("El equipo del jugador es " + miEquipo.getTeam());

						request.setAttribute("equipo",miEquipo);
						request.getRequestDispatcher("muestraEquipo.jsp").forward(request, response);
					} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
						response.sendRedirect("jugadorInexistente.html"); 
					}
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