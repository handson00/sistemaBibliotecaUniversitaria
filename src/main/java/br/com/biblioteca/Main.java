package br.com.biblioteca;

import java.util.Calendar;
import java.util.Date;

public class Main {
    
    public static void main(String[] args) {
        // Criando biblioteca
        Biblioteca bibl = new Biblioteca("Biblioteca Central", "Av. Universitária, 123");
        System.out.println("Biblioteca: " + bibl.getNome());
        System.out.println();

        // Criando editora e autores
        Editora editoraCompanhia = new Editora("Companhia das Letras", "12.345.678/0001-99");
        Autor machado = new Autor("Machado de Assis", "Brasileiro");
        Autor paulo = new Autor("Paulo Coelho", "Brasileiro");

        // Criando livros
        Livro memoriasPostumas = new Livro("Memórias Póstumas de Brás Cubas", "978-1234567890", 1899, editoraCompanhia);
        memoriasPostumas.adicionarAutor(machado);

        Livro alquimista = new Livro("O Alquimista", "978-0987654321", 1988, editoraCompanhia);
        alquimista.adicionarAutor(paulo);

        // Criando exemplares (cópias físicas)
        Exemplar ex1 = new Exemplar("BC-001", "Estante A1", memoriasPostumas);
        Exemplar ex2 = new Exemplar("BC-002", "Estante A2", memoriasPostumas);
        Exemplar ex3 = new Exemplar("BC-003", "Estante B1", alquimista);

        // Adicionando exemplares aos livros e à biblioteca
        memoriasPostumas.adicionarExemplar(ex1);
        memoriasPostumas.adicionarExemplar(ex2);
        alquimista.adicionarExemplar(ex3);

        bibl.adicionarExemplar(ex1);
        bibl.adicionarExemplar(ex2);
        bibl.adicionarExemplar(ex3);

        System.out.println("Total de livros armazenados: " + bibl.totalLivrosArmazenados());
        System.out.println();

        // Criando usuário
        Usuario usuario1 = new Usuario("João Silva", "2023001", "joao@email.com");

        // Consultando livro
        usuario1.consultarLivros(memoriasPostumas);
        System.out.println();

        // Realizando empréstimo
        Date hoje = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 14);
        Date dataRetorno = cal.getTime();

        Emprestimo emp1 = new Emprestimo(hoje, dataRetorno, usuario1, ex1);
        usuario1.realizarEmprestimo(emp1);

        System.out.println("Empréstimo realizado!");
        System.out.println("Livro: " + emp1.getExemplar().getLivro().getTitulo());
        System.out.println("Status: " + emp1.getStatus());
        System.out.println();

        // Fazendo reserva
        Reserva res1 = new Reserva(hoje, dataRetorno, usuario1, alquimista);
        usuario1.fazerReserva(res1);
        res1.confirmar();

        System.out.println("Reserva realizada!");
        System.out.println("Livro: " + res1.getLivro().getTitulo());
        System.out.println("Status: " + res1.getStatus());
        System.out.println();

        // Devolvendo livro
        emp1.registrarDevolucao(hoje);
        System.out.println("Livro devolvido!");
        System.out.println("Status do empréstimo: " + emp1.getStatus());
        System.out.println("Exemplar agora está disponível: " + ex1.isDisponivel());
    }
}
