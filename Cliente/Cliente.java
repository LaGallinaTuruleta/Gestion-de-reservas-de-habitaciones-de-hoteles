package marzo18.Hotel.Cliente;

public class Cliente {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;

	public Cliente() {
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.dni = "";
	}

	public Cliente(String nombre, String apellido1, String apellido2, String dni) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {

	}

}
