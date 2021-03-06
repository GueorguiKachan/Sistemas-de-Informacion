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
	private static String findAlikeUsers = "SELECT count(*) cuenta FROM usuarios WHERE nombre = ? AND password = ?";
	private static String insertUser = "INSERT into usuarios(nombre,password,esAdmin) values (?,?,'false')";
	
	/** * Busca un registro en la tabla DEMO por ID * 
		@param id Identificador del registro buscado * 
		@returnObjeto DemoVO con el identificador buscado, o null si no seencuentra 
	*/
	public int validateUser(UserVO user) { 
		int result = 0; // 0 no es user, 1 es user, 2 es admin
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
				boolean admin = findRs.getBoolean("esAdmin");
				if (dbpwd.contentEquals(user.getPassword())) {
					if(admin) {
					result = 2;
					}
					else {
					result = 1;
					}
				}
			} else { 
				result = 0;  
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
	public boolean registrarUsuario(UserVO user) {
		boolean result = false;
		Connection conn = null;
		try {
			
			conn = ConnectionManager.getConnection(); 
			PreparedStatement countUs = conn.prepareStatement(countByUserName);
			countUs.setString(1, user.getUserName());
			//countUs.setString(2, user.getPassword());
			
			ResultSet countRs = countUs.executeQuery();
			
			countRs.next();
			int n = countRs.getInt(1);
			System.out.println("Numero de registros: " + n);
			
			// Leemos resultados 
			if(n != 0) { // Ya hay alguien registrado que se llame así
				
				result = false;
			} else { 
				
				PreparedStatement insert = conn.prepareStatement(insertUser);
				insert.setString(1, user.getUserName());
				insert.setString(2, user.getPassword());
				int resultado = insert.executeUpdate();
				if(resultado > 0) {
					result = true;  
				}
				else {
					result = false;
				}
				insert.close();
			} 
			
			// liberamos los recursos utilizados
			countRs.close();
			countUs.close();
			ConnectionManager.releaseConnection(conn);
		}catch(SQLException se) {
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


