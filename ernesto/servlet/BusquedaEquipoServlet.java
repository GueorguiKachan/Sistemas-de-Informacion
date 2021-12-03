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

/**
 * Servlet implementation class BusquedaJugadorSerlvet
 */
@WebServlet(description = "Servlet de busqueda de equipos", urlPatterns = { "/busquedaEquipo","/tablaEquipos","/equiposGrupo" })

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
		EquipoFacade dao = new EquipoFacade();
		String nom;
		switch(action) {
			case "/busquedaEquipo":		
				nom = request.getParameter("equipo"); //tiene q coincidir equipo
				System.out.println("El equipo que se busca es " + nom);
				if (nom == null) {
					response.sendRedirect("jugadorInexistente.hmtl");
				} else {
					System.out.println("Se va a buscar");
					List<EquipoVO> lista = new ArrayList<EquipoVO>();
					EquipoVO miEquipo = dao.getTeam(nom);
					
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
		
					if (miEquipo != null) { // Se traslada a un jsp, para mostrar la info del jugador
						//System.out.println("El equipo del jugador es " + miEquipo.getTeam());
						lista.add(miEquipo);
						request.setAttribute("equipo",lista);
						request.getRequestDispatcher("muestraEquipo.jsp").forward(request, response);
					} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
						response.sendRedirect("jugadorInexistente.html"); 
					}
				}break;
			case "/tablaEquipos":	
				nom = request.getParameter("equipo"); //tiene q coincidir equipo
				System.out.println("El equipo que se busca es " + nom);
				if (nom == null) {
					response.sendRedirect("jugadorInexistente.hmtl");
				} else {
					System.out.println("Se va a buscar");
					List<EquipoVO> lista = new ArrayList<EquipoVO>();
					EquipoVO miEquipo = dao.getTeam(nom);
					
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
		
					if (miEquipo != null) { // Se traslada a un jsp, para mostrar la info del jugador
						//System.out.println("El equipo del jugador es " + miEquipo.getTeam());
						lista.add(miEquipo);
						request.setAttribute("equipo",lista);
						request.getRequestDispatcher("muestraEquipo.jsp").forward(request, response);
					} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
						response.sendRedirect("jugadorInexistente.html"); 
					}
				}break;
			case "/equiposGrupo":	
				
				nom = request.getParameter("grupo"); //tiene q coincidir equipo
				System.out.println("El equipo que se busca es " + nom);
				if (nom.length() > 0) {
					System.out.println("Se va a buscar");
					List<EquipoVO> lista = new ArrayList<EquipoVO>();
					lista = dao.todosGrupo(nom);
					
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
		
					
						request.setAttribute("equiposGrupo",lista);
						request.getRequestDispatcher("TablaEquipos.jsp").forward(request, response);
					} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
						request.getRequestDispatcher("TodosGrupos.jsp").forward(request, response);
					}
				break;
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