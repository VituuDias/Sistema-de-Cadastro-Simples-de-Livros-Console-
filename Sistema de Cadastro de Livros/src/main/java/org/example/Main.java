package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void menuPrincipal() {
        System.out.println("--- Bem vindo ao Sistema de Cadastro de Livros! ---");
        System.out.println("A seguir estão as opções disponíveis: ");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Remover Livro por número na lista");
        System.out.println("4 - Remover Livro por autor");
        System.out.println("5 - Buscar livro por Palavra-chave");
        System.out.println("6 - Limpar a lista");
        System.out.println("7 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) {
        Scanner opcaoMenu = new Scanner(System.in);
        int opcao;
        do {
            menuPrincipal();
            if (opcaoMenu.hasNextInt()) {
                opcao = opcaoMenu.nextInt();
            } else {
                // Lidar com entradas não-inteiras para evitar loop infinito
                System.out.println("\nEntrada inválida. Por favor, digite um número inteiro.\n");
                opcaoMenu.next();
                opcao = 0;
            continue;
            }
            switch (opcao) {
                case 1:
                    System.out.println("\n--- Opção 1: Cadastrar livro ---\n");

                    break;
                case 2:
                    System.out.println("\n--- Opção 2: Listar livros ---\n");

                    break;
                case 3:
                    System.out.println("\n--- Opção 3: Remover Livro por número na lista ---\n");

                    break;
                case 4:
                    System.out.println("\n--- Opção 4: Remover Livro por autor ---\n");

                    break;
                case 5:
                    System.out.println("\n--- Opção 5: Buscar livro por Palavra-chave ---\n");

                    break;
                case 6:
                    System.out.println("\n--- Opção 6: Limpar a lista ---\n");

                    break;
                case 7:
                    System.out.println("\nSaindo do sistema. Até mais!\n");

                    break;
                default:
                    System.out.println("\nOpção inválida! Por favor, escolha uma opção de 1 a 7.\n");
                    break;
            }
        } while (opcao != 7);
        opcaoMenu.close();
    }
}