package br.com.biblioteca;

import java.util.Objects;

public class Editora {
    private String nome;
    private String cnpj;

    public Editora(String nome, String cnpj) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        if (cnpj == null || cnpj.isEmpty()) {
            throw new IllegalArgumentException("CNPJ não pode estar vazio");
        }
        
        String cnpjLimpo = cnpj.replaceAll("[^0-9]", "");
        if (cnpjLimpo.length() != 14) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos");
        }
        
        this.nome = nome;
        this.cnpj = cnpjLimpo;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editora editora = (Editora) o;
        return Objects.equals(cnpj, editora.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }

    @Override
    public String toString() {
        return "Editora{nome='" + nome + "', cnpj='" + cnpj + "'}";
    }
}
