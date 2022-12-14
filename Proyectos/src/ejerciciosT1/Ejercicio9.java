package ejerciciosT1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.thoughtworks.xstream.*;


public class Ejercicio9 {

	public static void main(String[] args) {
		try{
			File f = new File("dbPersona.dat");
			ObjectInputStream dataIS4 = new ObjectInputStream(new FileInputStream(f));
			
			ListPersona lp = new ListPersona();
			
			try {
				while(true) {
					try {
						//Testing
						Persona persona = (Persona) dataIS4.readObject();
						lp.add(persona);
						System.out.println("---------------------------");
						lp.getListaPersona().forEach(per -> System.out.println(per.getApellidos()+per.getNombre()+per.getDni()+per.getEdad()));
						
						
						//Alumno persona = (Alumno) dataIS4.readObject();
						//lp.add(persona);
					}catch (EOFException eof) {
						break;
					}
				}
			}catch(EOFException e) {
				e.printStackTrace();
			}
			dataIS4.close();
			try {
				XStream xs = new XStream();
				xs.alias("ListaPersonasMunicipio", ListPersona.class);
				xs.alias("DatosPersona", Persona.class);
				
				xs.addImplicitCollection(ListPersona.class, "list");
				xs.toXML(lp, new FileOutputStream("FichPers.xml"));
				System.out.println("Fichero exportado.");
				
			}catch(Exception p){
				p.printStackTrace();
			}
			
			
		}catch (ClassNotFoundException|IOException e) {
			e.printStackTrace();
		}
	}
}
