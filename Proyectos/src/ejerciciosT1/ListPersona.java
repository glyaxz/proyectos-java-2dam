package ejerciciosT1;
import java.util.ArrayList;
import java.util.List;


public class ListPersona{
	protected List<Persona> list = new ArrayList<Persona>();

	public ListPersona() {
		//
	}
	
	public void add (Persona p) {
		list.add(p);
	}
	
	public List<Persona> getListaPersona() {
		return list;
	}

}
