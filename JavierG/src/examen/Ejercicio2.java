package examen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejercicio2 {
	public static void main(String[] args) {
		File f = new File("./ficheros/mis_pokemon.dat");
		try {
			//Creación de valores
			FileOutputStream dataos = new FileOutputStream(f, true);
			ObjectOutputStream oos = new ObjectOutputStream(dataos);
			
			
			//Creación de pokemons
			Pokemon[] pokemonList = {
					new Pokemon(1,"Pikachu", "electrico", "Bola voltio", 60),
					new Pokemon(2,"Alomomola", "agua", "Hidroestallido", 110),
					new Pokemon(3,"Grookey", "planta", "Arañazo", 70),
					new Pokemon(4,"Incineroar", "fuego", "Lanzallamas", 160),
					new Pokemon(5,"Silicobra", "tierra", "Ataque arena", 80),
					new Pokemon(6,"Tapu Lele", "psiquico", "Impulso de energia", 170),
					new Pokemon(7,"Melmetal", "acero", "Impulso pesado", 150)
			};
			
			//Escritura de fichero
			for(int i = 0; i < pokemonList.length; i++) {
				oos.writeObject(pokemonList[i]);
				System.out.println("Pokemon añadido");
			}
			
			//Cerramos fichero
			oos.close();
			
		//Excepciones
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}








