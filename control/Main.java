package marzo18.Hotel.control;

import java.util.ArrayList;
import java.util.Scanner;

import marzo18.Hotel.Cliente.Cliente;
import marzo18.Hotel.alojamiento.Hotel;
import marzo18.Hotel.alojamiento.ReservaHabitacion;

public class Main {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HotelBuffer hb = new HotelBuffer();
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<ReservaHabitacion> reservas = new ArrayList<ReservaHabitacion>();
		Hotel h = null;
		//C:\Users\Blanes-PC\Documents\MEGA\1DAW\PROGRAMACIÓN\3EVALUACION\Hotel\Palmeras2.txt
		hoteles.add(new Hotel("Palace", "Calle doritos 13", "palace@hotel.com", "679666866", "*****", 5, 20));
		clientes.add(new Cliente("Alex", "Blanes", "Saumell", "537323e4234234"));
		clientes.add(new Cliente("Perico", "Blanes", "Saumell", "537323e4234234"));
		reservas.add(new ReservaHabitacion(hoteles.get(0), clientes.get(0)));
		reservas.add(new ReservaHabitacion(hoteles.get(0), clientes.get(1)));
		int i = 0;
		int menu = 999;
		while (menu != 0) {
			switch (menu) {
			case 1://Mostrar hoteles
				i = 0;
				for (Hotel hotel : hoteles) {
					System.out.println("Hotel : " + i + " " + hotel.getNombre());
					i++;
				}
				System.out.println("¿Desea visualizar las habitaciones del hotel?(s)");
				String s = sc.next().toLowerCase();
				System.out.println(s);
				if (s.equals("s")) {
					for (Hotel hotel : hoteles) {
						hotel.viewHotel();
					}
				}
				break;
			case 2://Mostrar clientes
				for (Cliente cliente : clientes) {
					System.out.println(cliente.toString());
				}
				break;
			case 3://Realizar reserva
				i = 0;
				System.out.println("Introduzca datos nuevo cliente:\nNombre:");
				String nombre = sc.next();
				System.out.println("Apellido:");
				String ape = sc.next();
				System.out.println("DNI:");
				String dni = sc.next();
				clientes.add(new Cliente(nombre, ape, dni));
				System.out.println("¿En qué hotel desea hospedarse?");
				for (Hotel hotel : hoteles) {
					System.out.println("Hotel : " + i + " " + hotel.getNombre());
					i++;
				}
				System.out.println("Escribe el número del hotel a guardar");
				int numHotelAReservar = sc.nextInt();
				reservas.add(new ReservaHabitacion(hoteles.get(numHotelAReservar), clientes.get(clientes.size() - 1)));
				break;
			case 4:
				for (ReservaHabitacion reservaHabitacion : reservas) {
					System.out.println(reservaHabitacion.toString());
				}
				break;
			case 101://Insertar hotel mediante teclado
				System.out.println("Hotel\nIntroduzca nombre : ");
				String nombreh = sc.nextLine();
				System.out.println("Introduzca direccion : ");
				String direccion = sc.nextLine();
				System.out.println("Introduzca telefono : ");
				String telefono = sc.next();
				System.out.println("Introduzca correo : ");
				String correo = sc.next();
				System.out.println("Introduzca las estrellas del hotel: ");
				String estrellas = sc.next();
				System.out.println("Introduzca número de plantas: ");
				int numPlant = sc.nextInt();
				System.out.println("Introduzca número de habitación por planta: ");
				int numHabPlan = sc.nextInt();
				h = new Hotel(nombreh, direccion, correo, telefono, estrellas, numPlant, numHabPlan);
				hoteles.add(h);
				break;
			case 102://Insertar hotel mediante fichero de texto
				System.out.println("Introduza la ruta donde se encuentra un hotel en un fichero: ");
				String ruta = sc.next();
				h = hb.insertarHotelFichero(ruta);
				hoteles.add(h);
				break;
			case 103://Insertar hotel mediante BBDD

				break;
			case 104://Guardar hotel en fichero de texto
				i = 0;
				System.out.println("¿Qué hotel desea guardar en un fichero txt?");
				for (Hotel hotel : hoteles) {
					System.out.println("Hotel : " + i + " " + hotel.getNombre());
					i++;
				}
				System.out.println("Escribe el número del hotel a guardar");
				int numHotelAGuardar = sc.nextInt();
				System.out.println("Introduzca la ruta donde guardar el fichero con el hotel");
				String rutaGuardarHotelFichero = sc.next();
				hb.guardarHotelEnFichero(rutaGuardarHotelFichero, hoteles.get(numHotelAGuardar));

				break;
			case 105://Guardar hoteles en BBDD

				break;
			case 201://Insertar cliente mediante teclado

				break;
			case 202://Insertar cliente mediante fichero de texto
				System.out.println("Introduzca ruta de fichero con clientes:");
				String rutaInsertarCliFi = sc.next();
				clientes.addAll(hb.insertarClientesDeFichero(rutaInsertarCliFi));
				break;
			case 203://Insertar cliente mediante BBDD

				break;
			case 204://Guardar clientes en fichero de texto
				System.out.println("Introduzca ruta de donde desee guardar los clientes:");
				String rutaGuardarCliFi = sc.next();
				hb.guardarClientesEnFichero(rutaGuardarCliFi, clientes);
				break;
			case 205://Guardar clientes en BBDD

				break;
			case 0:
				System.out.println("Xaito");
				break;
			case 999:
				System.out.println("1. Mostrar hoteles");
				System.out.println("2. Mostrar clientes");
				System.out.println("3. Realizar reserva");
				System.out.println("4. Mostrar reservas");
				System.out.println("101. Introduzca hotel mediante teclado");
				System.out.println("102. Introduzca hotel mediante fichero de texto");
				System.out.println("103. Introduzca hoteles almacenados en BBDD");
				System.out.println("104. Guardar hoteles en un fichero de texto");
				System.out.println("105. Guardar hoteles en BBDD");
				System.out.println("201. Introduzca cliente mediante teclado");
				System.out.println("202. Introduzca clientes mediante fichero de texto");
				System.out.println("203. Introduzca clientes almacenados en BBDD");
				System.out.println("204. Guardar clientes en un fichero de texto");
				System.out.println("205. Guardar clientes en BBDD");
				System.out.println("0. Salir del programa");
				break;
			default:
				System.out.println("Este no existe");
				break;
			}

			try {
				menu = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
				menu = 999;
				//	e.printStackTrace();
				//	System.out.println("Error en la entrada del menú, escriba unicamente números");
			}

		}

	}

}
