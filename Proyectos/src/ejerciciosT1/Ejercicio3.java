package ejerciciosT1;
import java.io.*;


/* 
 * Ejercicio 3: 
 * Implementa en Java un programa en el que tendrás objetos Alumnos y objetos
 * Profesores. Como datos tendrán: nombre, apellidos, edad y DNI. Los profesores,
 * además tendrán un sueldo. Lee e imprime por pantalla los datos de todos tus objetos.
 * */

public class Ejercicio3 {
	public static void main (String[] args) throws IOException {
		File f1 = new File("/home/glyaxz/Escritorio/Testing/dbAlumno.dat");
		File f2 = new File("/home/glyaxz/Escritorio/Testing/dbProfesor.dat");
		
		//Escribir datos
		try {
			//Alumno
			FileOutputStream fileoutAlumno = new FileOutputStream(f1, true);
			ObjectOutputStream dataOSalumno = new ObjectOutputStream(fileoutAlumno);
			
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
				Alumno a_temp = new Alumno(a_nombres[i], a_apellidos[i], a_dnis[i], a_edad[i]);
				dataOSalumno.writeObject(a_temp);
				System.out.println("Añadido alumno no. " + i);
			}
			dataOSalumno.close();

			
			
			//Profesor
			FileOutputStream fileoutProfesor = new FileOutputStream(f2, true);
			ObjectOutputStream dataOSprofesor = new ObjectOutputStream(fileoutProfesor);
			
			String[] p_nombres = {
					"juan",
					"francisco",
					"sergio",
					"javi"
				},	
				p_apellidos = {
					"barrera",
					"ruiz",
					"jurado",
					"garcia"
				},
				
				p_dnis = {
					"11111111A",
					"22222222B",
					"33333333C",
					"44444444D"
				};
					
				int[] p_edad = {
					18,
					19,
					20,
					22
				},
				p_sueldo = {
					1000,
					1200,
					1400,
					1600
				};
				
				for(int i = 0; i < a_nombres.length; i++) {
					Profesor p_temp = new Profesor(p_nombres[i], p_apellidos[i], p_dnis[i], p_edad[i], p_sueldo[i]);
					dataOSprofesor.writeObject(p_temp);
					System.out.println("Añadido profesor no. " + i);
				}
				dataOSprofesor.close();


			
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		

		
		//Leer datos
		Alumno a1;
		Profesor p1;
		
		try {
			//Alumno
			ObjectInputStream dataISalumno = new ObjectInputStream(new FileInputStream(f1));
			
			boolean boolWhile = true;
			int i = 1;
			while(boolWhile) {
				try{
					a1 = (Alumno) dataISalumno.readObject();
					System.out.print(i + " -> ");
					i++;
					System.out.printf("Alumno: Nombre y apellidos - %s %s, DNI - %s, Edad - %d %n", 
							a1.getNombre(), a1.getApellidos(), a1.getDni() ,(int)a1.getEdad());
				}catch(IOException f) {
					boolWhile = false;
				}
			}
			
			dataISalumno.close();
			
			
			//Profesor
			ObjectInputStream dataISprofesor = new ObjectInputStream(new FileInputStream(f2));
			boolean boolProf = true;
			int j = 1;
			while (boolProf){
				p1 = (Profesor) dataISprofesor.readObject();
				System.out.print(j + " -> ");
				j++;
				System.out.printf("Profesor: Nombre y apellidos - %s %s, DNI - %s, Edad - %d, Sueldo - %d %n", 
						p1.getNombre(), p1.getApellidos(), p1.getDni(), (int)p1.getEdad(), (int)p1.getSueldo());
			}
			dataISprofesor.close();
		}catch(FileNotFoundException e) {
			System.out.println("FNFE");
		}catch(ClassNotFoundException g) {
			System.out.println("CNFE");
		}catch(EOFException f) {	}
	}
}
