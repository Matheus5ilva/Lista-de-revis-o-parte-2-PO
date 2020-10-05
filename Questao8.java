
public class Questao8 {

	private static int somatorio(int[] vetor, int i) {
		if (i < vetor.length) {
			if(i < vetor.length-1) {
			System.out.print(vetor[i] + " + ");
			}else {
				System.out.print(vetor[i] + " = ");
			}
			
			return vetor[i] + somatorio(vetor, i + 1);
		} else {
			return 0;
		}

	}

	public static void main(String[] args) {
		int[] vetor = new int[10];
		
		for(int i = 0; i<10; i++) {
			double numero = Math.round(Math.random() * 100);
			
			vetor[i] = (int)numero;
		}
		
		int resultado = somatorio(vetor, 0);
		
		System.out.println(resultado);
	}
}
