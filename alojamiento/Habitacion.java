package marzo18.Hotel.alojamiento;

import marzo18.Hotel.Cliente.Cliente;

public class Habitacion {
	String planta;
	String sitio;
	Cliente cliente;
	Boolean ocupado;
	Boolean util;
	String tipoHabitacion;
	String refCliente;

	public Habitacion(String planta, String sitio, String refCliente) {
		this.planta = planta;
		this.sitio = sitio;
		this.refCliente = refCliente;
		if (this.getRefCliente() != "") {
			this.setOcupado(true);
		}
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public Habitacion() {
		this.planta = "";
		this.sitio = "";
		this.cliente = null;
		this.ocupado = false;
		this.tipoHabitacion = "";
		this.util = true;
		this.refCliente = "";
	}

	public Habitacion(String planta, String sitio) {
		this.planta = planta;
		this.sitio = sitio;
		this.ocupado = false;
		this.tipoHabitacion = "Normal";
		this.util = true;
	}

	public Habitacion(String sitio, Cliente cliente, Boolean ocupado, String tipoHabitacion, Boolean util) {
		this.sitio = sitio;
		this.cliente = cliente;
		this.ocupado = ocupado;
		this.tipoHabitacion = tipoHabitacion;
		this.util = util;
	}

	public String getSitio() {
		return sitio;
	}

	public void setSitio(String sitio) {
		this.sitio = sitio;
	}

	public Boolean getUtil() {
		return util;
	}

	public void setUtil(Boolean util) {
		this.util = util;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getRefCliente() {
		return refCliente;
	}

	public void setRefCliente(String refCliente) {
		this.refCliente = refCliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

}
