package ejemplosT1;
import java.io.*;

public class Ejemplo5 {
	public static void main(String[] args) {
		File f1 = new File(args[0]);
		try {
			FileReader fr1 = new FileReader(f1);
			int i;
			
			try {
				while((i = fr1.read()) != -1) {
					System.out.println( (char) i + "==>"+ i);
				}
				fr1.close();
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage()); 
		}
	}
}
