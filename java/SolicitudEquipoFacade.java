package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.ConnectionManager;
//import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class SolicitudEquipoFacade {
	private static String findSolicitudById = "Select * from solicitudEquipo where id= ?";
	
   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 // No se muy bien como vamos a sacar la info de las solicitudes así que pongo que aquí supongo que se buscan por el código de la solicitud
	public SolicitudEquipoVO getSolicitud (int id) {
		Connection conn = null;
		SolicitudEquipoVO solicitud = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(findSolicitudById);
			ps.setInt(1, id);
			ResultSet rset = ps.executeQuery();
			rset.next();
			solicitud = new SolicitudEquipoVO(rset.getInt("id"), rset.getString("campo"), rset.getString("valor"),
					rset.getString("nomUser"),rset.getString("codEquipo"));
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return solicitud;
	}
	
}