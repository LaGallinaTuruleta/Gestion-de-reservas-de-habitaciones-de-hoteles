package marzo18.Hotel.control;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import marzo18.Hotel.Cliente.Cliente;
import marzo18.Hotel.alojamiento.Hotel;
import marzo18.Hotel.alojamiento.ReservaHabitacion;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HotelBuffer hb = new HotelBuffer();

		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		hoteles.add(new Hotel("Palace", "Calle doritos 13", "palace@hotel.com", "679666866", "*****", 5, 20));
		Cliente cl1 = new Cliente();
		Cliente cl2 = new Cliente();
		new ReservaHabitacion(hoteles.get(0), cl1);
		hoteles.get(0).viewHotel();
		new ReservaHabitacion(hoteles.get(0), cl2);
		hoteles.get(0).viewHotel();
		hb.guardarHotelFichero("C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACIÓN/3EVALUACION/Hotel/Hotel.txt",
				hoteles.get(0));
		hoteles.add(hb.insertarHotelFichero(
				"C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACIÓN/3EVALUACION/Hotel/Hotel2.txt"));
		//hoteles.add(hb.insertarHotelFichero("C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACIÓN/3EVALUACION/Hotel3.txt"));

		try {
			hoteles.get(0).viewHotel();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Esto peta en la visioón del hotel 1");
		}
		try {
			hoteles.get(1).viewHotel();
		} catch (Exception e) {
			System.out.println("Esto peta en la visioón del hotel 2");
			// TODO: handle exception
		}

		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());
		new ReservaHabitacion(hoteles.get(1), new Cliente());

		hoteles.get(1).viewHotel();

		/*
		 * int menu = 0; while (menu == 0) {
		 * System.out.println("1.Introduzca hotel a mano");
		 * System.out.println("101.Introduzca hotel mediante fichero");
		 * System.out.
		 * println("102.Introduzca hoteles guardados en base de datos");
		 * System.out.println("2.Introduzca reserva de habitacion a mano"); menu
		 * = sc.nextInt(); switch (menu) { case 1: String nombre =
		 * sc.nextLine(); String dirreccion = sc.nextLine(); String telefono =
		 * sc.nextLine(); String correo = sc.nextLine(); String estrellas =
		 * sc.nextLine(); int numPlant = sc.nextInt(); int numHabPlan =
		 * sc.nextInt(); hoteles.add(new
		 * Hotel(nombre,dirreccion,correo,telefono,estrellas,numPlant,numHabPlan
		 * )); guardarHotelFichero(null, null); break; case 2:
		 * 
		 * default: break; } }
		 */

	}

}
