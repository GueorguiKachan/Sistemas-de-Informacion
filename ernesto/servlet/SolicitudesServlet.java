package es.unizar.sisinf.grp1.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.model.EquipoFacade;
import es.unizar.sisinf.grp1.model.EquipoVO;
import es.unizar.sisinf.grp1.model.JugadorFacade;
import es.unizar.sisinf.grp1.model.JugadorVO;
import es.unizar.sisinf.grp1.model.UserFacade;
import es.unizar.sisinf.grp1.model.UserVO;
import es.unizar.sisinf.grp1.model.SolicitudJugadorFacade;
import es.unizar.sisinf.grp1.model.SolicitudJugadorVO;
import es.unizar.sisinf.grp1.model.SolicitudVO;
import es.unizar.sisinf.grp1.model.SolicitudEquipoFacade;
import es.unizar.sisinf.grp1.model.SolicitudEquipoVO;
import es.unizar.sisinf.grp1.model.SolicitudFacade;

/**
 * Servlet implementation class BusquedaJugadorSerlvet
 */
@WebServlet(description = "Servlet de creacion de solicitudes", urlPatterns = { "/crearSolicitudJugador", "/crearSolicitudEquipo" ,"/solicitudes",
		"/editarEquipo","/borrarSolicitudEquipo","/borrarSolicitudJugador","/editarJugador", "/GuardarEditarEquipo" , "/GuardarEditarJugador", "/prueba" })

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
		String usuario;
		String campo;
		String valorNuevo;
		int id;
		String id2;
		EquipoVO evo = null;
		JugadorVO jvo = null;
		SolicitudFacade daosolicitud = null;
		SolicitudVO solicitud = null; 
		SolicitudJugadorVO sjvo = null;
		SolicitudEquipoVO sevo = null;
		List<SolicitudVO> lista = null;
		switch(action) {
		case "/prueba":
			request.getRequestDispatcher("Solicitudes.jsp").forward(request, response);
			System.out.println("QUE ");
			case "/crearSolicitudJugador":
				System.out.println("PASA ");
				SolicitudJugadorFacade dao = new SolicitudJugadorFacade();		
				System.out.println("1");
				id = Integer.parseInt(request.getParameter("solicitudJugadorNombre"));	
				System.out.println("2:"+ id);
				campo = request.getParameter("solicitudJugadorCampo");	
				System.out.println("3:"+campo);
				valorNuevo = request.getParameter("solicitudJugadorValorNuevo");	
				System.out.println("4:"+valorNuevo);
				usuario = (String)request.getSession().getAttribute("user");	
				System.out.println("5:"+usuario);
				sjvo = new SolicitudJugadorVO(0,campo,valorNuevo,usuario,id);
				System.out.println("6");
				dao.introducirSolicitud(sjvo);
				System.out.println("7");
				
				request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
					break;
			case "/crearSolicitudEquipo":
				SolicitudEquipoFacade dao2 = new SolicitudEquipoFacade();		
				id2 = request.getParameter("solicitudEquipoNombre");
				campo = request.getParameter("solicitudEquipoCampo");
				valorNuevo = request.getParameter("solicitudEquipoValorNuevo");
				usuario = (String)request.getSession().getAttribute("user");
				sevo = new SolicitudEquipoVO(0,campo,valorNuevo,usuario,id2);
				dao2.introducirSolicitudEquipo(sevo);
				
				request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
				break;
			case "/solicitudes":
				request.getRequestDispatcher("Solicitudes.jsp").forward(request, response);
				break;
			case "/editarEquipo":
				sevo = new SolicitudEquipoFacade().getSolicitud(Integer.parseInt(request.getParameter("id")));
				evo = new EquipoFacade().getTeam(sevo.getCodEquipo());
				request.setAttribute("solicitud",sevo);
				request.setAttribute("equipo",evo);
				request.getRequestDispatcher("EditarEquipo.jsp").forward(request, response);
				break;
			case "/editarJugador":
				sjvo = new SolicitudJugadorFacade().getSolicitud(Integer.parseInt(request.getParameter("id")));
				jvo = new JugadorFacade().getPlayer(sjvo.getCodJugador());
				request.setAttribute("solicitud",sjvo);
				request.setAttribute("jugador",jvo);
				request.getRequestDispatcher("EditarJugador.jsp").forward(request, response);
				break;
			case "/borrarSolicitudEquipo":
				sevo = new SolicitudEquipoFacade().getSolicitud(Integer.parseInt(request.getParameter("id")));
				new SolicitudFacade().eliminarSolicitudEquipo(sevo);
				request.getRequestDispatcher("Solicitudes.jsp").forward(request, response);
				break;
			case "/borrarSolicitudJugador":
				System.out.println("falla1");
				sjvo = new SolicitudJugadorFacade().getSolicitud(Integer.parseInt(request.getParameter("id")));
				System.out.println("falla2");
				new SolicitudFacade().eliminarSolicitudJugador(sjvo);
				System.out.println("falla3");
				request.getRequestDispatcher("Solicitudes.jsp").forward(request, response);
				break;
			case "/GuardarEditarEquipo":
				evo = new EquipoFacade().getTeam(request.getParameter("equipo"));
				evo.setCapacidad(request.getParameter("capacidad"));
				evo.setGrupo(request.getParameter("grupo"));
				evo.setStadium(request.getParameter("estadio"));
				evo.setCesped(request.getParameter("cesped"));
				evo.setPrecio(Integer.parseInt(request.getParameter("precio")));
				new SolicitudFacade().modificarEquipo(evo);
				sevo = new SolicitudEquipoFacade().getSolicitud(Integer.parseInt(request.getParameter("idsolicitud")));
				new SolicitudFacade().eliminarSolicitudEquipo(sevo);
				request.getRequestDispatcher("Solicitudes.jsp").forward(request, response);
				break;
			case "/GuardarEditarJugador":
				jvo = new JugadorFacade().getPlayer(Integer.parseInt(request.getParameter("idjugador")));
				jvo.setEquipo(request.getParameter("equipo"));
				jvo.setNacido(Integer.parseInt(request.getParameter("nacido")));
				jvo.setP_jugados(Integer.parseInt(request.getParameter("pjugados")));
				jvo.setP_titular(Integer.parseInt(request.getParameter("ptitular")));
				jvo.setAmarillas(Integer.parseInt(request.getParameter("amarillas")));
				jvo.setRojas(Integer.parseInt(request.getParameter("rojas")));
				jvo.setGoles(Integer.parseInt(request.getParameter("goles")));
				new SolicitudFacade().modificarJugador(jvo);
				sjvo = new SolicitudJugadorFacade().getSolicitud(Integer.parseInt(request.getParameter("idsolicitud")));
				new SolicitudFacade().eliminarSolicitudJugador(sjvo);
				request.getRequestDispatcher("Solicitudes.jsp").forward(request, response);
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