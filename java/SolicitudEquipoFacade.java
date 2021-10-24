package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class SolicitudEquipoFacade {
	
	/** * Busca un registro en la tabla DEMO por ID * 
		@param id Identificador del registro buscado * 
		@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
	*/
   // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	 // No se muy bien como vamos a sacar la info de las solicitudes así que pongo que aquí supongo que se buscan por el código de la solicitud
	public SolicitudEquipoVO getSolicitud (Integer id) {
		Connection conn = null;
		solicitudEquipoVO solicitud = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from solicitudEquipo where id= ?");
			ps.setString(1, id);
			ResultSet rset = ps.executeQuery();
			rset.next();
			solicitud = new SolicitudEquipoVO(rset.getInteger("id"), rset.getString("campo"), rset.getString("valor"),rset.getString("nomUser"),rset.getInteger("codEquipo"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return solicitud;
	}
	
}
