package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import es.unizar.sisinf.grp1.db.PoolConnectionManager;
import es.unizar.sisinf.grp1.db.ConnectionManager;

public class JugadorFacade {
	private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
	private static String findGoalScorers = "Select * from jugadores order by goles desc limit 5";
	private static String findPlayerByName = "SELECT * FROM jugadores WHERE nombre = ?";
	
	public JugadorVO getPlayer(String name) {
		Connection conn = null;
		JugadorVO jugador = null;
		System.out.println("Se llega al dao");
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			System.out.println("Se obtiene la conexion");
			PreparedStatement ps = conn.prepareStatement("Select * from jugadores where nombre= ?");
			System.out.println("Antes de hacer print a la query");
			ps.setString(1, name); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			System.out.println("La query es "+ ps);
			ResultSet rset = ps.executeQuery();
			rset.next(); // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			jugador = new JugadorVO(rset.getInt("id"),rset.getInt("pJugados"),rset.getInt("pTitular"),rset.getString("nombre"),rset.getInt("goles"),
								rset.getInt("nacido"),rset.getInt("rojas"),rset.getInt("amarillas"),rset.getString("equipo"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//PoolConnectionManager.releaseConnection(conn);
		}
		return jugador;
	}
	
	public List<JugadorVO> mismoEquipo(String team) {
		Connection conn = null;
		List<JugadorVO> jugadores = new ArrayList<>();
		JugadorVO jugador = null;
		System.out.println("Se llega al dao");
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			System.out.println("Se obtiene la conexion");
			PreparedStatement ps = conn.prepareStatement("Select * from jugadores where equipo= ?");
			System.out.println("Antes de hacer print a la query");
			ps.setString(1, team); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			System.out.println("La query es "+ ps);
			ResultSet rset = ps.executeQuery();
			while(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
				jugador = new JugadorVO(rset.getInt("id"),rset.getInt("pJugados"),rset.getInt("pTitular"),rset.getString("nombre"),rset.getInt("goles"),
						rset.getInt("nacido"),rset.getInt("rojas"),rset.getInt("amarillas"),rset.getString("equipo"));
				jugadores.add(jugador);
				System.out.println("Jugador: "+jugador.getNombre());
			}
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			System.out.println("acaba");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//PoolConnectionManager.releaseConnection(conn);
		}
		return jugadores;
	}
	
	public List<JugadorVO> goleadores() {
		Connection conn = null;
		List<JugadorVO> jugadores = new ArrayList<>();
		JugadorVO jugador = null;
		System.out.println("Se llega al dao");
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			System.out.println("Se obtiene la conexion");
			PreparedStatement ps = conn.prepareStatement(findGoalScorers);
			System.out.println("Antes de hacer print a la query");
			System.out.println("La query es "+ ps);
			ResultSet rset = ps.executeQuery();
			int i = 0;
			while(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
				jugador = new JugadorVO(rset.getInt("id"),rset.getInt("pJugados"),rset.getInt("pTitular"),rset.getString("nombre"),rset.getInt("goles"),
						rset.getInt("nacido"),rset.getInt("rojas"),rset.getInt("amarillas"),rset.getString("equipo"));
				jugadores.add(jugador);
				System.out.println("Jugador: "+jugador.getNombre());
				i++;
			}
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			System.out.println("acaba con " + i +" jugadores");
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//PoolConnectionManager.releaseConnection(conn);
		}
		return jugadores;
	}
	public List<JugadorVO> getByName(String name) {
		Connection conn = null;
		List<JugadorVO> jugadores = new ArrayList<>();
		JugadorVO jugador = null;
		System.out.println("Se llega al dao");
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			System.out.println("Se obtiene la conexion");
			PreparedStatement ps = conn.prepareStatement(findPlayerByName);
			ps.setString(1, name); 
			System.out.println("Antes de hacer print a la query");
			System.out.println("La query es "+ ps);
			ResultSet rset = ps.executeQuery();
			while(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
				jugador = new JugadorVO(rset.getInt("id"),rset.getInt("pJugados"),rset.getInt("pTitular"),rset.getString("nombre"),rset.getInt("goles"),
						rset.getInt("nacido"),rset.getInt("rojas"),rset.getInt("amarillas"),rset.getString("equipo"));
				jugadores.add(jugador);
				System.out.println("Jugador: "+jugador.getNombre());
			}
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			System.out.println("acaba");
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//PoolConnectionManager.releaseConnection(conn);
		}
		return jugadores;
	}
	
}