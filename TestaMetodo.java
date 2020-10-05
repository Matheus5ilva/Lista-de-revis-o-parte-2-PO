
public class TestaMetodo {
	public static void main(String[] args) {
		Lista2 teste = new Lista2();

		System.out.println("Grafo");
		teste.grafo("C:\\Users\\mathe\\eclipse-workspace\\PesquisaOperacional\\src\\grafo.txt");
		
		teste.node();

		teste.aresta();
	
		System.out.println("--------------");
		System.out.println();
		System.out.println("Matriz de Adjacencia");
		System.out.println();
		teste.matriz();
		
		System.out.println();
		System.out.println("-------------");
		System.out.println("Graus dos vertices");
		teste.grau();
		
		System.out.println("-------------");
		System.out.println("Questão 7");
		teste.questao7();
	}
}
