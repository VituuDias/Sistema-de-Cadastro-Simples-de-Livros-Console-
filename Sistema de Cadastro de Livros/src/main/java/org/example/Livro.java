package org.example;

import java.util.Objects;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private String anoPublicacao;
    private String edicao;

    public Livro(String titulo, String autor, String genero, String anoPublicacao, String edicao) {
        validarENormalizar(titulo, autor);
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;


    }

    public Livro(String titulo, String autor) {
        validarENormalizar(titulo, autor);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", autor ='" + autor + '\'' +
                ", genero ='" + genero + '\'' +
                ", Ano de publicacao ='" + anoPublicacao + '\'' +
                ", edicao do livro ='" + edicao + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase(), autor.toLowerCase());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return titulo.equalsIgnoreCase(livro.titulo) &&
                autor.equalsIgnoreCase(livro.autor);
    }

    private void validarENormalizar(String titulo, String autor) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("O título do Livro é obrigatório");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor do Livro é obrigatório");
        }

        this.titulo = titulo.trim();
        this.autor = autor.trim();
    }
}
