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
@WebServlet(description = "Servlet de busqueda de jugadores", urlPatterns = { "/busquedaJugador" })

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
			case "/busquedaJugador":
				JugadorFacade dao = new JugadorFacade();		
				int id = Integer.parseInt(request.getParameter("id"));
				
				List<JugadorVO> lista = new ArrayList<>();
				JugadorVO miJugador = dao.getPlayer(id);
				
				lista.add(miJugador);
				request.setAttribute("jugador",lista);
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