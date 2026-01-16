package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Biblioteca {
    private String nome;
    private String endereco;
    private List<Exemplar> exemplares;

    public Biblioteca(String nome, String endereco) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        if (endereco == null || endereco.isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode estar vazio");
        }
        
        this.nome = nome;
        this.endereco = endereco;
        this.exemplares = new ArrayList<>();
    }

    public void adicionarExemplar(Exemplar exemplar) {
        if (exemplar == null) {
            throw new IllegalArgumentException("Exemplar não pode ser nulo");
        }
        if (exemplares.contains(exemplar)) {
            throw new IllegalStateException("Exemplar já está cadastrado");
        }
        exemplares.add(exemplar);
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

    public int getTotalExemplaresArmazenados() {
        return exemplares.size();
    }

    public int getTotalExemplaresDisponiveis() {
        int contador = 0;
        for (Exemplar ex : exemplares) {
            if (ex.isDisponivel()) {
                contador++;
            }
        }
        return contador;
    }

    public int getTotalExemplaresEmprestados() {
        return getTotalExemplaresArmazenados() - getTotalExemplaresDisponiveis();
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", exemplares=" + exemplares.size() +
                '}';
    }
}
