import java.util.Random;

/** 
 * MIT License
 *
 * Copyright(c) 2023-26 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


public class App {
    
    Random sorteio = new Random(42);
    /**
     * Encapsula a leitura de um número inteiro via teclado. Não tem tratamento de erros (ainda)
     * @param mensagem Mensagem a ser exibida no console. 
     * @return Um número inteiro digitado pelo usuário
     */
    int lerNumero(String mensagem){
        return  Integer.parseInt(IO.readln(mensagem));
    }

    /**
     * Simula uma pausa, pedindo para o usuário digitar enter antes de continuar.
     */
    void pausa(){
        IO.readln("Digite <ENTER> para continuar");
    }

    /**
     * Esvazia o terminal VT-100, simulando limpeza de tela.
     */
    void limparTela() {
        IO.print("\033[H\033[2J");
    }

    /**
     * Encapsula o processo de construção de um conjunto, fazendo leituras de teclado do usuário. 
     * As formas geométricas estão sendo criadas com tamanho fixo. 
     * Sugestão: melhorar para que seja aleatório ou para ler do usuário.
     * @param tamanho Tamanho do conjunto a ser criado.
     * @return Um ConjuntoGeométrico com a quantidade de figuras especificadas em "tamanho"
     */
    ConjuntoGeometrico criaFormas(int tamanho){
        
        ConjuntoGeometrico conjunto = new ConjuntoGeometrico(tamanho);

        for (int i = 0; i < tamanho; i++) {
            double valor1 = sorteio.nextDouble(2, 7);
            double valor2 = sorteio.nextDouble(2, 7);
            IO.println("Formas disponíveis: ");
            IO.print("1 - Quadrado | ");
            IO.print("2 - Círculo | ");
            IO.print("3 - Retângulo | ");
            IO.print("4 - Triângulo Retângulo | ");
            int opcao = lerNumero("Digite sua escolha: ");
            FormaGeometrica nova = null;
            switch(opcao){
                case 1-> nova = new Quadrado(valor1);
                case 2-> nova = new Circulo(valor1);
                case 3-> nova = new Retangulo(valor1, valor2);
                case 4-> nova = new TrianguloRetangulo(valor1, valor2);
            }
            conjunto.addForma(nova);
        }
        return conjunto;
    }

    int menuPrincipal(){
        limparTela();
        IO.println("1 - Mostrar conjunto");
        IO.println("2 - Maior forma");
        IO.println("3 - Criar novo conjunto");
        IO.println("0 - Sair");
        return lerNumero("Opção: ");
    }

    void main() {
        int tamanho;
        ConjuntoGeometrico meuConjuntoGeometrico;
        int opcao=-1;

        tamanho = lerNumero("Qual o tamanho do conjunto a ser criado? ");
        meuConjuntoGeometrico = criaFormas(tamanho);
        
        while(opcao!=0){
            opcao = menuPrincipal();        
            IO.println("\n\n---------------------------");
            switch(opcao){
                case 1 ->{
                    IO.println(meuConjuntoGeometrico);
                    IO.println("---------------------------");
                }
                case 2 ->{
                    IO.println(meuConjuntoGeometrico.maiorArea());
                    IO.println("---------------------------");
                }
                case 3 ->{
                    tamanho = lerNumero("Qual o tamanho do conjunto a ser criado? ");
                    meuConjuntoGeometrico = criaFormas(tamanho);
                }
            }
            pausa();
        }


        
    }
}

