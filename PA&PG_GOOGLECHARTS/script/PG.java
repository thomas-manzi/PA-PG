package script;

import java.util.ArrayList;

public class PG {
	private int razao;
	private int nTermos;
	private int primeiro;
	
	PG(int razao, int nTermos, int primeiro){
		this.razao=razao;
		this.nTermos=nTermos;
		this.primeiro=primeiro;
	}
	// getters and setters
	public int getRazao() {
		return razao;
	}

	public void setRazao(int razao) {
		this.razao = razao;
	}

	public int getnTermos() {
		return nTermos;
	}

	public void setnTermos(int nTermos) {
		this.nTermos = nTermos;
	}

	public int getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(int primeiro) {
		this.primeiro = primeiro;
	}
	// metodos
	ArrayList<Integer> listaPG = new ArrayList<Integer>();
	public ArrayList<Integer> resultadoPG(){
		if (primeiro==0) {
			return listaPG;
		}
		listaPG.add(primeiro);
		int soma=0;
		for (int i = 0; i < nTermos; i++) {
			if (i==1) {
				soma = primeiro*razao;
				listaPG.add(soma);
			}else if (i>1) {
				soma = soma * razao;
				listaPG.add(soma);
			}
		}
		return listaPG;
	}
	public void grava(String nome){
		PersistenciaJson json=new PersistenciaJson();
		json.gravar(resultadoPG(), nome);

	}
	
	public ArrayList<Integer> le(String nome){
		PersistenciaJson json=new PersistenciaJson();
		ArrayList<Integer> c =json.ler(nome);
		
		return c;

	}
}
