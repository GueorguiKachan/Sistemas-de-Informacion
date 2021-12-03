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
@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/busquedaJugador","/jugadoresEquipo","/buscaJugador" })

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
		String nom;
		switch(action) {
			case "/busquedaJugador":
				JugadorFacade dao = new JugadorFacade();		
				int id = Integer.parseInt(request.getParameter("id"));
				
				JugadorVO miJugador = dao.getPlayer(id);
				
				request.setAttribute("jugador",miJugador);
				request.getRequestDispatcher("MostrarJugador.jsp").forward(request, response);
				break;
			case "/jugadoresEquipo":
				JugadorFacade dao2 = new JugadorFacade();		
				nom = request.getParameter("equipo");
				if (nom.length() > 0){
				List<JugadorVO> lista2 = new ArrayList<>();
				lista2 = dao2.mismoEquipo(nom);
				
				request.setAttribute("jugadoresEquipo",lista2);
				request.getRequestDispatcher("JugadoresEquipo.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("TodosEquipos.jsp").forward(request, response);
				}break;
			case "/buscaJugador":
				nom = request.getParameter("nombre");
				if (nom.length() > 0) {
				List<JugadorVO> listaJugador = new ArrayList<JugadorVO>();
				listaJugador = new JugadorFacade().getByName(nom);
				
				request.setAttribute("jugador",listaJugador);
				request.getRequestDispatcher("TablaJugadores.jsp").forward(request, response);
				}
				else {
					request.getRequestDispatcher("TodosJugadores.jsp").forward(request, response);
				}break;
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