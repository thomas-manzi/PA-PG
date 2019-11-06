package packpgpa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class PersistenciaJson {

	public boolean gravacao(int[] vet, String nome) {
		
		try {
			GsonBuilder builder = new GsonBuilder();

			Gson gson = builder.create();

			FileWriter writer = new FileWriter("src/packpgpa/"+nome+".json" , true);

			writer.write(gson.toJson(vet));

			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		return true;
	}
	
	public int[] ler(String nome)  {
		Gson gson = new Gson();
		
		String caminho="src/packpgpa/"+nome+".json";
        int[] p;
			BufferedReader br=null;
			try {
				br = new BufferedReader(new FileReader(caminho));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p = gson.fromJson(br, int[].class);
		return p;
	}
	
	
}
