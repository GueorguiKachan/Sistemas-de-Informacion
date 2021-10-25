package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class SolicitudJugadorFacade {
	
	/** * Busca un registro en la tabla DEMO por ID * 
		@param id Identificador del registro buscado * 
		@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
	*/
   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 // No se muy bien como vamos a sacar la info de las solicitudes así que pongo que aquí supongo que se buscan por el código de la solicitud
	public SolicitudJugadorVO getSolicitud (Integer id) {
		Connection conn = null;
		SolicitudJugadorVO solicitud = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from solicitudJugador where id= ?");
			ps.setString(1, id.toString());
			ResultSet rset = ps.executeQuery();
			rset.next();
			solicitud = new SolicitudJugadorVO(rset.getInt("id"), rset.getString("campo"), rset.getString("valor"),
					rset.getString("nomUser"),rset.getInt("codJugador"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return solicitud;
	}
	
}
