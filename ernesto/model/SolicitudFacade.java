package es.unizar.sisinf.grp1.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

//import es.unizar.sisinf.grp1.db.PoolConnectionManager;
import es.unizar.sisinf.grp1.db.ConnectionManager;

public class SolicitudFacade {
	private static String findSolicitudesJugador = "Select * from solicitudJugador";
	private static String findSolicitudesEquipo = "Select * from solicitudEquipo";
	private static String eliminarSolicitudJugador = "delete from solicitudJugador where id = ?";
	private static String eliminarSolicitudEquipo = "delete from solicitudEquipo where id = ?";
	private static String modifyJugador ="Update jugadores set nacido = ?, rojas = ?, amarillas = ?, pjugados = ?, ptitular = ?, goles = ?, equipo = ? where id = ?";
	private static String modifyEquipo ="Update equipos set precioent = ?, estadio = ?, capacidad = ?, tipocesped = ?, grupo = ? where nombre = ?";
	public List<SolicitudVO> getTodasSolicitudes() {
		Connection conn = null;
		List<SolicitudVO> lista = new ArrayList<>();
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(findSolicitudesJugador);
			SolicitudVO solicitud = null;
			System.out.println("Se llega al dao");
			ResultSet rset = ps.executeQuery();
			while(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
					solicitud = new SolicitudJugadorVO(rset.getInt("id"),rset.getString("campo"),rset.getString("valor"),rset.getString("nomuser"),rset.getInt("codjugador"));
					lista.add(solicitud);
				}
			ps = conn.prepareStatement(findSolicitudesEquipo);
			rset = ps.executeQuery();
			while(rset.next()) { // Next mueve el cursor una fila adelante de su posición actual
				solicitud = new SolicitudEquipoVO(rset.getInt("id"),rset.getString("campo"),rset.getString("valor"),rset.getString("nomuser"),rset.getString("codequipo"));
				lista.add(solicitud);
			}
				//getString-getInteger devuelven el valor que haya en la columna indicada o bien por un número o bien por su nombre
				System.out.println("acaba");
				ConnectionManager.releaseConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//PoolConnectionManager.releaseConnection(conn);
			}
			return lista;
	}
	
	public void eliminarSolicitudJugador(SolicitudVO solicitud) {
		Connection conn = null;
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(eliminarSolicitudJugador);
			ps.setInt(1, solicitud.getId());
			ps.executeQuery();
			System.out.println("despues de query");
				ConnectionManager.releaseConnection(conn);
			} catch (Exception e) {
				
			} finally {
				//PoolConnectionManager.releaseConnection(conn);
			}
	}
	public void eliminarSolicitudEquipo(SolicitudVO solicitud) {
		Connection conn = null;
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(eliminarSolicitudEquipo);
			ps.setInt(1, solicitud.getId());
			ps.executeQuery();
			System.out.println("despues de query");
				ConnectionManager.releaseConnection(conn);
			} catch (Exception e) {
				
			} finally {
				//PoolConnectionManager.releaseConnection(conn);
			}
	}
	
	public void modificarJugador(JugadorVO jugador) {
		Connection conn = null;
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
			conn = ConnectionManager.getConnection(); 
			PreparedStatement ps = conn.prepareStatement(modifyJugador);
			ps.setInt(1, jugador.getNacido());
			ps.setInt(2, jugador.getRojas());
			ps.setInt(3, jugador.getAmarillas());
			ps.setInt(4, jugador.getP_jugados());
			ps.setInt(5, jugador.getP_titular());
			ps.setInt(6, jugador.getGoles());
			ps.setString(7, jugador.getEquipo());
			ps.setInt(8, jugador.getId());
			ps.executeQuery();
				ConnectionManager.releaseConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				//PoolConnectionManager.releaseConnection(conn);
			}
	}
	
	public void modificarEquipo(EquipoVO equipo) {
		Connection conn = null;
		try {
			// Abrimos la conexiÃ³n e inicializamos los parÃ¡metros 
						conn = ConnectionManager.getConnection(); 
						PreparedStatement ps = conn.prepareStatement(modifyEquipo);

						System.out.println("despues de 1");
						ps.setInt(1, equipo.getPrecio());
						System.out.println("despues de 2");
						ps.setString(2, equipo.getStadium());
						System.out.println("despues de 3");
						ps.setString(3, equipo.getCapacidad());
						System.out.println("despues de 4");
						ps.setString(4, equipo.getCesped());
						System.out.println("despues de 5");
						ps.setString(5, equipo.getGrupo());
						System.out.println("despues de 6");
						ps.setString(6, equipo.getTeamName());
						System.out.println("despues de 7");
						System.out.println(ps);
						ps.executeQuery();
						System.out.println("despues de 8");
							ConnectionManager.releaseConnection(conn);
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							//PoolConnectionManager.releaseConnection(conn);
						}
	}
}
