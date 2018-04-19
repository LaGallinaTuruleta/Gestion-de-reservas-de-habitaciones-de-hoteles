package marzo18.Hotel.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import marzo18.Hotel.Cliente.Cliente;
import marzo18.Hotel.alojamiento.Hotel;
import marzo18.Hotel.alojamiento.ReservaHabitacion;

public class ConexionConBBDD {

	public ConexionConBBDD() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();
		ArrayList<ReservaHabitacion> reservas = new ArrayList<ReservaHabitacion>();
		Connection c;
		String sDriver = "com.mysql.jdbc.Driver";
		String sURL = "jdbc:mysql://localhost:3306/hotel";

		try {
			Class.forName(sDriver).newInstance();
			c = DriverManager.getConnection(sURL, "root", "");

		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void exportarABBDD(ArrayList<Cliente> clientes,ArrayList<Hotel> hoteles,ArrayList<ReservaHabitacion> reservas) {

		Connection con = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/hotel", "root", "");
			stmt = (Statement) con.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery("select * from hoteles");
			while (rs.next()) {
				System.out.println(rs.getInt("id_cliente") + "" + rs.getInt("apellido") + "" + rs.getString("nombre")
						+ "" + rs.getString("dni" + ""));

				//this.nombre = rs.getString("nombre");
				//this.apellido1 = rs.getString("apellid1");
				//this.apellido2 = rs.getString("apellido2");
				//this.dni = rs.getString("dni");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Cliente> importarClientes() {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		return clientes;
	}

	public ArrayList<Hotel> importarHoteles() {
		ArrayList<Hotel> hoteles = new ArrayList<Hotel>();

		return hoteles;
	}

	public ArrayList<ReservaHabitacion> importarReservas() {
		ArrayList<ReservaHabitacion> reservas = new ArrayList<ReservaHabitacion>();
		
		return reservas;
	}
}
