package es.unizar.sisinf.grp1.model;

//import java.util.Date;

/**
 * tabla users
 * @author sisinf
 *
 */
public interface SolicitudVO {

	public Integer getId();

	public void setId(Integer id);

	public String getCampo();

	public void setCampo(String campo);

	public String getValor();

	public void setValor(String valor);

	public String getNomUser();

	public void setNomUser(String nomUser);

	public Integer getCodJugador();

	public void setCodJugador(Integer codJugador);
	
	public String getCodEquipo();
	
	public void setCodEquipo(String codEquipo);
	
}