package br.com.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String matricula;
    private String email;
    private List<Emprestimo> emprestimos;
    private List<Reserva> reservas;

    public Usuario(String nome, String matricula, String email) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void realizarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public void fazerReserva(Reserva reserva) {
        this.reservas.add(reserva);
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

    public void consultarLivros(Livro livro) {
        System.out.println("Consultando livro: " + livro.getTitulo());
        System.out.println("Exemplares disponíveis: " + livro.contagemExemplaresdisponíveis());
    }
}
