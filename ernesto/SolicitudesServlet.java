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
import es.unizar.sisinf.grp1.model.UserFacade;
import es.unizar.sisinf.grp1.model.UserVO;
import es.unizar.sisinf.grp1.model.SolicitudJugadorFacade;
import es.unizar.sisinf.grp1.model.SolicitudJugadorVO;
import es.unizar.sisinf.grp1.model.SolicitudEquipoFacade;
import es.unizar.sisinf.grp1.model.SolicitudEquipoVO;

/**
 * Servlet implementation class BusquedaJugadorSerlvet
 */
@WebServlet(description = "Servlet de creacion de solicitudes", urlPatterns = { "/crearSolicitudJugador"})

public class SolicitudesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolicitudesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		switch(action) {
			case "/crearSolicitudJugador":
				SolicitudJugadorFacade dao = new SolicitudJugadorFacade();		
				int id = Integer.parseInt(request.getParameter("solicitudJugadorNombre"));
				String campo = request.getParameter("solicitudJugadorCampo");
				String valorNuevo = request.getParameter("solicitudJugadorValorNuevo");
				SolicitudJugadorVO solicitudJugador = new SolicitudJugadorVO(0,campo,valorNuevo,"Gueorgui Alexandrovitch Kachan",id);
				dao.introducirSolicitud(solicitudJugador);
				
				request.getRequestDispatcher("paginaPrincipal.jsp").forward(request, response);
					
			case "/crearSolicitudEquipo":
				SolicitudEquipoFacade dao2 = new SolicitudEquipoFacade();		
				String id2 = request.getParameter("solicitudEquipoNombre");
				String campo2 = request.getParameter("solicitudEquipoCampo");
				String valorNuevo2 = request.getParameter("solicitudEquipoValorNuevo");
				SolicitudEquipoVO solicitudEquipo2 = new SolicitudEquipoVO(0,campo2,valorNuevo2,"Gueorgui Alexandrovitch Kachan",id2);
				dao2.introducirSolicitud(solicitudEquipo2);
				
				request.getRequestDispatcher("paginaPrincipal.jsp").forward(request, response);
			
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