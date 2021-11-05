package es.unizar.sisinf.grp1.model;

import java.util.Calendar;
//import java.util.Date;

/**
 * tabla users
 * @author Ernesto Bielsa Gracia
 *
 */
public class JugadorVO {
	private Integer id;
	private Integer p_jugados;
	private Integer p_titular;
	private String nombre;
	private Integer goles;
	private Integer nacido;
	private Integer rojas;
	private Integer amarillas;
	private String equipo;
	
	/**
	 * Constructor
	 */
	public JugadorVO(Integer id, Integer p_jugados, Integer p_titular, String nombre, Integer goles, Integer nacido, Integer rojas,
			Integer amarillas, String equipo) {
		this.id = id;
		this.p_jugados = p_jugados;
		this.p_titular = p_titular;
		this.nombre = nombre;
		this.goles = goles;
		this.nacido = nacido;
		this.rojas = rojas;
		this.amarillas = amarillas;
		this.equipo = equipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getP_jugados() {
		return p_jugados;
	}

	public void setP_jugados(Integer p_jugados) {
		this.p_jugados = p_jugados;
	}

	public Integer getP_titular() {
		return p_titular;
	}

	public void setP_titular(Integer p_titular) {
		this.p_titular = p_titular;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getGoles() {
		return goles;
	}

	public void setGoles(Integer goles) {
		this.goles = goles;
	}

	public Integer getNacido() {
		return nacido;
	}

	public void setNacido(Integer nacido) {
		this.nacido = nacido;
	}

	public Integer getRojas() {
		return rojas;
	}

	public void setRojas(Integer rojas) {
		this.rojas = rojas;
	}

	public Integer getAmarillas() {
		return amarillas;
	}

	public void setAmarillas(Integer amarillas) {
		this.amarillas = amarillas;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	public String getEdad() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return String.valueOf(year - this.nacido);
	}

	
}