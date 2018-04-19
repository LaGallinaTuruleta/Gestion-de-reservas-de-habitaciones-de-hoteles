package marzo18.Hotel.alojamiento;

import marzo18.Hotel.Cliente.Cliente;
import utiles_varios.Fecha;

public class ReservaHabitacion {
	private String hotel;
	private String cliente;
	private int numPlanta;
	private String sitio;

	public ReservaHabitacion() {
	}

	public ReservaHabitacion(Hotel hotel, Cliente cliente) {
		try {
			this.hotel=hotel.getNombre();
			this.cliente=cliente.getDni();
			String[] infohabitacion=hotel.reservarHabitacion(cliente).split(",");
			this.numPlanta=Integer.parseInt(infohabitacion[0]);
			this.sitio=infohabitacion[1];
		} catch (Exception e) {
			System.out.println("Np hay habitación disponible en este hotel");
			System.out.println("El estado actual del hotel es :");
			hotel.viewHotel();
			// TODO: handle exception
		}
	}

	public int getNumPlanta() {
		return numPlanta;
	}

	public void setNumPlanta(int numPlanta) {
		this.numPlanta = numPlanta;
	}

	public String getSitio() {
		return sitio;
	}

	public void setSitio(String sitio) {
		this.sitio = sitio;
	}

	@Override
	public String toString() {
		return "ReservaHabitacion [hotel=" + hotel + ", cliente=" + cliente + ", numPlanta=" + numPlanta + ", sitio="
				+ sitio + "]";
	}
	public String toStringBBDD() {
		return hotel + "," + cliente + "," + numPlanta + ","+ sitio;
	}

	
	
}
