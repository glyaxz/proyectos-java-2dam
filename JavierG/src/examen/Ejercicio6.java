package examen;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Ejercicio6 {
	public static void main(String[] args) {
		try {
			//Creación de variables
			File f = new File("./ficheros/mis_pokemon.dat");
			File f2 = new File("./ficheros/mis_pokemon_aleatorio.dat");
			RandomAccessFile raf = new RandomAccessFile(f2, "rw");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			boolean whileTrue = true;
			Pokemon p1;
			int[] id = new int[7], vida = new int[7];
			String[] nombre = new String[7], tipo = new String[7], ataque = new String[7];
			
			//Lectura de objetos desde fichero
			while(whileTrue) {
				try {
					for(int i = 0 ;;i++) {
						try {
							p1 = (Pokemon) ois.readObject();
							id[i] = p1.getId();
							nombre[i] = p1.getNombre();
							tipo[i] = p1.getTipo();
							ataque[i] = p1.getAtaque();
							vida[i] = p1.getVida();
						}catch(EOFException h) {
							break;
						}
					}
					//Escritura en fichero aleatorio
						//El fichero seguirá los siguientes valores:
						//id->nombre->tipo->ataque->vida
						//4 + 20 + 20 + 40 + 4 => 88
					StringBuffer buffer = null;
					for(int i = 0; i < id.length; i++) {
						long position = (id[i] - 1) * 88;
						raf.seek(position);
						raf.writeInt(id[i]);
						buffer = new StringBuffer(nombre[i]);
						buffer.setLength(10);
						raf.writeChars(buffer.toString());
						buffer = new StringBuffer(tipo[i]);
						buffer.setLength(10);
						raf.writeChars(buffer.toString());
						buffer = new StringBuffer(ataque[i]);
						buffer.setLength(20);
						raf.writeChars(buffer.toString());
						raf.writeInt(vida[i]);
					}
					//Cerrar fichero
					raf.close();
					System.out.println("Fichero exportado");
					
				//Excepciones
				}catch(EOFException g) {
					whileTrue = false;
				}
			}
		}catch(ClassNotFoundException|IOException e) {
			//
		}
	}
}
