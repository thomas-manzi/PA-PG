package packpgpa;

import java.io.IOException;

public class Progressao {
	private int a1;
	private int razao;
	private int qnt;
	private String nome;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	private TipoProgressao tipo;
	
	public int getA1() {
		return a1;
	}
	public void setA1(int a1) {
		this.a1 = a1;
	}
	public int getRazao() {
		return razao;
	}
	public void setRazao(int razao) {
		this.razao = razao;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	
	public TipoProgressao getTipo() {
		return tipo;
	}
	public void setTipo(TipoProgressao tipo) {
		this.tipo = tipo;
	}
	
	public Progressao(int qnt,int a1, int razao, TipoProgressao tipo, String nome ) {
		this.a1=a1;
		this.qnt=qnt;
		this.razao=razao;
		this.tipo=tipo;
		this.nome=nome;
	}
	
	public int[] geraProgressao() {
		int[] pg =new int[qnt];
		int[] pa=new int[qnt];
		if (tipo==TipoProgressao.PA) {
			pa[0]=a1;
			for (int i = 1; i < qnt; i++) {
				pa[i]=pa[i-1]+razao;
			}
			return pa;
		}else {
			pg[0]=a1;
			for (int i = 1; i < qnt; i++) {
				pg[i]=pg[i-1]*razao;
				
			}
			return pg;
		}
	}
	
	public void gravar(String nome) {
		PersistenciaJson json=new PersistenciaJson();
		json.gravacao(geraProgressao(), nome);
	}
	
	public int[] le(String nome)  {
		PersistenciaJson json=new PersistenciaJson();
		int c[] =json.ler(nome);
		qnt=c.length;
		return c;
	}
	
	public String tipop() {
		if (tipo==TipoProgressao.PA) {
			return "PA";
		}else {
			return "PG";
		}
	}
	
	public int qntNum() {
		return qnt;
	}
	
	public int qntA1() {
		return a1;
	}
	
	public int somatoria(String nome) {
		PersistenciaJson json=new PersistenciaJson();
		int c[] =json.ler(nome), soma=0;
		
		
		for (int i = 0; i < c.length; i++) {
			soma+=c[i];
		}
		return soma;
	}
	
	public int media(String nome) {
		PersistenciaJson json=new PersistenciaJson();
		int soma=0,media=0;
		int c[]= json.ler(nome);
		for (int i = 0; i < c.length; i++) {
			soma=c[i]+soma;
		}
		media=soma/c.length;
		return media;
	}
	
	public int mediana() {
		PersistenciaJson json=new PersistenciaJson();
		int c[]= json.ler(nome);
		int mediana=0;
		if (c.length%2==0) {
			return (c[c.length/2 ] + c[(c.length/2)+1])/2;
		}else {
			return c[c.length/2];
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Progressao [a1=");
		builder.append(a1);
		builder.append(", razao=");
		builder.append(razao);
		builder.append(", qnt=");
		builder.append(qnt);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
