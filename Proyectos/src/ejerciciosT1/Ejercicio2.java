package ejerciciosT1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) {
		try {		
			BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
			BufferedReader br2 = new BufferedReader(new FileReader(args[1]));
			BufferedWriter bw = new BufferedWriter(new FileWriter(args[2]));
			
			String line;
			while((line = br1.readLine()) != null) {
				bw.write(line + "\n");
			}
			br1.close();
			
			while((line = br2.readLine()) != null) {
				bw.write(line + "\n");
			}
			br2.close();
			bw.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException f) {
			f.printStackTrace();
		}
	}

}
