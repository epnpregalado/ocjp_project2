package epn.edu.ec.ocjp.core;

/**
 * Entidad que define el autobus
 * @author jpatrick
 *
 */
public class AutoBus {

	private String placas;
	private String cooperativa;
	private Integer numeroAsientos;
	
	public String getPlacas() {
		return placas;
	}
	public void setPlacas(String placas) {
		this.placas = placas;
	}
	public String getCooperativa() {
		return cooperativa;
	}
	public void setCooperativa(String cooperativa) {
		this.cooperativa = cooperativa;
	}
	public Integer getNumeroPasajeros() {
		return numeroAsientos;
	}
	public void setNumeroPasajeros(Integer numeroPasajeros) {
		this.numeroAsientos = numeroPasajeros;
	}
	
	
}
