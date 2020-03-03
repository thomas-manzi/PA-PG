package script;

import java.util.ArrayList;

public class PA {
	private int razao;
	private int nTermos;
	private int primeiro;
	
	
	//construtor
	PA(int razao, int nTermos, int primeiro){ 	
		this.razao=razao;
		this.nTermos= nTermos;
		this.primeiro=primeiro;
	}
	
// getters and setters
	public int getRazao() {
		return razao;
	}

	public int getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(int primeiro) {
		this.primeiro = primeiro;
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
	
	// metodos
	ArrayList<Integer> lista = new ArrayList<Integer>();
	public ArrayList<Integer> resultadoPA(){		
		int soma=0;
		lista.add(primeiro);
		for (int i = 0; i < nTermos; i++) {
			if (i==1) {
				soma=primeiro + razao;
				lista.add(soma);
			}
			if(i>1){
				soma+=razao;
				lista.add(soma);
			}
			
		}
		return lista;
		
	}
}
