package marzo18.Hotel.control;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import marzo18.Hotel.Cliente.Cliente;
import marzo18.Hotel.alojamiento.Hotel;

public class HotelBuffer {

	private Path file;
	Charset charset;

	public HotelBuffer() {

		Path file;
		Charset charset;

	}

	public Hotel insertarHotelFichero(String ruta) {
		Path salida = Paths.get(ruta);
		charset = Charset.forName("UTF-8");
		List<String> texto = null;
		Hotel h;
		try {
			texto = Files.readAllLines(salida);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Esto peta ammigo");
		}
		h = new Hotel(texto.get(0), texto.get(1), texto.get(2), texto.get(3), texto.get(4),
				Integer.parseInt(texto.get(5)), Integer.parseInt(texto.get(6)));
		String[] s = new String[7];
		s[0] = texto.get(0);
		s[1] = texto.get(1);
		s[2] = texto.get(2);
		s[3] = texto.get(3);
		s[4] = texto.get(4);
		s[5] = texto.get(5);
		s[6] = texto.get(6);
		System.out.println(texto.toString());
		return h;
	}

	public void guardarHotelEnFichero(String ruta, Hotel hotel) {
		file = Paths.get(ruta);
		charset = Charset.forName("UTF-8");
		String[] s = new String[7];
		s[0] = hotel.getNombre();
		s[1] = hotel.getDirrecion();
		s[2] = hotel.getTelefono();
		s[3] = hotel.getCorreo();
		s[4] = hotel.getEstrellas();
		s[5] = "" + hotel.getNumPlantas();
		s[6] = "" + hotel.getNumHabPlanta();
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
			for (int i = 0; i < s.length; i++) {
				writer.write(s[i], 0, s[i].length());
				if (i < s.length - 1)
					writer.newLine();
			}
			writer.close();
		} catch (IOException io) {
			System.err.format("IOExceptio: %s%n", io);
		}

	}

	public void guardarClientesEnFichero(String ruta, ArrayList<Cliente> clientes) {
		file = Paths.get(ruta);
		charset = Charset.forName("UTF-8");
		String[] s = new String[4];
		String[] cls = new String[clientes.size()];
		int y = 0;

		try {
			BufferedWriter writer = Files.newBufferedWriter(file, charset);
			for (Cliente cliente : clientes) {
				s[0] = cliente.getDni();
				s[1] = cliente.getNombre();
				s[2] = cliente.getApellido1();
				s[3] = cliente.getApellido2();
				String linea = s[0] + "|" + s[1] + "|" + s[2] + "|" + s[3];
				cls[y] = linea;
				writer.write(cls[y], 0, cls[y].length());
				writer.newLine();

			}
			writer.close();
		} catch (IOException io) {
			System.err.format("IOExceptio: %s%n", io);
		}

	}

	public ArrayList<Cliente> insertarClientesDeFichero(String ruta) {

		return null;
	}
}
