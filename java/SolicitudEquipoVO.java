package es.unizar.sisinf.grp1.model;

import java.util.Date;

/**
 * tabla users
 * @author sisinf
 *
 */
public class SolicitudEquipoVO {
	private Integer id;
	private String campo;
	private String valor;
	private String nomUser;
	private Integer codEquipo;
	
	/**
	 * Constructor
	 * @param userName
	 * @param password
	 */
	
	
	public SolicitudEquipoVO(Integer id, String campo, String valor, String nomUser, Integer codEquipo) {
		super();
		this.id = id;
		this.campo = campo;
		this.valor = valor;
		this.nomUser = nomUser;
		this.codEquipo = codEquipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNomUser() {
		return nomUser;
	}

	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}

	public Integer getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(Integer codEquipo) {
		this.codEquipo = codEquipo;
	}
	
}
