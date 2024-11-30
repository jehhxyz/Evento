package br.anhembi.eventosapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

//é também uma entidade
@Entity
public class Convidado {

    @Id
    private String rg;
    
    @NotBlank
    private String nomeConvidado;

    //relacionamento ManyToOne entre convidado e evento
    @ManyToOne
    private Evento evento;

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getNomeConvidado() {
        return nomeConvidado;
    }
    public void setNomeConvidado(String nomeConvidado) {
        this.nomeConvidado = nomeConvidado;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
