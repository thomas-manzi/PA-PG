package script;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersistenciaJson implements Persistencia {

	public boolean gravar(ArrayList<Integer> lista, String nome) {
		try {
			GsonBuilder builder = new GsonBuilder();

			Gson gson = builder.create();

			FileWriter writer = new FileWriter("C:/workspace/PA&PG_GOOGLECHARTS/src/script/"+nome+".json" , true);

			writer.write(gson.toJson(lista));

			writer.close();
		} 
		catch (IOException ex) {
			ex.printStackTrace();
		} 
		return true;
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> ler(String nome) {
		Gson gson = new Gson();
		PA pr = new PA(3, 10, 1);
		
		String caminho="C:/workspace/PA&PG_GOOGLECHARTS/src/script/"+nome+".json";
        ArrayList<Integer> p = new ArrayList<Integer>();
			BufferedReader br=null;
			try {
				br = new BufferedReader(new FileReader(caminho));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p = gson.fromJson(br, ArrayList.class);
			
			//List<PA> fromJson= gson.fromJson(br, (Type) pr.resultadoPA());
		return p;
		}

	}

