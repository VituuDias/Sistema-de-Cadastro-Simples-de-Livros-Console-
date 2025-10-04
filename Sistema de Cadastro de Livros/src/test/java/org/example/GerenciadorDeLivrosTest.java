package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GerenciadorDeLivrosTest {

    private GerenciadorDeLivros gerenciador;

    @BeforeEach
    void setUp(){
        gerenciador = new GerenciadorDeLivros();
    }


    //Teste para adição
    @Test
    void deveAdicionarUmLivroValido(){
        Livro livro = new Livro("O Exorcista", "William Peter Blatty");
        gerenciador.adicionarLivro(livro);

        //verifica se a lista agora tem 1 item
        assertEquals(1, gerenciador.listarTodos().size(),
            "A lista deve conter exatamente um livro.");

        //verifica se o objeto adicionado é realmente o que foi retornado
        assertTrue(gerenciador.listarTodos().contains(livro), "O livro adicionado deve estar presente na lista");
    }

    @Test
    void deveLancarExcecaoAoAdicionarComTituloApenasVazio() {
        // Caso 1: String vazia pura ("")
        Livro livroInvalido = new Livro("", "Autor Teste");

        assertThrows(IllegalArgumentException.class, () -> gerenciador.adicionarLivro(livroInvalido),
                "Deve lançar exceção quando o título é uma String vazia.");
    }

    @Test
    void deveLancarExcecaoAoAdicionarComTituloApenasEspacos() {
        // Caso 2: String contendo apenas espaços ("   ")
        Livro livroInvalido = new Livro("   ", "Autor Teste");

        assertThrows(IllegalArgumentException.class, () -> gerenciador.adicionarLivro(livroInvalido),
                "Deve lançar exceção quando o título tem apenas espaços em branco.");
    }

    @Test
    void deveLancarExcecaoAoAdicionarComAutorApenasVazio() {
        // Caso 1: String vazia pura ("")
        Livro livroInvalido = new Livro("Titulo Teste", "");

        assertThrows(IllegalArgumentException.class, () ->
            gerenciador.adicionarLivro(livroInvalido),
                "Deve lançar exceção quando o Autor é uma String vazia.");
    }

    @Test
    void deveLancarExcecaoAoAdicionarComAutorApenasEspacos() {
        // Caso 2: String contendo apenas espaços ("   ")
        Livro livroInvalido = new Livro("Titulo Teste", "    ");

        assertThrows(IllegalArgumentException.class, () ->
            gerenciador.adicionarLivro(livroInvalido),
                    "Deve lançar exceção quando o Autor tem apenas espaços em branco.");
    }

    //Testes para Listagem
    @Test
    void deveRetornarListaVaziaQuandoNenhumLivroForAdicionado(){
        assertTrue(gerenciador.listarTodos().isEmpty(),
                "A lista deve estar vazia quando não houevr cadastros.");
    }

    @Test
    void deveRetornarTodosOsLivrosAdicionados(){
        Livro l1 = new Livro("Duna", "Frank Herbert");
        Livro l2 = new Livro("1984", "George Orwell");

        gerenciador.adicionarLivro(l1);
        gerenciador.adicionarLivro(l2);

        List<Livro> livroListados = gerenciador.listarTodos();

        assertEquals(2, livroListados.size(),
                "A lista deve conter dois livros após a adição.");

        assertTrue(livroListados.stream().anyMatch(
                l -> l.getTitulo().equals("Duna")), "O livro 'Duna' deve estar na lista");
    }
}
