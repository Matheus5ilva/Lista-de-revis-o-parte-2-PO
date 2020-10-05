import java.io.*;
import java.util.*;

public class Lista2 { // Essa Classe é responsavel pela leitura e manipulação do grafo das questões 6 e 7 da lista 2. A questão 7 esta feita no ultimo metodo dessa classe.

	int[][] grafo = new int[18][3]; // Criação de uma variavel de matriz para salvar os dados do arquivo para a variavel

	int[][] matrizAdjacencia = new int[6][6]; // Criação de uma variavel para gerar um matriz de Adjacencia

	int[] node = new int[6]; // Criação de uma array salvar todos os verteces

	int[] arestas = new int[18]; // Criação de um array para salvar todas as arestas

	int[] grau = new int[6]; // Criação de um array para salvar o grau dos vertices
	
	
	
	public void grafo(String file) { //Metodo para ler o arquivo. Podemos reparar que o metodo pede uma declaração de variavel String que reperesenta o caminho do arquivo .txt

		try {//Recurso usado para tratamento de excessões do Java. Requisito do leitor de arquivo 
			Scanner input = new Scanner(new File(file)); // Usado a biblioteca Scanner para ler o arquivo. O File é para localizar e acessar o arquivo.

			for (int i = 0; i < 18; i++) {// Laço de repetição For para ler do arquivo e preencher as linhas do grafo.
				for (int j = 0; j < 3; j++) {// Laço de repetição For para ler do arquivo e preencher as colunas do grafo.
					this.grafo[i][j] = input.nextInt();// O grafo vai ser preenchida pelo atributo "retirado" do arquivo .txt . Reparamos que usamos this. para mostrar que é uma variavel da classe. Ou seja, todas as vezes que for instanciado, o valor do grafo será o mesmo.
				}
			}

			for (int x = 0; x < 18; x++) {// Laço de repetição criado para Imprimir na tela os dados das linhas do grafo
				for (int y = 0; y < 3; y++) {// Laço de repetição criado para Imprimir na tela os dados das coluna da grafo
					System.out.print(this.grafo[x][y] + " "); // Foi usado print para não haver o pulo de linha automatico. Aí os numeros das linhas ficam juntas uma do lado da outra.
				}
				System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra
			}

		} catch (IOException ioe) { // Como temos o tratamento de excessão try, é da biblioteca usarmos o catch para
									// completar

			System.out.println(ioe); // Impressão na tela da mensagem do erro ocorrido. (Se houver).

		}

	}

	
	
	public void node() { //Metodo para separar os vertices de arestas

		ArrayList<Integer> node = new ArrayList<Integer>(); // Criação de uma variavel local da biblioteca ArrayList para retirar os vertices das arestas.
		int aux = 9999999; //Criação de uma variavel local para auxiliar e armazenar o valor do vertice. Essa variavel é volatil.

		for (int a = 0; a < 18; a++) {// Laço de repetição For para ler da variavel as linhas do grafo.
			for (int b = 0; b < 1; b++) {// Laço de repetição For para ler da variavel as colunas do grafo. Podemos reparar que só percorre uma coluna, pois a primeira coluna representará um vertice.
				if (aux == this.grafo[a][b]) { //Uma condicional para saber se o valor da variavel auxiliar é igual ao valor do grafo esta apontando. Essa é uma alternativa para não haver repetição de vertice.
					break; // O break paralisa e ignora o resto da instrução do laço de repetição b. Induzindo para o laço de repetição a.
				}

				aux = this.grafo[a][b]; // Caso pule a condição, a variavel auxiliar vai ter o valor que o grafo gerou.

				node.add(aux); // Adicionando o valor do atributo auxiliar no arrayList via metodo ".add()". 
			}
		}
		
		Collections.sort(node); // Uso da Biblioteca Collections para ordernar o array do menor numero para o maior

		for (int i = 0; i < node.size(); i++) { //Laço de repetição para converter os valores do ArrayList para o vetor node(vertice). Essa conversão foi feita pois a manipulação de um vetor é mais "facil" que o ArrayList<>.
			this.node[i] = node.get(i); // Adicionando valores contido no ArrayList<> para o vetor node (vertice).
		}
	}

	
	
