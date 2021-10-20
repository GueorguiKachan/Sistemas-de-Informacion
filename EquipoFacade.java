package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class equipoFacade {
	private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
	private static String findByUserName = "SELECT * FROM users WHERE username = ?";
	private static String updateDate = "UPDATE users set last_login = current_timestamp where username = ?";
	
	public String getTeam(String teamName) {
		Connection conn = null;
		equipoVO equipo = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from equipos where nombre= ?");
			ps.setString(1, teamName);
			ResultSet rset = ps.executeQuery();
			rset.next();
			equipo = new equipoVO(rset.getString("teamName"),rset.getString("stadium"),rset.getInteger("precio"),
								rset.getString("stadium"),rset.getString("grupo"),rset.getString("stadium"),rset.getString("stadium"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return equipo;
	}
}
