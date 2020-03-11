package script;

import java.util.ArrayList;

public interface Persistencia {
	public boolean gravar(ArrayList<Integer> lista, String nome);
	
	public ArrayList<Integer> ler(String nome);

}
