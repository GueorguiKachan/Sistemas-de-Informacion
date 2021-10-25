package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class EquipoFacade {
	private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
	
	public EquipoVO getTeam(String teamName) {
		Connection conn = null;
		EquipoVO equipo = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Select * from equipos where nombre= ?");
			ps.setString(1, teamName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			rset.next(); // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			equipo = new EquipoVO(rset.getString("nombre"),rset.getString("estadio"),rset.getInt("precioEnt"),
								rset.getInt("numJugadores"),rset.getString("grupo"),rset.getInt("capacidad"),rset.getString("tipoCesped"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return equipo;
	}
}