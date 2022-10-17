package examen;

import org.w3c.dom.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;

import javax.xml.parsers.*;
import javax.xml.stream.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import com.thoughtworks.xstream.XStream;

public class Ejercicio5 {

	public static void main(String[] args) {
		try {
			//Creación de variables
			File f = new File("./ficheros/mis_pokemon.dat");
			ListaPokemon lp = new ListaPokemon();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			boolean whileTrue = true;
			Pokemon p1;
			
			
			//Lectura de objetos
			while(whileTrue) {
				try {
					p1 = (Pokemon) ois.readObject();
					lp.add(p1);
					
					/*
					//Debugging
					//Checking List
					lp.getAllValues().forEach(p -> System.out.println(p.getNombre()));
					System.out.println("-------------------");
					*/
					
				}catch(EOFException g) {
					whileTrue = false;
				}
			}
			
			//Creación del fichero XML
			XStream xs = new XStream();
			xs.alias("ListaPokemon", ListaPokemon.class);
			xs.alias("Pokemon", Pokemon.class);
			xs.addImplicitCollection(ListaPokemon.class, "lista");
			xs.toXML(lp, new FileOutputStream("./ficheros/mis_pokemon.xml"));
			System.out.println("Fichero exportado");
			
			
			//Cerrar fichero
			ois.close();
			
		//Excepciones
		}catch(EOFException f) {
			//
		}catch(ClassNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
