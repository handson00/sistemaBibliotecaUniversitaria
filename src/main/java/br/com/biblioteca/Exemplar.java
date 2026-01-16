package br.com.biblioteca;

import java.util.Objects;

public class Exemplar {
    private String codigoBarras;
    private boolean disponivel;
    private String estante;
    private Livro livro;

    public Exemplar(String codigoBarras, String estante, Livro livro) {
        if (codigoBarras == null || codigoBarras.isEmpty()) {
            throw new IllegalArgumentException("Código de barras não pode estar vazio");
        }
        if (estante == null || estante.isEmpty()) {
            throw new IllegalArgumentException("Estante não pode estar vazia");
        }
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        
        this.codigoBarras = codigoBarras;
        this.disponivel = true;
        this.estante = estante;
        this.livro = livro;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getEstante() {
        return estante;
    }

    public void setEstante(String estante) {
        if (estante == null || estante.isEmpty()) {
            throw new IllegalArgumentException("Estante não pode estar vazia");
        }
        this.estante = estante;
    }

    public Livro getLivro() {
        return livro;
    }

    public void emprestar() {
        if (!disponivel) {
            throw new IllegalStateException("Exemplar já está emprestado");
        }
        this.disponivel = false;
    }

    public void devolver() {
        this.disponivel = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exemplar exemplar = (Exemplar) o;
        return Objects.equals(codigoBarras, exemplar.codigoBarras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarras);
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", disponivel=" + disponivel +
                ", estante='" + estante + '\'' +
                '}';
    }
}
