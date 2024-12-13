/*
* Autor: [Gustavo Alves Hanisch]
* Linguagem: [Java]
* Data: [10/12/2024]
* Descrição: [O programa consiste em um jogo de cartas em que o usuário deve escolher uma das 8 cartas disponíveis, e se o usuário escolher uma carta errada, ele perderá o jogo]
* Funcionalidades: [Variáveis - cartas[]: Array que contém o nome das 8 cartas disponíveis no jogo. Usadas[]: Array de booleanos, usado para acompanhar quais cartas já foram escolhidas pelo usuário. P: Variável booleana que indica se o jogador perdeu (se escolheu a carta errada). CR: Contador de cartas restantes. ICP: Índice da carta errada, gerado aleatoriamente. Loop principal - (while): Este loop continua enquanto houver cartas restantes (CR > 0) e o jogador não tenha perdido (P). Cartas Disponíveis - usadas[]: O programa imprime as cartas que ainda não foram escolhidas pelo jogador. Condições - (E == ICP): Se o jogador escolher a carta errada ele perde o jogo e o loop termina. (CR): Se o jogador escolher uma carta certa, a carta é marcada como usada e o contador de cartas restantes é decrementado. Finalização - scanner.close(): É chamado ao final para fechar o recurso de entrada do usuário] 
* Versão: [1.0]
*/
import java.util.Scanner;
import java.util.Random; 
import java.io.PrintStream; 

public class Main { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); // Cria um objeto "Scanner" para ler dados dado pelo usuario
        Random random = new Random(); // Cria um objeto "Random" para criar numeros aleatórios, que será o que dara a aleatoriedade para a carta deixando sempre a carta errada como uma carta completamente diferente
        PrintStream output = new PrintStream(System.out); // Cria um objeto "PrintStream" para saída de dados

        String[] cartas = {"Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5", "Carta 6", "Carta 7", "Carta 8"}; 
        // string com o nome das cartas e um Array para elas 

        boolean[] usadas = new boolean[8]; // Array para ver quais cartas ja foram usadas

        boolean P = false; // Variavel para mostrar se o jogador perdeu

        int CR = 8; // numero de CR = cartas restantes

        int ICP = random.nextInt(8); // Gera um índice aleatório entre 0 e 7 representando a carta errada

        while (CR > 0 && !P) { // Loop principal executado enquanto houver cartas e o jogador não perder
            output.println("Cartas disponíveis:");
            for (int i = 0; i < 8; i++) { // Exibe as cartas disponíveis
                if (!usadas[i]) { // Verifica se a carta ja foi usada
                    output.println(cartas[i]); // saida de dados do computador para o usuario
                }
            }

            output.print("Escolha uma carta: "); // Mensagem para escolher uma carta
            int E = scanner.nextInt() - 1; // Le a escolha do jogador e ajusta para o indice do array

            if (E < 0 || E >= 8 || usadas[E]) { 
                // Verifica se a carta ja foi usada, se for, mostrará um mensagem avisando
                output.println("Essa carta já foi usada");// Saida de dados do computador para o usuario
            } else {
                if (E == ICP) { // Verifica se a carta escolhida é a carta errada
                    output.println("Carta errada, você perdeu");// Saida de dados do computador para o usuario
                    P = true; // Marca a derrota do usuario
                } else {
                    output.println("Carta certa, o jogo continua"); // Saida de dados do computador para o usuario
                    usadas[E] = true; // Marca a carta como usada
                    CR--; // Diminui o número de cartas restantes
                }
            }

            if (CR == 1) { 
                // Verifica se sobrou apenas uma carta, se sim, o usuario ganhou o jogo
                output.println("voce ganhou");// Saida de dados do computador para o usuario
                break; // Sai do loop 
            }
        }

        if (P) { 
            // Verifica se o usuario escolheu a carta errada, ou seja, perdeu
            output.println("voce perdeu");
        }

        scanner.close(); // Fecha o Scanner
    }
}