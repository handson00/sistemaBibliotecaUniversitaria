package br.com.biblioteca;

import java.util.Date;
import java.util.Objects;

public class Emprestimo {
    private Date dataRetirada;
    private Date dataDevolucao;
    private Date dataDevolucaoPrevista;
    private Usuario usuario;
    private Exemplar exemplar;
    private String status;

    public Emprestimo(Date dataRetirada, Date dataDevolucaoPrevista, Usuario usuario, Exemplar exemplar) {
        if (dataRetirada == null) {
            throw new IllegalArgumentException("Data de retirada não pode ser nula");
        }
        if (dataDevolucaoPrevista == null) {
            throw new IllegalArgumentException("Data de devolução prevista não pode ser nula");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        if (exemplar == null) {
            throw new IllegalArgumentException("Exemplar não pode ser nulo");
        }
        if (!exemplar.isDisponivel()) {
            throw new IllegalStateException("Exemplar não está disponível");
        }
        
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.status = "Ativo";
        exemplar.emprestar();
    }

    public void registrarDevolucao(Date dataDevolucao) {
        if (dataDevolucao == null) {
            throw new IllegalArgumentException("Data de devolução não pode ser nula");
        }
        this.dataDevolucao = dataDevolucao;
        this.status = "Devolvido";
        exemplar.devolver();
    }

    public boolean verificarAtraso() {
        if (dataDevolucao == null && new Date().after(dataDevolucaoPrevista)) {
            return true;
        }
        return false;
    }

    public void renovar(Date novaDataDevolucao) {
        if (novaDataDevolucao == null) {
            throw new IllegalArgumentException("Data de devolução não pode ser nula");
        }
        if (verificarAtraso()) {
            throw new IllegalStateException("Não é possível renovar empréstimo atrasado");
        }
        this.dataDevolucaoPrevista = novaDataDevolucao;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public Date getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "usuario='" + usuario.getNome() + '\'' +
                ", exemplar='" + exemplar.getCodigoBarras() + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
