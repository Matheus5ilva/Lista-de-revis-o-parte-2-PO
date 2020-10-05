import java.io.*;
import java.util.*;

public class Lista2 {

	int[][] grafo = new int[18][3]; // Cria��o de uma variavel de matriz para salvar os dados do arquivo para a variavel

	int[][] matrizAdjacencia = new int[6][6]; // Cria��o de uma variavel para gerar um matriz de Adjacencia

	int[] node = new int[6]; // Cria��o de uma array salvar todos os verteces

	int[] arestas = new int[18]; // Cria��o de um array para salvar todas as arestas

	int[] grau = new int[6]; // Cria��o de um array para salvar o grau dos vertices
	
	
	
	public void grafo(String file) { //Metodo para ler o arquivo. Podemos reparar que o metodo pede uma declara��o de variavel String que reperesenta o caminho do arquivo .txt

		try {//Recurso usado para tratamento de excess�es do Java. Requisito do leitor de arquivo 
			Scanner input = new Scanner(new File(file)); // Usado a biblioteca Scanner para ler o arquivo. O File � para localizar e acessar o arquivo.

			for (int i = 0; i < 18; i++) {// La�o de repeti��o For para ler do arquivo e preencher as linhas do grafo.
				for (int j = 0; j < 3; j++) {// La�o de repeti��o For para ler do arquivo e preencher as colunas do grafo.
					this.grafo[i][j] = input.nextInt();// O grafo vai ser preenchida pelo atributo "retirado" do arquivo .txt . Reparamos que usamos this. para mostrar que � uma variavel da classe. Ou seja, todas as vezes que for instanciado, o valor do grafo ser� o mesmo.
				}
			}

			for (int x = 0; x < 18; x++) {// La�o de repeti��o criado para Imprimir na tela os dados das linhas do grafo
				for (int y = 0; y < 3; y++) {// La�o de repeti��o criado para Imprimir na tela os dados das coluna da grafo
					System.out.print(this.grafo[x][y] + " "); // Foi usado print para n�o haver o pulo de linha automatico. A� os numeros das linhas ficam juntas uma do lado da outra.
				}
				System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra
			}

		} catch (IOException ioe) { // Como temos o tratamento de excess�o try, � da biblioteca usarmos o catch para
									// completar

			System.out.println(ioe); // Impress�o na tela da mensagem do erro ocorrido. (Se houver).

		}

	}

	
	
	public void node() { //Metodo para separar os vertices de arestas

		ArrayList<Integer> node = new ArrayList<Integer>(); // Cria��o de uma variavel local da biblioteca ArrayList para retirar os vertices das arestas.
		int aux = 9999999; //Cria��o de uma variavel local para auxiliar e armazenar o valor do vertice. Essa variavel � volatil.

		for (int a = 0; a < 18; a++) {// La�o de repeti��o For para ler da variavel as linhas do grafo.
			for (int b = 0; b < 1; b++) {// La�o de repeti��o For para ler da variavel as colunas do grafo. Podemos reparar que s� percorre uma coluna, pois a primeira coluna representar� um vertice.
				if (aux == this.grafo[a][b]) { //Uma condicional para saber se o valor da variavel auxiliar � igual ao valor do grafo esta apontando. Essa � uma alternativa para n�o haver repeti��o de vertice.
					break; // O break paralisa e ignora o resto da instru��o do la�o de repeti��o b. Induzindo para o la�o de repeti��o a.
				}

				aux = this.grafo[a][b]; // Caso pule a condi��o, a variavel auxiliar vai ter o valor que o grafo gerou.

				node.add(aux); // Adicionando o valor do atributo auxiliar no arrayList via metodo ".add()". 
			}
		}

		for (int i = 0; i < node.size(); i++) { //La�o de repeti��o para converter os valores do ArrayList para o vetor node(vertice). Essa convers�o foi feita pois a manipula��o de um vetor � mais "facil" que o ArrayList<>.
			this.node[i] = node.get(i); // Adicionando valores contido no ArrayList<> para o vetor node (vertice).
		}
	}

	
	
