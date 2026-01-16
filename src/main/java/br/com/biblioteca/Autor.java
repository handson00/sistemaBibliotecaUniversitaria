package br.com.biblioteca;

import java.util.Objects;

public class Autor {
    private String nome;
    private String nacionalidade;

    public Autor(String nome, String nacionalidade) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        if (nacionalidade == null || nacionalidade.isEmpty()) {
            throw new IllegalArgumentException("Nacionalidade não pode estar vazia");
        }
        
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nome, autor.nome) &&
                Objects.equals(nacionalidade, autor.nacionalidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, nacionalidade);
    }

    @Override
    public String toString() {
        return "Autor{nome='" + nome + "', nacionalidade='" + nacionalidade + "'}";
    }
}
