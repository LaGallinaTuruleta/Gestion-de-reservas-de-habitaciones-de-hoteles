package marzo18.Hotel.alojamiento;

import marzo18.Hotel.Cliente.Cliente;
import utiles_varios.Fecha;

public class ReservaHabitacion {
	private Hotel hotel;
	private Cliente cliente;

	public ReservaHabitacion() {
		this.hotel = new Hotel();
		this.cliente = new Cliente();
	}

	public ReservaHabitacion(Hotel hotel, Cliente cliente) {
		try {
			hotel.reservarHabitacion(cliente);
		} catch (Exception e) {
			System.out.println("Np hay habitación disponible en este hotel");
			System.out.println("El estado actual del hotel es :");
			hotel.viewHotel();
			// TODO: handle exception
		}
		this.hotel = hotel;
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Cliente getParticipante() {
		return cliente;
	}

	public void setParticipante(Cliente participante) {
		this.cliente = participante;
	}

	public String toString() {
		String toString = cliente.getNombre() + " tiene una reserva en " + hotel.getNombre();
		return toString;

	}
}
