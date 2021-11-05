package es.unizar.sisinf.grp1.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.unizar.sisinf.grp1.db.ConnectionManager;
import es.unizar.sisinf.grp1.db.PoolConnectionManager;

public class UserFacade {
	
	private static String countByUserName = "SELECT count(*) cuenta FROM usuarios WHERE nombre = ?";
	private static String findByUserName = "SELECT * FROM usuarios WHERE nombre = ?";
	
	/** * Busca un registro en la tabla DEMO por ID * 
		@param id Identificador del registro buscado * 
		@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
	*/
	public boolean validateUser(UserVO user) { 
		boolean result = false;
		Connection conn = null;
		
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement countPs = conn.prepareStatement(countByUserName);
			PreparedStatement findPs = conn.prepareStatement(findByUserName);
			countPs.setString(1, user.getUserName());
			findPs.setString(1, user.getUserName());
			
			// Ejecutamos la consulta 
			ResultSet findRs = findPs.executeQuery();
			ResultSet countRs = countPs.executeQuery();
			
			countRs.next();
			int n = countRs.getInt(1);
			System.out.println("NÃºmero de registros: " + n);
			
			
			// Leemos resultados 
			if(n == 1) {
				// Comparamos contraseÃ±as
				findRs.next();
				String dbpwd = findRs.getString("password");
				if (dbpwd.contentEquals(user.getPassword())) {
					result = true;
				}
			} else { 
				result = false;  
			} 
			
			// liberamos los recursos utilizados
			findRs.close();
			findPs.close();
			countRs.close();
			countPs.close();
			ConnectionManager.releaseConnection(conn);
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} 
		
		return result;
	}
	
	public boolean esAdmin (UserVO user) {
		boolean result = false;
		Connection conn = null;
		
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = PoolConnectionManager.getConnection(); 
			PreparedStatement countPs = conn.prepareStatement(countByUserName);
			PreparedStatement findPs = conn.prepareStatement(findByUserName);
			countPs.setString(1, user.getUserName());
			findPs.setString(1, user.getUserName());
			
			// Ejecutamos la consulta 
			ResultSet findRs = findPs.executeQuery();
			ResultSet countRs = countPs.executeQuery();
			
			
			countRs.next();
			int n = countRs.getInt(1);
			System.out.println("Numero de registros: " + n);
			
			
			// Leemos resultados 
			if(n == 1) {
				// Vemos si es admin
				findRs.next();
				Boolean esAdmin = findRs.getBoolean("esAdmin");
				if (esAdmin) {
					result = true;
				}
			} else { 
				result = false;  
			} 
			
			// liberamos los recursos utilizados
			findRs.close();
			findPs.close();
			countRs.close();
			countPs.close();
			ConnectionManager.releaseConnection(conn);
		} catch(SQLException se) {
			se.printStackTrace();  
		
		} catch(Exception e) {
			e.printStackTrace(System.err); 
		} 
		
		return result;
	}
	
	public UserVO getUser(String username) {
		Connection conn = null;
		UserVO user = null;

		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement("Select * from usuarios where nombre= ?");
			ps.setString(1, username);
			ResultSet rset = ps.executeQuery();
			rset.next();
			user = new UserVO(rset.getString("nombre"), rset.getString("password"), rset.getBoolean("esadmin"));
			ConnectionManager.releaseConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}
	
}

