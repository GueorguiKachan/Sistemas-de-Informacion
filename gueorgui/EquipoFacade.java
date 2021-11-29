package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.unizar.sisinf.grp1.db.ConnectionManager;

public class EquipoFacade {
	private static String countByUserName = "SELECT count(*) cuenta FROM users WHERE username = ?";
	
	public EquipoVO getTeam(String teamName) {
		Connection conn = null;
		EquipoVO equipo = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Select * from equipos where nombre= ?");
			ps.setString(1, teamName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			if(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
				equipo = new EquipoVO(rset.getString("nombre"),rset.getString("estadio"),rset.getInt("precioEnt"),
								rset.getInt("numJugadores"),rset.getString("grupo"),rset.getInt("capacidad"),rset.getString("tipoCesped"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//PoolConnectionManager.releaseConnection(conn);
		}
		return equipo;
	}
	
	public List<EquipoVO> todosGrupo(String groupName) {
		Connection conn = null;
		EquipoVO equipo = null;
		List<EquipoVO> grupo = null;//new ArrayList<>();

		try {
			// Abrimos la conexion e inicializamos los parametros 
			conn = ConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement("Select * from equipos where grupo= ?");
			ps.setString(1, groupName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			if(rset.isBeforeFirst()) {
				grupo = new ArrayList<>(); 
			}
			while(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
				System.out.println("Se ha encontrado el grupo");
				equipo = new EquipoVO(rset.getString("nombre"),rset.getString("estadio"),rset.getInt("precioEnt"),
						rset.getInt("numJugadores"),rset.getString("grupo"),rset.getInt("capacidad"),rset.getString("tipoCesped"));
				grupo.add(equipo);
			}
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//PoolConnectionManager.releaseConnection(conn);
		}
		return grupo;

	}
}
