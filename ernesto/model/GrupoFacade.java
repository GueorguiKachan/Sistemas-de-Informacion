package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.unizar.sisinf.grp1.db.ConnectionManager;


public class GrupoFacade {
	private static String findGroupByName = "Select * from grupos where nombre= ?";
	private static String findAllGroups = "Select * from grupos";
	public GrupoVO getGrupo(String groupName) {
		Connection conn = null;
		GrupoVO grupo = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement(findGroupByName);
			ps.setString(1, groupName); // setString asigna el valor del 2º argumento al parámetro que está en la posición del 1º argumento. Sustituye los ? 
			ResultSet rset = ps.executeQuery();
			rset.next(); // Next mueve el cursor una fila adelante de su posición actual
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			grupo = new GrupoVO(rset.getString("nombre"),rset.getInt("numequipos"));
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return grupo;
	}
	public List<GrupoVO> getTodosGrupos() {
		Connection conn = null;
		GrupoVO grupo = null;
		List<GrupoVO> lista = new ArrayList<>();
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			
			PreparedStatement ps = conn.prepareStatement(findAllGroups);
			 
			ResultSet rset = ps.executeQuery();
			while(rset.next()) {
				grupo = new GrupoVO(rset.getString("nombre"),rset.getInt("numEquipos"));
				lista.add(grupo);
			}
			
			//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
			
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return lista;
	}
	
	
}
