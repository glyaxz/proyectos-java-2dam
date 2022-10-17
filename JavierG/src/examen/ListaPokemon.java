package examen;
import java.util.List;
import java.util.ArrayList;

public class ListaPokemon {
	List<Pokemon> lista = new ArrayList<Pokemon>();
	public ListaPokemon() {
		//
	}
	
	public void add(Pokemon pArray) {
		lista.add(pArray);
	}
	
	public List<Pokemon> getAllValues() {
		return lista;
	}
}
