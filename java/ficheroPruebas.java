import es.unizar.sisinf.grp1.model.EquipoFacade;
import es.unizar.sisinf.grp1.model.EquipoVO;
import es.unizar.sisinf.grp1.model.JugadorFacade;
import es.unizar.sisinf.grp1.model.JugadorVO;
import es.unizar.sisinf.grp1.model.UserFacade;
import es.unizar.sisinf.grp1.model.UserVO;

public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void probarEquipo() {
		
		UserFacade facade = new UserFacade();
		UserVO user = facade.getUser("Gueorgui");
		
		System.out.println("equipo = " + equipo.getTeamName());
		System.out.println("estadio = " + equipo.getStadium() + " con capacidad " + equipo.getCapacidad() + " y cesped " + equipo.getCesped());
		System.out.println("precio entradas = " + equipo.getPrecio());
		System.out.println("numero jugadores = " + equipo.getNumJugadores());
		System.out.println("grupo = " + equipo.getGrupo());
	
	}


	protected void probarJugador() {
		
		JugadorFacade facade = new JugadorFacade();
		JugadorVO jugador = facade.getPlayer("Ernesto Bielsa");

		System.out.println("id = " + jugador.getId());
		System.out.println("estadio = " + jugador.getP_jugados());
		System.out.println("precio entradas = " + jugador.getP_titular());
		System.out.println("nombre = " + jugador.getNombre());
		System.out.println("goles = " + jugador.getGoles());
		System.out.println("nacido = " + jugador.getNacido() + " y edad " + jugador.getEdad());
		System.out.println("grupo = " + jugador.getRojas());
		System.out.println("grupo = " + jugador.getAmarillas());
		System.out.println("grupo = " + jugador.getEquipo());
	}

	protected void probarUsuario() {
		
		UserFacade facade = new UserFacade();
		UserVO user = facade.getUser("telleria@unizar.es");
		
		System.out.println("username = " + user.getUserName());
		System.out.println("password = " + user.getPassword());
		
		if(user.isEsAdmin()){
			System.out.println("El usuario es admin");
		}
		else{
			System.out.println("El usuario no es admin");
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