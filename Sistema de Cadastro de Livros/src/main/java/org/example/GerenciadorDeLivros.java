package org.example;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeLivros {

    private List<Livro> colecaoLivros;

    public GerenciadorDeLivros() {
        this.colecaoLivros = new ArrayList<>();
    }

    public List<Livro> getColecaoLivros() {
        return colecaoLivros;
    }

    public void adicionarLivro(Livro livro){
        if(livro == null){
            throw new IllegalArgumentException("O objeto Livro não pode ser nulo");
        }
        if(livro.getTitulo() == null || livro.getTitulo().trim().isEmpty()){
            throw new IllegalArgumentException("O titulo do Livro é obrigatório");
        }
        if(livro.getAutor() == null || livro.getAutor().trim().isEmpty()){
            throw new IllegalArgumentException("O autor do Livro é obrigatório");
        }
        this.colecaoLivros.add(livro);
    }

    public List<Livro> listarTodos(){
        return this.colecaoLivros;
    }

}
