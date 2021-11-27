package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.ConnectionManager;
//import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class SolicitudEquipoFacade {
	private static String findSolicitudById = "Select * from solicitudEquipo where id= ?";
	private static String introduceNewSolicitud = "Insert into solicitudEquipo values (? , ? , ? , ? , ?)";
	private static String getMaxID = "select id from solicitudEquipo order by id desc limit 1";
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
	
	public void introducirSolicitud(SolicitudEquipoVO solicitudEquipo) {
		Connection conn = null;
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(getMaxID);
			ResultSet rset = ps.executeQuery();
			rset.next();
			System.out.println("antes de sumar 1");
			int idsiguiente = rset.getInt("id")+1;
			System.out.println("despues de sumar 1");
			ps = conn.prepareStatement(introduceNewSolicitud);
			System.out.println("despues de preparar la sentencia");
			ps.setInt(1, idsiguiente);
			System.out.println("despues de 1");
			ps.setString(2, solicitudEquipo.getCampo());
			System.out.println("despues de 2");
			ps.setString(3, solicitudEquipo.getValor());
			System.out.println("despues de 3");
			ps.setString(4, solicitudEquipo.getNomUser());
			System.out.println("despues de 4");
			ps.setString(5, solicitudEquipo.getCodEquipo());
			System.out.println("despues de 5");
			ps.executeQuery();
			System.out.println("despues de query");
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}