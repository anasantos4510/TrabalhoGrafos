# PONTIFÍCIA UNIVERSIDADE CATÓLICA DE MINAS GERAIS
# Algoritmos em Grafos
## TRABALHO PRÁTICO
`Prof. Edwaldo Soares Rodrigues
Instruções:`
### I. O trabalho deverá ser feito em grupos de no máximo 2 estudantes.
### II. O trabalho deverá ser realizado usando a linguagem de programação C#, Java, C ou C++.
### III. Deverão usar os conceitos aprendidos na disciplina Algoritmos em Grafos.
### IV. O trabalho deverá ser entregue até a data 19/06/2024, via Canvas.
### V. A avaliação do trabalho será por meio de apresentação do código, sendo a avaliação individual e em grupo. Terão questionamentos individualizados, e em grupo. Se ficar claro que algum(ns) integrantes do grupo não saibam explicar o código o grupo todo será penalizado.
### VI. Comece a fazer este trabalho logo, enquanto o problema está fresco na memória e o prazo para terminá-lo está tão longe quanto jamais poderá estar; Enunciado do Trabalho: O Trabalho Prático deverá ser implementado usando a linguagem de programação C, C++, C# ou Java e tem como objetivo colocar em prática os conceitos vistos acerca da Teoria dos Grafos ao longo do semestre. Considere a implementação para grafos direcionados. O trabalho está dividido em duas partes, conforme a seguir: 

## Parte 1  
Criação de um grafo: As seguintes funcionalidades deverão ser implementadas a fim de que o usuário possa interagir com o programa: 
1. Construir um grafo. Nesse caso, o usuário deverá digitar a quantidade de vértices, a quantidade de arestas, e o peso de cada aresta. A escolha pela forma de representação do grafo será feita de acordo com a densidade do grafo. 2. Escolher a forma de representação do grafo (Matriz de Adjacência, Lista de
Adjacência, Matriz de Incidência). Como o usuário, vai inserir a quantidade de
vértices e arestas, então deve estar implementado ao menos uma forma de
representação via matriz, bem como a representação por lista de adjacência.
3. Imprimir a forma de representação do grafo (Lista de Adjacência, Matriz de
Adjacência ou Matriz de Incidência).
## Parte 2 
 Leitura de um grafo:
1. Leitura e impressão de um grafo já pronto. Nesse caso, vocês deverão ler um
grafo de entrada no formato DIMACS1
. O grafo a ser lido, deve ser representado
em uma Lista de Adjacência, Matriz de Adjacência ou Matriz de Incidência.
2. Imprimir todas as arestas adjacentes a uma aresta a, informada pelo usuário.
3. Imprimir todos os vértices adjacentes a um vértice v, informado pelo usuário.
4. Imprimir todas as arestas incidentes a um vértice v, informado pelo usuário.
5. Imprimir todos os vértices incidentes a uma aresta a, informada pelo usuário.
6. Imprimir o grau do vértice v, informado pelo usuário.
7. Determinar se dois vértices são adjacentes.
8. Substituir o peso de uma aresta a, informada pelo usuário.
9. Trocar dois vértices. Como exemplo, considere um vértice v1 que se conecta aos
vértices v3, v5 e v7, ao passo que o vértice v2 se conecta aos vértices v4 e v6.
A troca dos vértices v1 e v2 implicaria que o vértice v1 estaria conectado aos
vértices v4 e v6. Por sua vez, o vértice v2 estaria conectado aos vértices v3, v5
e v7. O usuário deverá informar qual são os dois vértices a serem trocados.
10. Busca em grafos (Busca em Largura): O vértice inicial será dado pelo usuário e
a respectiva árvore de busca deve ser gerada assim como o nível de cada vértice
na árvore (nível da raiz é zero), além de apresentar os predecessores. Use a
ordem numérica crescente para escolher entre os vértices adjacentes.
11. Busca em grafos (Busca em Profundidade): O vértice inicial será dado pelo
usuário e a respectiva árvore de busca deve ser gerada assim como a distância
de descoberta e de finalização de cada vértice na árvore (nível da raiz é zero).
Use a ordem numérica crescente para escolher entre os vértices adjacentes.
12. Implementar o Algoritmo de Dijkstra. Este algoritmo, a partir de um vértice origem
o e um vértice destino d, encontra o caminho mínimo entre eles. Deverá ser
impresso a rota utilizada, ou seja, os vértices utilizados no caminho mínimo entre
o e d, com os respectivos pesos de cada aresta do caminho.
13. Implementar o Algoritmo de Floyd Warshall. Este algoritmo, a partir de um
vértice origem o, encontra o caminho mínimo entre o vértice o e todos os demais
vértices do grafo.
14. Criação de um menu onde o usuário poderá interagir com a aplicação.
## Parte 3 - Desafio
Desafio (3 pontos extras):
Faça um método que verifique se um grafo é euleriano, usando o Algoritmo de Fleury.
Se o grafo for euleriano, apresente o caminho. Para isso, terá que implementar um
método que identifique se uma aresta é uma ponte. OBS: Pesquise por algoritmo de
Tarjan.
Salve em um arquivo de texto os tempos computacionais necessários utilizando como
teste, grafos aleatórios contendo 100, 1000, 10000 e 100000 vértices. OBS: Crie um
método para gerar grafos no formato DIMACs.
Exemplo de formato DIMACs:
1 - Formato padrão DIMACS (Exemplo, o grafo a seguir tem a seguinte representação
DIMACS):
Onde:
Na primeira linha, o primeiro valor representa o número de vértices, e o segundo o
número de arestas;
Nas demais linhas, o primeiro valor representa o vértice de origem, o segundo valor o
vértice de destino e o terceiro valor o peso da aresta;