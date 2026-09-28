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

 /** Classe para representação de um Quadrado */
public class Quadrado extends PoligonoReto{
 
    /**
     * Construtor: recebe um lado que será propagado para base e altura. A classe-mãe valida o lado como pelo menos 1.
     * @param lado Lado para o quadrado. Valor deve ser igual ou maior a 1, ou será corrigido para 1.
     */
    public Quadrado(double lado){
        super("Quadrado", lado, lado);
    }

    /**
     * Calcula e retorna a área do quadrado
     * @return Área do quadrado (double)
     */
    @Override
    public double area(){
        return base * altura;
    }

    /**
     * Calcula e retorna o perímetro do quadrado
     * @return Perímetro do quadrado (double)
     */
    @Override
    public double perimetro(){
        return base * 4;
    }

    /**
     * Representação em string do quadrado: descrição, área e lado.
     * @return String com a descrição acima
     */
    @Override
    public String toString(){
        return super.toString() + String.format(" | Lado: %.4f.",base);
    }

}