	public void aresta() { //Metodo para separar as arestas dos vertices

		ArrayList<Integer> aresta = new ArrayList<Integer>(); // Criação de uma variavel local da biblioteca ArrayList para retirar as arestas dos vertices.
		int auxAresta = 999999; //Criação de uma variavel local para auxiliar e armazenar o valor do vertice. Essa variavel é volatil.

		for (int a = 0; a < 18; a++) { //Laço de repetição For para ler da variavel as linhas do grafo.
			for (int b = 2; b < 3; b++) {// Laço de repetição For para ler da variavel as colunas do grafo. Podemos reparar que só percorre uma coluna, pois a terceira coluna representará uma aresta.

				auxAresta = this.grafo[a][b];// A variavel auxiliar vai ter o valor que o grafo gerou.
				aresta.add(auxAresta);// Adicionando o valor do atributo auxiliar no arrayList via metodo ".add()".
			}
		}

		for (int i = 0; i < aresta.size(); i++) { //Laço de repetição para converter os valores do ArrayList para o vetor aresta. Essa conversão foi feita pois a manipulação de um vetor é mais "facil" que o ArrayList<>.
			this.arestas[i] = aresta.get(i);// Adicionando valores contido no ArrayList<> para o vetor aresta.
		}
	}

	
	
	public boolean liga(int v1, int v2, int aresta) { // Metodo para conferir se cada valor da posição do array node com o seu sucessor esta interligada por uma arestas.

		for (int x = 0; x < 18; x++) { //Laço de repetição For para ler da variavel as linhas do grafo.
			for (int y = 0; y < 3; y++) {// Laço de repetição For para ler da variavel as colunas do grafo.
				if (y == 2) { //Uma condicional para verificar se a coluna esta na ultima posição.
					if (v1 == this.grafo[x][y - 2] && v2 == this.grafo[x][y - 1] && aresta == this.grafo[x][y]) { // Condicional para verificar se a linha, as colunas são parecidas com os valores recebidos das variaveis atribuidas no metodo.
						return true; // Se a condicional for verdadeira, o metodo vai me retornar uma true. Fazendo que haja outra interação do laço de repetição.
					}
				} else if (y == 1) {//Uma condicional para verificar se a coluna esta na penultima posição.
					if (v1 == this.grafo[x][y - 1] && v2 == this.grafo[x][y] && aresta == this.grafo[x][y + 1]) {
						return true; // Se a condicional for verdadeira, o metodo vai me retornar uma true. Fazendo que haja outra interação do laço de repetição.
					}
				} else if (y == 0) {//Uma condicional para verificar se a coluna esta na antepenultima posição.
					if (v1 == this.grafo[x][y] && v2 == this.grafo[x][y + 1] && aresta == this.grafo[x][y + 2]) {
						return true; // Se a condicional for verdadeira, o metodo vai me retornar uma true. Fazendo que haja outra interação do laço de repetição.
					}
				}

			}
		}

		return false; // Retorno em false para não ocorrer na função. Ja que a função pede um retorno booleano.
	}

	
	
