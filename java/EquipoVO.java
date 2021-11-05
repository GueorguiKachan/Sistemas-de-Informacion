package es.unizar.sisinf.grp1.model;

public class EquipoVO {
	
	public EquipoVO(String teamName, Integer numJugadores, Integer precio, String stadium,
			String capacidad, String cesped,   String grupo) {
		super();
		this.teamName = teamName;
		this.stadium = stadium;
		this.precio = precio;
		this.numJugadores = numJugadores;
		this.grupo = grupo;
		this.capacidad = capacidad;
		this.cesped = cesped;
	}
	private String teamName;
	private String stadium;
	private Integer precio;
	private Integer numJugadores;
	private String grupo;
	private String capacidad;
	private String cesped;
	/**
	 * Constructor
	 * @param userName
	 * @param password
	 */
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public Integer getNumJugadores() {
		return numJugadores;
	}
	public void setNumJugadores(Integer numJugadores) {
		this.numJugadores = numJugadores;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}
	public String getCesped() {
		return cesped;
	}
	public void setCesped(String cesped) {
		this.cesped = cesped;
	}
	
}
