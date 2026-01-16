package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private String endereco;
    private List<Exemplar> exemplares;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.exemplares = new ArrayList<>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    public int totalLivrosArmazenados() {
        return exemplares.size();
    }
}
