package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private String nome;
    private String matricula;
    private String email;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;

    public Usuario(String nome, String matricula, String email) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula não pode estar vazia");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email não pode estar vazio");
        }
        
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void realizarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo == null) {
            throw new IllegalArgumentException("Empréstimo não pode ser nulo");
        }
        emprestimos.add(emprestimo);
    }

    public void fazerReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("Reserva não pode ser nula");
        }
        reservas.add(reserva);
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getEmail() {
        return email;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void consultarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        System.out.println("Consultando livro: " + livro.getTitulo());
        System.out.println("Exemplares disponíveis: " + livro.contarExemplaresdisponíveis());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(matricula, usuario.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + "', matricula='" + matricula + "', email='" + email + "'}";
    }
}
