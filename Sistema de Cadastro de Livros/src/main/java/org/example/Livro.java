package org.example;

public class Livro {
    private String titulo;
    private String autor;
    private String genero;
    private String anoPublicacao;
    private String edicao;

    public Livro(String titulo, String autor, String genero, String anoPublicacao, String edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anoPublicacao = anoPublicacao;
        this.edicao = edicao;
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
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
}
