
public class AtividadeExtra {
	public static void main(String[] args) {
		System.out.println("\t***** Questões Extras de Pesquisa Operacional *****");

		int[][] matriz = { { 4, 1, 2, 3 }, { 5, 2, 1, 400 }, { 2, 1, 3, 8 }, { 7, 1, 2, 5 } };

		int[] itinerario = new int [17];

		int somatorio = 0;

		for (int contador = 0; contador < 17; contador++) {
			double interacao = (Math.round(Math.random() * 3));

			itinerario[contador] = (int) interacao;

		}
		System.out.println();

		System.out.print("Os valores do intinerário são: ");
		for (int j = 0; j < 17; j++) {
			System.out.print(itinerario[j] + " ");
		}
		System.out.println(" ");
		System.out.print("O custo do itinerário gerado são:  ");

		for (int linha = 0; linha < 16; linha++) {
			somatorio += matriz[itinerario[linha]][itinerario[linha + 1]];
		}
		
		for (int linha = 0; linha < 16; linha++) {
			if(linha == 15) {
				System.out.print(matriz[itinerario[linha]][itinerario[linha + 1]]);
				break;
			}
			System.out.print(matriz[itinerario[linha]][itinerario[linha + 1]] + " + ");
		}

		System.out.print(" = " + somatorio);

	}
}
