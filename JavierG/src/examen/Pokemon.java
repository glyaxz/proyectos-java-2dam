package examen;

import java.io.Serializable;

public class Pokemon implements Serializable{
	String nombre, tipo, ataque;
	int vida, id;
	
	public Pokemon(int id, String nombre, String tipo, String ataque, int vida) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.ataque = ataque;
		this.vida = vida;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAtaque() {
		return ataque;
	}

	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}
	
	
}