	public void aresta() { //Metodo para separar as arestas dos vertices

		ArrayList<Integer> aresta = new ArrayList<Integer>(); // Cria��o de uma variavel local da biblioteca ArrayList para retirar as arestas dos vertices.
		int auxAresta = 999999; //Cria��o de uma variavel local para auxiliar e armazenar o valor do vertice. Essa variavel � volatil.

		for (int a = 0; a < 18; a++) { //La�o de repeti��o For para ler da variavel as linhas do grafo.
			for (int b = 2; b < 3; b++) {// La�o de repeti��o For para ler da variavel as colunas do grafo. Podemos reparar que s� percorre uma coluna, pois a terceira coluna representar� uma aresta.

				auxAresta = this.grafo[a][b];// A variavel auxiliar vai ter o valor que o grafo gerou.
				aresta.add(auxAresta);// Adicionando o valor do atributo auxiliar no arrayList via metodo ".add()".
			}
		}

		for (int i = 0; i < aresta.size(); i++) { //La�o de repeti��o para converter os valores do ArrayList para o vetor aresta. Essa convers�o foi feita pois a manipula��o de um vetor � mais "facil" que o ArrayList<>.
			this.arestas[i] = aresta.get(i);// Adicionando valores contido no ArrayList<> para o vetor aresta.
		}
	}

	
	
	public boolean liga(int v1, int v2, int aresta) { // Metodo para conferir se cada valor da posi��o do array node com o seu sucessor esta interligada por uma arestas.

		for (int x = 0; x < 18; x++) { //La�o de repeti��o For para ler da variavel as linhas do grafo.
			for (int y = 0; y < 3; y++) {// La�o de repeti��o For para ler da variavel as colunas do grafo.
				if (y == 2) { //Uma condicional para verificar se a coluna esta na ultima posi��o.
					if (v1 == this.grafo[x][y - 2] && v2 == this.grafo[x][y - 1] && aresta == this.grafo[x][y]) { // Condicional para verificar se a linha, as colunas s�o parecidas com os valores recebidos das variaveis atribuidas no metodo.
						return true; // Se a condicional for verdadeira, o metodo vai me retornar uma true. Fazendo que haja outra intera��o do la�o de repeti��o.
					}
				} else if (y == 1) {//Uma condicional para verificar se a coluna esta na penultima posi��o.
					if (v1 == this.grafo[x][y - 1] && v2 == this.grafo[x][y] && aresta == this.grafo[x][y + 1]) {
						return true; // Se a condicional for verdadeira, o metodo vai me retornar uma true. Fazendo que haja outra intera��o do la�o de repeti��o.
					}
				} else if (y == 0) {//Uma condicional para verificar se a coluna esta na antepenultima posi��o.
					if (v1 == this.grafo[x][y] && v2 == this.grafo[x][y + 1] && aresta == this.grafo[x][y + 2]) {
						return true; // Se a condicional for verdadeira, o metodo vai me retornar uma true. Fazendo que haja outra intera��o do la�o de repeti��o.
					}
				}

			}
		}

		return false; // Retorno em false para n�o ocorrer na fun��o. Ja que a fun��o pede um retorno booleano.
	}

	
	
	public void matriz() { //Metodo de cria��o da matriz de adjacencia

		for (int i = 0; i < 6; i++) { //La�o de repeti��o para percorrer as linhas da matriz de adjacencia
			for (int j = 0; j < 6; j++) { // La�o de repeti��o para percorrer as colunas da matriz de adjacencia 
				for (int x = 0; x < 18; x++) { // La�o de repeti��o para ler o array de vertice. Criamos esse la�o, porque o array de aresta possui 18 indices e n�o coseguiramos ler todos os valores do array.
					if (liga(this.node[i], this.node[j], this.arestas[x]) == true) { //Condicional para verificar se os valores contido no array node possui um vertice. Com isso usamos os metodo liga para obter seu retorno.
						this.matrizAdjacencia[i][j] = 1; //Se o retorno do metodo liga for igual a true(verdadeiro). Isso significa que os valores do vertice declarados, possui uma aresta interligando. Com isso colocamos o valor 1 na matriz de adjacencia, na posi��o indicada pelo i e j. 
					} else if (x < 6) {//Condicional para verificar se o valor x, do la�o de repeti��o da aresta � menor que 6. Isso porque a matriz de adjacencia so tem o indice maximo 6. Com isso, se a condicional de cima for falsa e o indice do array do vertice for menor que 6 fa�a a instru��o.
						this.matrizAdjacencia[i][j] = 0; // Se o retorno do metodo liga dor igual a false (falso) colocamos o valor 0 na posi��o i e j da matriz de adjacencia.
					}
				}
			}
		}

		
		System.out.print("  | ");// Foi usado print para n�o haver o pulo de linha automatico. Isso foi feito para separar os vertices da coluna
		for (int m = 0; m < 6; m++) {// La�o de repeti��o para Imprimir na tela os valores dos vertices contido no array(node).
			System.out.print(this.node[m] + " ");// Foi usado print para n�o haver o pulo de linha automatico. A� os numeros das linhas ficam juntas uma do lado da outra
		}
		System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra
		System.out.print("  ");
		for (int n = 2; n < 16; n++) { //La�o de repeti��o para Imprimir na tela uma linha para separar os valores da coluna com os valores da matriz de adjacencia.
			System.out.print("-");
		}
		System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra

		for (int k = 0; k < 6; k++) {// La�o de repeti��o criado para Imprimir na tela os dados das linhas da matriz de adjacencia.
			System.out.print(this.node[k] + " | ");// Foi usado print para n�o haver o pulo de linha automatico. Isso foi feito para separar os vertices da linha
			for (int l = 0; l < 6; l++) {// La�o de repeti��o criado para Imprimir na tela os dados das colunas da matriz de adjacencia.
				System.out.print(matrizAdjacencia[k][l] + " ");// Foi usado print para n�o haver o pulo de linha automatico. A� os numeros das linhas ficam juntas uma do lado da outra
			}
			System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra
		}
	}
	
	
	
