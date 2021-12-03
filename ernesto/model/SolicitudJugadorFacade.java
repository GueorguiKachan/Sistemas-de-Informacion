package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.ConnectionManager;
//import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class SolicitudJugadorFacade {
	
	private static String findSolicitudById = "Select * from solicitudJugador where id= ?";
	private static String introduceNewSolicitud = "Insert into solicitudJugador values (? , ? , ? , ? , ?)";
	private static String getMaxID = "select id from solicitudJugador order by id desc limit 1";
   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 // No se muy bien como vamos a sacar la info de las solicitudes así que pongo que aquí supongo que se buscan por el código de la solicitud
	public SolicitudJugadorVO getSolicitud (int id) {
		Connection conn = null;
		SolicitudJugadorVO solicitud = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(findSolicitudById);
			ps.setInt(1, id);
			ResultSet rset = ps.executeQuery();
			rset.next();
			solicitud = new SolicitudJugadorVO(rset.getInt("id"), rset.getString("campo"), rset.getString("valor"),
					rset.getString("nomUser"),rset.getInt("codJugador"));
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return solicitud;
	}
	
	public void introducirSolicitud(SolicitudJugadorVO solicitudJugador) {
		Connection conn = null;
		try {
			System.out.println("AÑADIR SOLICITUD");
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(getMaxID);
			ResultSet rset = ps.executeQuery();
			int idsiguiente = 1;
			if (rset.next()) {
				System.out.println("antes de sumar 1");
				idsiguiente = rset.getInt("id")+1;
				}
			System.out.println("despues de sumar 1");
			ps = conn.prepareStatement(introduceNewSolicitud);
			System.out.println("despues de preparar la sentencia");
			ps.setInt(1, idsiguiente);
			System.out.println("despues de 1");
			ps.setString(2, solicitudJugador.getCampo());
			System.out.println("despues de 2");
			ps.setString(3, solicitudJugador.getValor());
			System.out.println("despues de 3");
			ps.setString(4, solicitudJugador.getNomUser());
			System.out.println("despues de 4");
			ps.setInt(5, solicitudJugador.getCodJugador());
			System.out.println("despues de 5:");
			System.out.println(ps);
			ps.executeQuery();
			System.out.println("despues de query");
			ConnectionManager.releaseConnection(conn);
			System.out.println("TERMINAR SOLICITUD");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}