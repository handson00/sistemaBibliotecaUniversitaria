package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String isbn;
    private int anoPublicacao;
    private Editora editora;
    private List<Autor> autores;
    private List<Exemplar> exemplares;

    public Livro(String titulo, String isbn, int anoPublicacao, Editora editora) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autores = new ArrayList<>();
        this.exemplares = new ArrayList<>();
    }

    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void adicionarExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public Editora getEditora() {
        return editora;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public int contagemExemplaresdisponíveis() {
        int contador = 0;
        for (Exemplar ex : exemplares) {
            if (ex.isDisponivel()) {
                contador++;
            }
        }
        return contador;
    }
}
