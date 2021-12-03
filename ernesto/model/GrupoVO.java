package es.unizar.sisinf.grp1.model;


/**
 * tabla users
 * @author Ernesto Bielsa Gracia
 *
 */
public class GrupoVO {
	
	private String nombre;
	private Integer n_equipos;
	/**
	 * Constructor
	 */
	public GrupoVO(String nombre, Integer n_equipos) {
		super();
		this.nombre = nombre;
		this.n_equipos = n_equipos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getN_equipos() {
		return n_equipos;
	}
	public void setN_equipos(Integer n_equipos) {
		this.n_equipos = n_equipos;
	}
	

	
}