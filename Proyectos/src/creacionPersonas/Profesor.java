package creacionPersonas;
import java.io.Serializable;

public class Profesor implements Serializable{
	private String nombre, apellidos, dni;
	private int edad;
	private float sueldo;
	
	public Profesor(String n, String a, String d, int e, float s) {
		nombre = n;
		apellidos = a;
		dni = d;
		edad = e;
		sueldo = s;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
}