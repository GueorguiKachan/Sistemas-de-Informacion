package es.unizar.sisinf.grp1.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import es.unizar.sisinf.grp1.model.GrupoFacade;
import es.unizar.sisinf.grp1.model.GrupoVO;

/**
 * Servlet implementation class BusquedaJugadorSerlvet
 */
@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/procesarGrupo","/procesarEquipo", "/procesarJugador" })

public class BusquedasPagPrincipalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusquedasPagPrincipalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		String nom = request.getParameter("buscar");
		switch(action) {
			case "/procesarGrupo":
				
					System.out.println("Se va a buscar");
					List<EquipoVO> listaGrupo = new ArrayList<EquipoVO>();
					listaGrupo = new EquipoFacade().todosGrupo(nom);
					if (listaGrupo != null) { // Se traslada a un jsp, para mostrar la info del jugador
							//System.out.println("El equipo del jugador es " + miEquipo.getTeam());
							//lista.add(miEquipo);
							request.setAttribute("equiposGrupo",listaGrupo);
							request.getRequestDispatcher("tablaEquipos.jsp").forward(request, response);
						} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
							response.sendRedirect("jugadorInexistente.html"); 
						}
				
					
			case "/procesarEquipo":
				List<JugadorVO> listaEquipo = new ArrayList<JugadorVO>();
				listaEquipo = new JugadorFacade().mismoEquipo(nom);
				
				request.setAttribute("jugadoresEquipo",listaEquipo);
				request.getRequestDispatcher("jugadoresEquipo.jsp").forward(request, response);
				
			case "/procesarJugador":
				List<JugadorVO> listaJugador = new ArrayList<JugadorVO>();
				listaJugador = new JugadorFacade().getByName(nom);
				
				request.setAttribute("jugador",listaJugador);
				request.getRequestDispatcher("mostrarJugador.jsp").forward(request, response);
				
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