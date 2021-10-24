package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class jugadorFacade {
	private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
	
	public String getPlayer(String playerName) {
		Connection conn = null;
		jugadorVO jugador = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Select * from jugadores where nombre= ?");
			ps.setString(1, playerName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			rset.next(); // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			jugador = new jugadorVO(rset.getInteger("id"),rset.getInteger("pJugados"),rset.getInteger("pTitular"),rset.getString("nombre"),rset.getInteger("goles")
								rset.getInteger("nacido"),rset.getInteger("rojas"),rset.getInteger("amarillas"),rset.getString("equipo"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PoolConnectionManager.releaseConnection(conn);
		}
		return jugador;
	}
}

