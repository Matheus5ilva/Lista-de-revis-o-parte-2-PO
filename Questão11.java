
public class Questão11 {
	public static void main(String[] args) {

		int n = 20;
		int s1 = 0;
		int s2 = 0;
		int somatorio1 = 0;
		int somatorio2 = 0;
		
		for (int i = 1; i <= n; i++) {
			s1 = ((2 * i) - 1);
			somatorio1 += s1;
			System.out.print( s1 + " / ");
			for (int j = i; j <= i; j++) {
			 s2 += (int)Math.pow(2, (j+1));
			 System.out.println(s2 );
			 somatorio2+=s2;
			}
			
		}
		System.out.println();
		System.out.println("Resultado é " + somatorio1 + " / " + somatorio2);
	}
}

//s1 5 / 28 s2 