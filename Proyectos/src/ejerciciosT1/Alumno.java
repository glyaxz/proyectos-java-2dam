package ejerciciosT1;

import java.io.Serializable;

public class Alumno implements Serializable{
	private String nombre, apellidos, dni;
	private int edad;
	
	public Alumno(String n, String a, String d, int e) {
		nombre = n;
		apellidos = a;
		dni = d;
		edad = e;
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
	
	
}
