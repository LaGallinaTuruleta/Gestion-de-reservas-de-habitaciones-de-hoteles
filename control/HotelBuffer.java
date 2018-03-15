package marzo18.Hotel.control;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import marzo18.Hotel.alojamiento.Hotel;

public class HotelBuffer {

	private Path file;
	Charset charset;

	public HotelBuffer() {

		Path file;
		Charset charset;

	}

	public Hotel insertarHotelFichero(String ruta) {

		return new Hotel();
	}

	public void guardarHotelFichero(String ruta, Hotel hotel) {
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
}
