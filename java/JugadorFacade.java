package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class JugadorFacade {
	private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
	
	public JugadorVO getPlayer(String playerName) {
		Connection conn = null;
		JugadorVO jugador = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Select * from jugadores where nombre= ?");
			ps.setString(1, playerName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			rset.next(); // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			jugador = new JugadorVO(rset.getInt("id"),rset.getInt("pJugados"),rset.getInt("pTitular"),rset.getString("nombre"),rset.getInt("goles"),
								rset.getInt("nacido"),rset.getInt("rojas"),rset.getInt("amarillas"),rset.getString("equipo"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return jugador;
	}
}
