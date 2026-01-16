package br.com.biblioteca;

import java.util.Date;

public class Reserva {
    private Date dataSolicitacao;
    private Date dataExpiracao;
    private Usuario usuario;
    private Livro livro;
    private String status;

    public Reserva(Date dataSolicitacao, Date dataExpiracao, Usuario usuario, Livro livro) {
        this.dataSolicitacao = dataSolicitacao;
        this.dataExpiracao = dataExpiracao;
        this.usuario = usuario;
        this.livro = livro;
        this.status = "Ativa";
    }

    public void confirmar() {
        this.status = "Confirmada";
    }

    public void cancelar() {
        this.status = "Cancelada";
    }

    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public String getStatus() {
        return status;
    }

    public boolean verificarExpiracao() {
        return new Date().after(dataExpiracao);
    }
}
