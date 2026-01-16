package br.com.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Livro {
    private String titulo;
    private String isbn;
    private int anoPublicacao;
    private Editora editora;
    private List<Autor> autores;
    private List<Exemplar> exemplares;

    public Livro(String titulo, String isbn, int anoPublicacao, Editora editora) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Título não pode estar vazio");
        }
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN não pode estar vazio");
        }
        if (anoPublicacao <= 0) {
            throw new IllegalArgumentException("Ano de publicação deve ser maior que zero");
        }
        if (editora == null) {
            throw new IllegalArgumentException("Editora não pode ser nula");
        }
        
        this.titulo = titulo;
        this.isbn = isbn.replaceAll("[^0-9X]", "");
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.autores = new ArrayList<>();
        this.exemplares = new ArrayList<>();
    }

    public void adicionarAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("Autor não pode ser nulo");
        }
        if (autores.contains(autor)) {
            throw new IllegalStateException("Este autor já está vinculado ao livro");
        }
        autores.add(autor);
    }

    public void adicionarExemplar(Exemplar exemplar) {
        if (exemplar == null) {
            throw new IllegalArgumentException("Exemplar não pode ser nulo");
        }
        exemplares.add(exemplar);
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
        return Collections.unmodifiableList(autores);
    }

    public List<Exemplar> getExemplares() {
        return Collections.unmodifiableList(exemplares);
    }

    public int contarExemplaresdisponíveis() {
        int contador = 0;
        for (Exemplar ex : exemplares) {
            if (ex.isDisponivel()) {
                contador++;
            }
        }
        return contador;
    }

    public int getTotalExemplares() {
        return exemplares.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", editora=" + editora.getNome() +
                '}';
    }
}
