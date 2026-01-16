package br.com.biblioteca;

import java.util.Date;
import java.util.Objects;

public class Reserva {
    private Date dataSolicitacao;
    private Date dataExpiracao;
    private Usuario usuario;
    private Livro livro;
    private String status;

    public Reserva(Date dataSolicitacao, Date dataExpiracao, Usuario usuario, Livro livro) {
        if (dataSolicitacao == null) {
            throw new IllegalArgumentException("Data de solicitação não pode ser nula");
        }
        if (dataExpiracao == null) {
            throw new IllegalArgumentException("Data de expiração não pode ser nula");
        }
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        
        this.dataSolicitacao = dataSolicitacao;
        this.dataExpiracao = dataExpiracao;
        this.usuario = usuario;
        this.livro = livro;
        this.status = "Ativa";
    }

    public void confirmar() {
        if ("Cancelada".equals(status)) {
            throw new IllegalStateException("Não é possível confirmar uma reserva cancelada");
        }
        this.status = "Confirmada";
    }

    public void cancelar() {
        if ("Confirmada".equals(status)) {
            throw new IllegalStateException("Não é possível cancelar uma reserva confirmada");
        }
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
        if (new Date().after(dataExpiracao)) {
            this.status = "Expirada";
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "usuario='" + usuario.getNome() + '\'' +
                ", livro='" + livro.getTitulo() + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
