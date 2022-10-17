package examen;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio4 {
	public static void main(String[] args) {
		//Creación de variables	
		Pokemon p1;
		try {
			File f = new File("./ficheros/mis_pokemon.dat");
			File f2 = new File("./ficheros/mis_pokemon.txt");
			String tempOutputString;
			BufferedWriter bw = new BufferedWriter(new FileWriter(f2));
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			boolean whileTrue = true;
			
			
			//Lectura de fichero y escritura en fichero de texto plano 
			while(whileTrue) {
				try {
					p1 = (Pokemon) ois.readObject();
					tempOutputString = ("Mi pokemon numero " + p1.getId()
										+ " es " + p1.getNombre() 
										+ " y es de tipo " + p1.getTipo()
										+ ". Su ataque principal es " + p1.getAtaque()
										+ " y tiene " + p1.getVida() + " de vida");
					bw.write(tempOutputString);
					System.out.println(tempOutputString);
				}catch(EOFException e) {
					break;
				}
			}
			
			//Cerrar fichero
			bw.close();
			ois.close();
			
		//Excepciones
		}catch(ClassNotFoundException|IOException e) {
			//
		}
	}
}
