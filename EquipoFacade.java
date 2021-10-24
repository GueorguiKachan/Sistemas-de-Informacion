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
			ps.setString(1, teamName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			rset.next(); // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			equipo = new equipoVO(rset.getString("nombre"),rset.getString("estadio"),rset.getInteger("precioEnt"),
								rset.getInteger("numJugadores"),rset.getString("grupo"),rset.getInteger("capacidad"),rset.getString("tipoCesped"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return equipo;
	}
}