	public void grau() {//Metodo que calcula o grau do vertice
		
		for (int i = 0; i < 6; i++) { //La�o de repeti��o para percorrer as linhas da matriz de adjacencia
			int contador = 0; // Variavel contador para somar cada vez que a minha condicional for verdadeira. Lembrando que ele � zerada cada vez que um novo vertice � adicionado.
			for (int j = 0; j < 6; j++) { // La�o de repeti��o para percorrer as colunas da matriz de adjacencia 
				for (int x = 0; x < 18; x++) { // La�o de repeti��o para ler o array de vertice. Criamos esse la�o, porque o array de aresta possui 18 indices e n�o coseguiramos ler todos os valores do array.
					if (liga(this.node[i], this.node[j], this.arestas[x]) == true) { //Condicional para verificar se os valores contido no array node possui um vertice. Com isso usamos os metodo liga para obter seu retorno.
						contador++; //Se o retorno do metodo liga for igual a true(verdadeiro). Isso significa que os valores do vertice declarados, possui uma aresta interligando. Com isso somamos +1 na variavel contador
					}
				}				
			}
			this.grau[i] = (contador/2); // Como o grafo pode ter mais de uma dire��o em suas arestas, dividimos por 2 para representar o real numero de vertices no grafo.
		}
		
		
		
		System.out.println();
		for(int y = 0; y < 6; y++) { //La�o de repeti��o para Imprimir na tela.
			System.out.print(this.node[y] + " -> " + this.grau[y] + " | ");
		}
		System.out.println();
	}
	
	
	
	public void questao7() { //Quest�o 7, como a quest�o usa o grafo da quest�o 6, esta na mesma classse do grafo
		
		int aux = 99999;
		
		for (int i = 0; i < 6; i++) { //La�o de repeti��o para percorrer as linhas da matriz de adjacencia
			ArrayList<Integer> vertice = new ArrayList<Integer>(); // Cria��o de uma variavel local da biblioteca ArrayList para retirar os vertices das arestas.
			for (int j = 0; j < 6; j++) { // La�o de repeti��o para percorrer as colunas da matriz de adjacencia 
				for (int x = 0; x < 18; x++) { // La�o de repeti��o para ler o array de vertice. Criamos esse la�o, porque o array de aresta possui 18 indices e n�o coseguiramos ler todos os valores do array.
					if (liga(this.node[i], this.node[j], this.arestas[x]) == true) { //Condicional para verificar se os valores contido no array node possui um vertice. Com isso usamos os metodo liga para obter seu retorno.
						if(aux == this.node[j]) {
							continue;
						}
						aux=this.node[j];
						vertice.add(aux); //Se o retorno do metodo liga for igual a true(verdadeiro). Isso significa que os valores do vertice declarados, possui uma aresta interligando. Com isso somamos +1 na variavel contador
					}
				}
			}
			System.out.print(node[i] + " = ");
			System.out.println(vertice);
		}
				
		
	}
	
	
}





