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
import es.unizar.sisinf.grp1.model.ficheroPruebas;

import java.sql.Connection;

import javax.naming.InitialContext;

import es.unizar.sisinf.grp1.db.ConnectionManager;



public class Main  {
	public static void main(String[] args) {
		
		//ConnectionManager conexion = new ConnectionManager();
		//Connection con;
		try{
			//InitialContext ctx = new InitialContext();
			//Connection con = ConnectionManager.getConnection();
			//ficheroPruebas fichero = new ficheroPruebas();
			//fichero.probarEquipo();
			GrupoFacade grupo = new GrupoFacade();
			GrupoVO grupo2 = grupo.getGrupo("Grupo 2");
			System.out.println(grupo2.getNombre());
			//fichero.probarGrupo();
			//fichero.probarJugador();
			//fichero.probarSolicitudEquipo();
			//fichero.probarSolicitudJugador();
			//fichero.probarUsuario();
			//ConnectionManager.releaseConnection(con);
		}
		catch(Exception e) {System.out.println("Something went wrong.");}
	}




}
