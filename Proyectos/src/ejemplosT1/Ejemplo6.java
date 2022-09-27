package ejemplosT1;
import java.io.*;

public class Ejemplo6 {
	public static void main(String[] args) {
		File f1 = new File(args [0]);
		try {
			FileWriter fw1 = new FileWriter(f1);
			String strTxt = "Esto es una cadena para el TextWriter";
			char[] charTxt = strTxt.toCharArray();
			
			for(int i = 0; i < charTxt.length; i++) {
				fw1.write(charTxt[i]);
			}
			fw1.append('*');
			fw1.write(charTxt);
			String strTxt2 = "\nEsto es lo ultimo";
			fw1.write(strTxt2);
			String txtSeparator = "\n----------------------------------------------";
			fw1.write(txtSeparator);
			
			String[] straTxt = {"hola","que","tal"};
			for(int i = 0; i < straTxt.length; i++) {
				fw1.write(straTxt[i]+"\n");
			}
			fw1.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
