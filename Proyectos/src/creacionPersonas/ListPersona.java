package creacionPersonas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ListPersona implements Serializable {
	private List<Alumno> list = new ArrayList<Alumno>();

	public ListPersona() {
		//
	}
	
	public void add (Alumno p) {
		list.add(p);
	}
	
	public List<Alumno> getListaPersona() {
		return list;
	}
}
