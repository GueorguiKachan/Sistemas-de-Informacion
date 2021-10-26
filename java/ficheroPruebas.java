package es.unizar.sisinf.grp1.model;

import es.unizar.sisinf.grp1.model.EquipoFacade;
import es.unizar.sisinf.grp1.model.EquipoVO;
import es.unizar.sisinf.grp1.model.JugadorFacade;
import es.unizar.sisinf.grp1.model.JugadorVO;
import es.unizar.sisinf.grp1.model.UserFacade;
import es.unizar.sisinf.grp1.model.UserVO;
import es.unizar.sisinf.grp1.model.SolicitudEquipoFacade;
import es.unizar.sisinf.grp1.model.SolicitudEquipoVO;
import es.unizar.sisinf.grp1.model.SolicitudJugadorFacade;
import es.unizar.sisinf.grp1.model.SolicitudJugadorVO;

public class ficheroPruebas{
	
	 protected void probarEquipo() {
		
		EquipoFacade facade = new EquipoFacade();
		EquipoVO equipo = facade.getTeam("El Gancho C.F.");
		
		System.out.println("equipo = " + equipo.getTeamName());
		System.out.println("estadio = " + equipo.getStadium() + " con capacidad " + equipo.getCapacidad() + " y cesped " + equipo.getCesped());
		System.out.println("precio entradas = " + equipo.getPrecio());
		System.out.println("numero jugadores = " + equipo.getNumJugadores());
		System.out.println("grupo = " + equipo.getGrupo());
	
	}


	protected void probarJugador() {
		
		JugadorFacade facade = new JugadorFacade();
		JugadorVO jugador = facade.getPlayer(1);

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
		UserVO user = facade.getUser("Gueorgui Alexandrovitch Kachan");
		
		System.out.println("username = " + user.getUserName());
		System.out.println("password = " + user.getPassword());
		
		if(user.isEsAdmin()){
			System.out.println("El usuario es admin");
		}
		else{
			System.out.println("El usuario no es admin");
		}
	
	}

	protected void probarSolicitudEquipo() {
		
		SolicitudEquipoFacade facade = new SolicitudEquipoFacade();
		SolicitudEquipoVO solEquipo = facade.getSolicitud(1);

	System.out.println("equipo = " + solEquipo.getId());
	System.out.println("campo = " + solEquipo.getCampo());
	System.out.println("valor = " + solEquipo.getValor());
	System.out.println("numero usuario = " + solEquipo.getNomUser());
	System.out.println("codigo del equipo = " + solEquipo.getCodEquipo());
	
	}

	protected void probarSolicitudJugador() {
		
		SolicitudJugadorFacade facade = new SolicitudJugadorFacade();
		SolicitudJugadorVO solJugador = facade.getSolicitud(1);

	System.out.println("equipo = " + solJugador.getId());
	System.out.println("campo = " + solJugador.getCampo());
	System.out.println("valor = " + solJugador.getValor());
	System.out.println("numero usuario = " + solJugador.getNomUser());
	System.out.println("codigo del equipo = " + solJugador.getCodJugador());
	
	}
	
	protected void probarGrupo() {
		GrupoFacade facade = new GrupoFacade();
		GrupoVO grupo = facade.getGrupo("Grupo 2");
		
	System.out.println("grupo = " + grupo.getNombre());
	System.out.println("numero de equipos = " + grupo.getN_equipos());
		
	}
}
