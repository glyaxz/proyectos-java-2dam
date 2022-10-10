package creacionPersonas;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{
	public MyObjectOutputStream(OutputStream out) throws IOException {
		super(out);
	}
	public MyObjectOutputStream() throws IOException, SecurityException{
		super();
	}
	
	protected void WriteStreamHeader() throws IOException{
		
	}
}
