package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.ConnectionManager;
//import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class SolicitudJugadorFacade {
	
	private static String findSolicitudById = "Select * from solicitudJugador where id= ?";
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
	
}