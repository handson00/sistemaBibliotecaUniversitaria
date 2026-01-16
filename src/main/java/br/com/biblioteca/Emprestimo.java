package br.com.biblioteca;

import java.util.Date;

public class Emprestimo {
    private Date dataRetirada;
    private Date dataDevolucao;
    private Date dataDevolucaoPrevista;
    private Usuario usuario;
    private Exemplar exemplar;
    private String status;

    public Emprestimo(Date dataRetirada, Date dataDevolucaoPrevista, Usuario usuario, Exemplar exemplar) {
        this.dataRetirada = dataRetirada;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.status = "Ativo";
        exemplar.emprestar();
    }

    public void registrarDevolucao(Date dataDevolucao) {
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
}
