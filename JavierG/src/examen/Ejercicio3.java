package examen;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio3 {
	public static void main(String[] args) {
		//Creación de variables
		Pokemon p1;
		try {
			File f = new File("./ficheros/mis_pokemon.dat");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			boolean whileTrue = true;
			
			//Lectura e impresión del fichero
			while(whileTrue) {
				p1 = (Pokemon) ois.readObject();
				System.out.println("Mi pokemon numero "+ p1.getId()
									+ " es " + p1.getNombre() 
									+ " y es de tipo " + p1.getTipo()
									+ ". Su ataque principal es " + p1.getAtaque()
									+ " y tiene " + p1.getVida() + " de vida");
			}
			
			
			//Cerrar fichero
			ois.close();
			
		//Excepciones
		}catch(ClassNotFoundException|IOException e) {
			//
		}

	}
}
