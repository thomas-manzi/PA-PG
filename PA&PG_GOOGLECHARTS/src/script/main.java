package script;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PG pg = new PG(2,10,1);
		PA pa= new PA(3,10,1);
		System.out.println(pa.resultadoPA()+"\n");
		System.out.println(pg.resultadoPG());
		PersistenciaJson json= new PersistenciaJson();
		json.gravar(pa.resultadoPA(), "pa");
		json.ler("pa");
		

	}

}