	public void matriz() { //Metodo de criação da matriz de adjacencia

		for (int i = 0; i < 6; i++) { //Laço de repetição para percorrer as linhas da matriz de adjacencia
			for (int j = 0; j < 6; j++) { // Laço de repetição para percorrer as colunas da matriz de adjacencia 
				for (int x = 0; x < 18; x++) { // Laço de repetição para ler o array de vertice. Criamos esse laço, porque o array de aresta possui 18 indices e não coseguiramos ler todos os valores do array.
					if (liga(this.node[i], this.node[j], this.arestas[x]) == true) { //Condicional para verificar se os valores contido no array node possui um vertice. Com isso usamos os metodo liga para obter seu retorno.
						this.matrizAdjacencia[i][j] = 1; //Se o retorno do metodo liga for igual a true(verdadeiro). Isso significa que os valores do vertice declarados, possui uma aresta interligando. Com isso colocamos o valor 1 na matriz de adjacencia, na posição indicada pelo i e j. 
					} else if (x < 6) {//Condicional para verificar se o valor x, do laço de repetição da aresta é menor que 6. Isso porque a matriz de adjacencia so tem o indice maximo 6. Com isso, se a condicional de cima for falsa e o indice do array do vertice for menor que 6 faça a instrução.
						this.matrizAdjacencia[i][j] = 0; // Se o retorno do metodo liga dor igual a false (falso) colocamos o valor 0 na posição i e j da matriz de adjacencia.
					}
				}
			}
		}

		
		System.out.print("  | ");// Foi usado print para não haver o pulo de linha automatico. Isso foi feito para separar os vertices da coluna
		for (int m = 0; m < 6; m++) {// Laço de repetição para Imprimir na tela os valores dos vertices contido no array(node).
			System.out.print(this.node[m] + " ");// Foi usado print para não haver o pulo de linha automatico. Aí os numeros das linhas ficam juntas uma do lado da outra
		}
		System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra
		System.out.print("  ");
		for (int n = 2; n < 16; n++) { //Laço de repetição para Imprimir na tela uma linha para separar os valores da coluna com os valores da matriz de adjacencia.
			System.out.print("-");
		}
		System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra

		for (int k = 0; k < 6; k++) {// Laço de repetição criado para Imprimir na tela os dados das linhas da matriz de adjacencia.
			System.out.print(this.node[k] + " | ");// Foi usado print para não haver o pulo de linha automatico. Isso foi feito para separar os vertices da linha
			for (int l = 0; l < 6; l++) {// Laço de repetição criado para Imprimir na tela os dados das colunas da matriz de adjacencia.
				System.out.print(matrizAdjacencia[k][l] + " ");// Foi usado print para não haver o pulo de linha automatico. Aí os numeros das linhas ficam juntas uma do lado da outra
			}
			System.out.println();// Foi usado println para quebra de linha automatica. Separando uma Linha da outra
		}
	}
	
	
	
	public void grau() {//Metodo que calcula o grau do vertice
		
		for (int i = 0; i < 6; i++) { //Laço de repetição para percorrer as linhas da matriz de adjacencia
			int contador = 0; // Variavel contador para somar cada vez que a minha condicional for verdadeira. Lembrando que ele é zerada cada vez que um novo vertice é adicionado.
			for (int j = 0; j < 6; j++) { // Laço de repetição para percorrer as colunas da matriz de adjacencia 
				for (int x = 0; x < 18; x++) { // Laço de repetição para ler o array de vertice. Criamos esse laço, porque o array de aresta possui 18 indices e não coseguiramos ler todos os valores do array.
					if (liga(this.node[i], this.node[j], this.arestas[x]) == true) { //Condicional para verificar se os valores contido no array node possui um vertice. Com isso usamos os metodo liga para obter seu retorno.
						contador++; //Se o retorno do metodo liga for igual a true(verdadeiro). Isso significa que os valores do vertice declarados, possui uma aresta interligando. Com isso somamos +1 na variavel contador
					}
				}				
			}
			this.grau[i] = (contador/2); // Como o grafo pode ter mais de uma direção em suas arestas, dividimos por 2 para representar o real numero de vertices no grafo.
		}
		
		
		
		System.out.println();
		for(int y = 0; y < 6; y++) { //Laço de repetição para Imprimir na tela.
			System.out.print(this.node[y] + " -> " + this.grau[y] + " | ");
		}
		System.out.println();
	}
	
	
	
	public void questao7() { //Questão 7, como a questão usa o grafo da questão 6, esta na mesma classse do grafo
		
		int aux = 99999;
		
		for (int i = 0; i < 6; i++) { //Laço de repetição para percorrer as linhas da matriz de adjacencia
			ArrayList<Integer> vertice = new ArrayList<Integer>(); // Criação de uma variavel local da biblioteca ArrayList para retirar os vertices das arestas.
			for (int j = 0; j < 6; j++) { // Laço de repetição para percorrer as colunas da matriz de adjacencia 
				for (int x = 0; x < 18; x++) { // Laço de repetição para ler o array de vertice. Criamos esse laço, porque o array de aresta possui 18 indices e não coseguiramos ler todos os valores do array.
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





