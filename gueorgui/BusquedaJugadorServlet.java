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
@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/buscaJugador","/jugadoresEquipo" })
public class BusquedaJugadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedaJugadorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
			case "/buscaJugador":
				JugadorFacade dao = new JugadorFacade();		
				String nom = request.getParameter("nombre");
				System.out.println("El nombre que se busca es " + nom);
				if (nom == null) {
					request.setAttribute("fail","Introduzca un jugador");
					request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
				} else {
					System.out.println("Se va a buscar");
		
					JugadorVO miJugador = dao.getPlayer(nom);
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
		
					if (miJugador != null) { // Se traslada a un jsp, para mostrar la info del jugador
						System.out.println("El equipo del jugador es " + miJugador.getEquipo());

						request.setAttribute("jugador",miJugador);
						request.getRequestDispatcher("muestraJugador.jsp").forward(request, response);
					} else { // Se env??a al usuario a un html con info ??nicamente est??tica, no es necesario jsp
						System.out.println("No se ha encontrado");
						request.setAttribute("fail","El jugador no existe");
						request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
					}
				}
				break;
			case "/jugadoresEquipo":
				if (request.getParameter("equipo") == null) {
					request.setAttribute("fail","Introduzca un jugador");
					request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
				} else {
					System.out.println("Los jugadores del equipo");
					List<JugadorVO> jugadores = new JugadorFacade().mismoEquipo(request.getParameter("equipo"));
					if(jugadores != null) {
					request.setAttribute("jugadoresEquipo",jugadores);
					request.getRequestDispatcher("jugadoresEquipo.jsp").forward(request, response);
					}else {
						request.setAttribute("fail","El jugador no existe");
						request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
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