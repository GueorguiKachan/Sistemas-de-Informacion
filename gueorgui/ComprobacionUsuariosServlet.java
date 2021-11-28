package es.unizar.sisinf.grp1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.unizar.sisinf.grp1.model.EquipoFacade;
import es.unizar.sisinf.grp1.model.EquipoVO;
import es.unizar.sisinf.grp1.model.UserFacade;
import es.unizar.sisinf.grp1.model.UserVO;

@WebServlet(description = "Servlet de registro y comprobacion de users", urlPatterns = { "/login" ,"/registro","/salir" })
public class ComprobacionUsuariosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComprobacionUsuariosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		UserFacade dao = new UserFacade();
		System.out.println("La accion es "+action);
		switch(action) {
			case "/login":
				//UserFacade dao = new UserFacade();		
				String nomUser = request.getParameter("username");
				String password = request.getParameter("password");
				System.out.println("El usuario que se busca es " + nomUser);
				if (nomUser == null || password == null) {
					response.sendRedirect("jugadorInexistente.hmtl"); // Esta pagina cambiarla
				} else {
					System.out.println("Se va a buscar");
					UserVO user = new UserVO(nomUser,password);
					
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
					int res = dao.validateUser(user);
					if (res != 0) { // Se traslada a un jsp, para mostrar la info del jugador
						System.out.println("Se ha reconocido al usuario");
						HttpSession session= request.getSession();
						session.setAttribute("user",nomUser);
						if(res == 2) {
							user.setEsAdmin(true);
							session.setAttribute("admin", true);
							System.out.println("Se reconoce como admin");
						}
						
						session.setAttribute("admin", res);
						//request.setAttribute("nomUser", nomUser);
						request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
						
					} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
						response.sendRedirect("jugadorInexistente.html"); // Cambiar esta pagina
					}
					break;
				}
			case "/registro":
				System.out.println("Registrar un usuario");
				//UserFacade dao = new UserFacade();		
				nomUser = request.getParameter("username");
				password = request.getParameter("password");
				if (nomUser == null || password == null) {
					response.sendRedirect("jugadorInexistente.hmtl"); // Esta pagina cambiarla
				} else {
					System.out.println("Se va a registrar");
					UserVO user = new UserVO(nomUser,password);
					
					//System.out.println("El equipo del jugador es " + miJugador.getEquipo());
		
					if (dao.registrarUsuario(user)) { // Se traslada a un jsp, para mostrar la info del jugador
						System.out.println("Se ha registrado al usuario");

						request.setAttribute("nomUser", nomUser);
						HttpSession session= request.getSession(); 
						//						Cookie iniSesion = new Cookie("nombreLogin",nomUser);
//						response.addCookie(iniSesion);
//						iniSesion.setMaxAge(30*60);
						session.setAttribute("user",nomUser);
//						request.getSession().setAttribute("user",nomUser);
//						response.sendRedirect("logged.jsp");
						request.getRequestDispatcher("PaginaPrincipal.jsp").forward(request, response);
					} else { // Se envía al usuario a un html con info únicamente estática, no es necesario jsp
						response.sendRedirect("jugadorInexistente.html"); // Cambiar esta pagina
					}
				}
				break;
			case "/salir":
				request.getSession().invalidate();
				response.sendRedirect("PaginaPrincipal.jsp");
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
