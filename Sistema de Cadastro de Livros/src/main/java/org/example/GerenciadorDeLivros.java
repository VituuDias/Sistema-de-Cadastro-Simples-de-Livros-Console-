package org.example;


import java.util.HashSet;
import java.util.Set;

public class GerenciadorDeLivros {

    private Set<Livro> colecaoLivros;

    public GerenciadorDeLivros() {
        this.colecaoLivros = new HashSet<>();
    }

    public Set<Livro> getColecaoLivros() {
        return colecaoLivros;
    }

    public void adicionarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("O objeto Livro não pode ser nulo");
        }

        // Tenta adicionar no Set
        boolean adicionado = this.colecaoLivros.add(livro);

        if (adicionado) {
            System.out.println("Livro '" + livro.getTitulo() + "' adicionado com sucesso");
        } else {
            System.out.println("Livro já cadastrado: " + livro.getTitulo() + " - " + livro.getAutor());
        }
    }

    public void exibirLivrosNumerados() {
        if (colecaoLivros.isEmpty()) {
            System.out.println("Não há livros cadastrados.\n");
        }

        int i=1;
        for(Livro l : colecaoLivros){
            System.out.println(i + ". " + l);
            i++;
        }
    }

    public Set<Livro> listarTodos() {
        return this.colecaoLivros;
    }

    public void removerLivroPorNumeroNaLista(int indice) {
        if (indice < 0 || indice > colecaoLivros.size()) {
            System.out.println("Índice inválido");
            return;
        }

        int i = 1;
        Livro livroARemover = null;

        for (Livro l : colecaoLivros) {
            if (i == indice) {
                livroARemover = l;
                break;
            }
            i++;
        }
        if (livroARemover != null) {
            colecaoLivros.remove(livroARemover);
            System.out.println("Livro removido: " + livroARemover.getTitulo());
        }
    }

    public void removerLivroPorAutor(String autor){
        if(colecaoLivros.isEmpty()){
            System.out.println("Não há livros cadastrados.");
            return;
        }

        String autorNormalizado = autor.trim();

        Set<Livro> livrosParaRemover = new HashSet<>();

        for(Livro l : colecaoLivros){
            if(l.getAutor().equalsIgnoreCase(autorNormalizado)){
                livrosParaRemover.add(l);
            }
        }

        if(livrosParaRemover.isEmpty()){
            System.out.println("Nenhum livro encontrado com o autor: " + autor);
        } else{
            colecaoLivros.removeAll(livrosParaRemover);
            System.out.println("Removidos " + livrosParaRemover.size() + " livro(s) do autor: " + autor);
        }
    }

}
