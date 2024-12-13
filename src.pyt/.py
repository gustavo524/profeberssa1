'''
Autor: [Gustavo Alves Hanisch]
Linguagem: [C]
Data: [10/12/2024]
Descrição: [O programa consiste em um jogo de cartas em que o usuário deve escolher uma das 8 cartas disponíveis, e se o usuário escolher uma carta errada, ele perderá o jogo]
Funcionalidades: [Variáveis - cartas[]: Array que contém o nome das 8 cartas disponíveis no jogo. Usadas[]: Array de booleanos, usado para acompanhar quais cartas já foram escolhidas pelo usuário. P: Variável booleana que indica se o jogador perdeu (se escolheu a carta errada). CR: Contador de cartas restantes. ICP: Índice da carta errada, gerado aleatoriamente. Loop principal - (while): Este loop continua enquanto houver cartas restantes (CR > 0) e o jogador não tenha perdido (P). Cartas Disponíveis - usadas[]: O programa imprime as cartas que ainda não foram escolhidas pelo jogador. Condições - (E == ICP): Se o jogador escolher a carta errada ele perde o jogo e o loop termina. (CR): Se o jogador escolher uma carta certa, a carta é marcada como usada e o contador de cartas restantes é decrementado. Finalização - scanner.close(): É chamado ao final para fechar o recurso de entrada do usuário] 
Versão: [1.0]
'''

import random

# Lista com o nome das cartas
cartas = ["Carta 1", "Carta 2", "Carta 3", "Carta 4", "Carta 5", "Carta 6", "Carta 7", "Carta 8"]

# Lista para marcar quais cartas já foram usadas
usadas = [False] * 8

# Variável para indicar se o jogador perdeu
P = False

# Número de Cartas Restantes
CR = 8

# Gera um índice aleatório entre 0 e 7 representando a carta errada
ICP = random.randint(0, 7)

while CR > 0 and not P:  # Loop principal executado enquanto houver cartas e o jogador não perder
    print("Cartas disponíveis:")
    for i in range(8):  # Exibe as cartas disponíveis
        if not usadas[i]:  # Verifica se a carta já foi usada
            print(cartas[i])  # Exibe a carta que ainda pode ser escolhida

    print("Escolha uma carta: ", end="")  # Solicita a escolha de uma carta
    E = int(input()) - 1  # Lê a escolha do jogador e ajusta para o índice do array (de 1 a 8 para 0 a 7)

    if E < 0 or E >= 8 or usadas[E]: 
        # Verifica se a carta escolhida está fora do intervalo ou já foi usada
        print("Essa carta já foi USADA ou número inválido")  # Mensagem de erro
    else:
        if E == ICP:  # Verifica se a carta escolhida é a carta errada
            print("Carta errada você perdeu")  # Mensagem de derrota
            P = True  # Marca a derrota do usuário
        else:
            print("Carta certa o jogo continua")  # Mensagem de sucesso
            usadas[E] = True  # Marca a carta como usada
            CR -= 1  # Reduz o número de cartas restantes

    if CR == 1: 
        # Se restar apenas uma carta, o jogador ganhou
        print("Parabéns você ganhou")  # Mensagem de vitória
        break  # Sai do loop 

if P: 
    # Se o jogador perdeu
    print("Você perdeu")  # Mensagem de derrota final
