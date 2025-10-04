package org.example;

import javax.swing.text.LabelView;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void adicionarLivroConsole(Scanner scanner, GerenciadorDeLivros gerenciadorDeLivros){
        System.out.println("\n----Adicionar novo Livro----");

        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Ano de publicacao: ");
        String anoPublicacao = scanner.nextLine();
        System.out.print("Edição: ");
        String edicao = scanner.nextLine();

        try{
            Livro novoLivro = new Livro(titulo, autor, genero, anoPublicacao, edicao);
            gerenciadorDeLivros.adicionarLivro(novoLivro);
            System.out.println("Livro ' " + titulo + " ' adicionado com sucesso");
        }catch(IllegalArgumentException e){
            System.out.println("Erro de validação: " + e.getMessage());
        }

    }

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
        Livro livro;
        GerenciadorDeLivros gerenciador = new GerenciadorDeLivros();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            menuPrincipal();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();

                // LIMPEZA DO BUFFER
                scanner.nextLine();

            } else {
                // Lidar com entradas não-inteiras para evitar loop infinito
                System.out.println("\nEntrada inválida. Por favor, digite um número inteiro.\n");
                scanner.next();
                opcao = 0;
            continue;
            }
            switch (opcao) {
                case 1:
                    System.out.println("\n--- Opção 1: Cadastrar livro ---\n");
                    adicionarLivroConsole(scanner, gerenciador);
                    break;
                case 2:
                    System.out.println("\n--- Opção 2: Listar livros ---\n");

                    List<Livro> livros = gerenciador.listarTodos();
                    //valida livro
                    if(livros.isEmpty()){
                        System.out.println("Nenhum livro cadastrado.\n");
                    }
                    for (int i = 0; i < livros.size(); i++) {
                        Livro l = livros.get(i);
                        System.out.println((i + 1) + ". " + l);
                    }
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
        scanner.close();
    }
}