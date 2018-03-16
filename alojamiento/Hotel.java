package marzo18.Hotel.alojamiento;

import marzo18.Hotel.Cliente.Cliente;

public class Hotel {
	private String nombre;
	private int numPlantas;
	private int numHabPlanta;
	private String dirrecion;
	private String telefono;
	private String correo;
	private String estrellas;
	private Habitacion[][] habitaciones;

	public Hotel() {
		this.nombre = "";
		this.numPlantas = 0;
		this.numHabPlanta = 0;
		this.dirrecion = "";
		this.telefono = "";
		this.correo = "";
		this.estrellas = "";
		this.habitaciones = new Habitacion[0][0];
	}

	public Hotel(String nombre, String dirrecion, String correo, String telefono, String estrellas, int numPlantas,
			int numHabPlanta) {
		this.nombre = nombre;
		this.numPlantas = numPlantas;
		this.numHabPlanta = numHabPlanta;
		this.dirrecion = dirrecion;
		this.correo = correo;
		this.telefono = telefono;
		this.estrellas = estrellas;
		this.habitaciones = new Habitacion[this.numPlantas][this.numHabPlanta];
		for (int i = 0; i < numPlantas; i++) {
			for (int j = 0; j < numHabPlanta; j++) {
				habitaciones[i][j] = new Habitacion();
			}
			System.out.println();
		}
	}

	public void reservarHabitacion(Cliente cliente) throws ExcNoHabitacion {
		boolean habitacionEncontrada = false;
		int i = 0;
		while (habitacionEncontrada == false && i != getNumPlantas()) {
			boolean plantaRecorridaEntera = false;
			
			int j = 0;
			
			while (( j != getNumHabPlanta() &&habitacionEncontrada == false)) {
				if (habitaciones[i][j].ocupado == false) {
					habitaciones[i][j].setCliente(cliente);
					habitaciones[i][j].setOcupado(true);
					habitacionEncontrada = true;
				}
				j++;
				
			}
			i++;
			
		}
		if (habitacionEncontrada == false) {
			
			throw new ExcNoHabitacion();
		}
	}

	public void viewHotel() {
		System.out.println("Hotel : " + getNombre());
		for (int i = 0; i < numPlantas; i++) {
			System.out.print("Planta: " + i);
			for (int j = 0; j < numHabPlanta; j++) {
				if (habitaciones[i][j].getOcupado() == true) {
					System.out.print("[C]");
				} else {
					System.out.print("[L]");
				}
			}
			System.out.println();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumPlantas() {
		return numPlantas;
	}

	public void setNumPlantas(int numPlantas) {
		this.numPlantas = numPlantas;
	}

	public int getNumHabPlanta() {
		return numHabPlanta;
	}

	public void setNumHabPlanta(int numHabPlanta) {
		this.numHabPlanta = numHabPlanta;
	}

	public String getDirrecion() {
		return dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Habitacion[][] getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Habitacion[][] habitaciones) {
		this.habitaciones = habitaciones;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(String estrellas) {
		this.estrellas = estrellas;
	}

	public static class ExcNoHabitacion extends Exception {
		//constructor 
		public ExcNoHabitacion() {
			System.out.println("No hay más habitaciones disponibles");
		}
	}

}