package packpgpa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class main {

	public static void main(String[] args)  {
			
		PersistenciaJson json= new PersistenciaJson();
		Progressao pr = null ;
		Scanner leia=new Scanner(System.in);
		
		
		
		System.out.println("digite o A1 ");
		int a1=leia.nextInt();
		leia.nextLine();
		System.out.println("digite a Razao ");
		int razao=leia.nextInt();
		leia.nextLine();
		System.out.println("digite a quantidade");
		int qnt=leia.nextInt();
		leia.nextLine();
		
		
		System.out.println("Tipo de progressao");
		String tipo=leia.nextLine();
		
		
		System.out.println("Nome do arquivo");
		String nome=leia.nextLine();
		
		pr=new Progressao(qnt,a1,razao,TipoProgressao.PA,nome);
		
		System.out.println("Seu Json � uma "+ TipoProgressao.values()+"  :");
		
		json.gravacao(pr.geraProgressao(),nome);
	 
		int[] l=pr.le(nome);
		for (int i = 0; i < pr.getQnt(); i++) {
			System.out.println(l[i]);
		}
		System.out.println(pr.somatoria(nome));
		try {
			GeraHTML.gerarHtml(pr.le(nome));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("A media � : "+pr.media(nome)+"\r\n"+" E a mediana: "+pr.mediana());
		
		

	}

}
