package marzo18.Hotel.control;

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
		ArrayList<ReservaHabitacion> reservas = new ArrayList<ReservaHabitacion>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Hotel h = null;

		hoteles.add(new Hotel("Palace", "Calle doritos 13", "palace@hotel.com", "679666866", "*****", 5, 20));
		
		hoteles.toString();
		
		
		hb.guardarHotelEnFichero("C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACI�N/3EVALUACION/Hotel/Hotel.txt",
				hoteles.get(0));
		hoteles.add(hb.insertarHotelFichero(
				"C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACI�N/3EVALUACION/Hotel/Hotel3xq.txt"));
		Cliente cl1 = new Cliente("Alex", "Blanes", "Saumell", "5372212314d");
		Cliente cl2 = new Cliente("Leo", "Vitacore", "Portast", "1235875643Y");
		Cliente cl3 = new Cliente("Muyayo", "Clavayo", "Villaragut", "666666666X");
		clientes.add(cl1);
		clientes.add(cl2);
		clientes.add(cl3);
		hb.guardarClientesEnFichero("C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACI�N/3EVALUACION/Hotel/Cliente1.txt", clientes);
		//hoteles.add(hb.insertarHotelFichero("C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACI�N/3EVALUACION/Hotel3.txt"));
		int i = 0;
		int menu = -1;
		while (menu != 0) {
			System.out.println("1.Introduzca hotel a mano");
			System.out.println("101.Introduzca hotel mediante fichero");
			System.out.println("102.Introduzca hoteles guardados en base de datos");
			System.out.println("103.Guardar un hotel en un fichero txt");
			System.out.println("104.Guardar hoteles en base de datos");
			System.out.println("11. Mostrar listado de hoteles");
			System.out.println("2.Introduzca reserva de habitacion a mano");
			System.out.println("0.Salir del programa");
			menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Introduzca nombre : ");
				String nombre = sc.next();
				System.out.println("Introduzca dirrecion : ");
				String dirreccion = sc.next();
				System.out.println("Introduzca telefono : ");
				String telefono = sc.next();
				System.out.println("Introduzca correo : ");
				String correo = sc.next();
				System.out.println("Introduzca las estrellas del hotel: ");
				String estrellas = sc.next();
				System.out.println("Introduzca n�mero de plantas: ");
				int numPlant = sc.nextInt();
				System.out.println("Introduzca n�mero de habitaci�n por planta: ");
				int numHabPlan = sc.nextInt();
				h = new Hotel(nombre, dirreccion, correo, telefono, estrellas, numPlant, numHabPlan);
				hoteles.add(h);
				break;
			case 101:
				System.out.println("Introduza la ruta donde se encuentra un hotel en un fichero: ");
				String ruta = sc.next();
				h = hb.insertarHotelFichero(ruta);
				hoteles.add(h);
				break;
			case 102:

				break;

			case 103:
				i = 0;
				System.out.println("�Qu� hotel desea guardar en un fichero txt?");

				for (Hotel hotel : hoteles) {
					System.out.println("Hotel : " + i + " " + hotel.getNombre());
					i++;
				}
				int numHotelAGuardar = sc.nextInt();
				hb.guardarHotelEnFichero("C:/Users/Blanes-PC/Documents/MEGA/1DAW/PROGRAMACI�N/3EVALUACION/Hotel/Hotel"
						+ hoteles.get(numHotelAGuardar).getNombre() + ".txt", hoteles.get(numHotelAGuardar));
				break;
			case 11:
				i = 0;
				for (Hotel hotel : hoteles) {
					System.out.println("Hotel : " + i + " " + hotel.getNombre());
					i++;
				}
				System.out.println("�Desea visualizar las habitaciones del hotel?(s)");
				String s = sc.next().toLowerCase();
				System.out.println(s);
				if (s.equals("s")) {
					for (Hotel hotel : hoteles) {
						hotel.viewHotel();
					}
				}
				break;

			default:
				System.out.println("Este no existe");
				break;
			}
		}

	}

}
