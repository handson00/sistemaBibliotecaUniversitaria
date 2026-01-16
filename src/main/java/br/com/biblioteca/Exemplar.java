package br.com.biblioteca;

public class Exemplar {
    private String codigoBarras;
    private boolean disponivel;
    private String estante;
    private Livro livro;

    public Exemplar(String codigoBarras, String estante, Livro livro) {
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

    public Livro getLivro() {
        return livro;
    }

    public void emprestar() {
        if (disponivel) {
            this.disponivel = false;
        }
    }

    public void devolver() {
        this.disponivel = true;
    }
}
