package es.unizar.sisinf.grp1.model;

import java.util.Date;

/**
 * tabla users
 * @author sisinf
 *
 */
public class solicitudJugadorVO {
	private Integer id;
	private String campo;
	private String valor;
	private String nomUser;
	private Integer codJugador;
	
	/**
	 * Constructor
	 * @param userName
	 * @param password
	 */
	
	
	public solicitudJugadorVO(Integer id, String campo, String valor, String nomUser, Integer codJugador) {
		super();
		this.id = id;
		this.campo = campo;
		this.valor = valor;
		this.nomUser = nomUser;
		this.codJugador = codJugador;
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

	public Integer getCodJugador() {
		return codJugador;
	}

	public void setCodJugador(Integer codJugador) {
		this.codJugador = codJugador;
	}
	
}
