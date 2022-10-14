package ejerciciosT1;
import java.io.*;


/* 
 * Ejercicio 3: 
 * Implementa en Java un programa en el que tendrás objetos Alumnos y objetos
 * Profesores. Como datos tendrán: nombre, apellidos, edad y DNI. Los profesores,
 * además tendrán un sueldo. Lee e imprime por pantalla los datos de todos tus objetos.
 * */

public class creacionPersonas {
	public static void main (String[] args) throws IOException {
		File f1 = new File("/home/glyaxz/Escritorio/Testing/dbPersona.dat");

		try {
			//Alumno
			FileOutputStream fileoutPersona = new FileOutputStream(f1, true);
			ObjectOutputStream dataOSpersona = new ObjectOutputStream(fileoutPersona);
			
			String[] a_nombres = {
				"juan",
				"francisco",
				"sergio",
				"javi"
			},	
			a_apellidos = {
				"barrera",
				"ruiz",
				"jurado",
				"garcia"
			},
			
			a_dnis = {
				"11111111A",
				"22222222B",
				"33333333C",
				"44444444D"
			};
				
			int[] a_edad = {
				18,
				19,
				20,
				22
			};
			
			for(int i = 0; i < a_nombres.length; i++) {
				Persona a_temp = new Persona(a_nombres[i], a_apellidos[i], a_dnis[i], a_edad[i]);
				dataOSpersona.writeObject(a_temp);
				System.out.println("Añadido alumno no. " + i);
			}
			dataOSpersona.close();

			
			
		
		//Leer datos
		Persona a1;
		
		try {
			//Alumno
			ObjectInputStream dataISpersona = new ObjectInputStream(new FileInputStream(f1));
			
			boolean boolWhile = true;
			int i = 1;
			while(boolWhile) {
				try{
					a1 = (Persona) dataISpersona.readObject();
					System.out.print(i + " -> ");
					i++;
					System.out.printf("Persona: Nombre y apellidos - %s %s, DNI - %s, Edad - %d %n", 
							a1.getNombre(), a1.getApellidos(), a1.getDni() ,(int)a1.getEdad());
				}catch(IOException f) {
					boolWhile = false;
				}
			}
			
			dataISpersona.close();
		
		}catch(FileNotFoundException e) {
			System.out.println("FNFE");
		}catch(ClassNotFoundException g) {
			System.out.println("CNFE");
		}catch(EOFException f) {/**/}
	
		}finally {
			//
		}
	}
}


