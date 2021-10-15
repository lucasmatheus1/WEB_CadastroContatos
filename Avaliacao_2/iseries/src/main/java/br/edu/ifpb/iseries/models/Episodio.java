package br.edu.ifpb.iseries.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Episodio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nome;

    @ManyToOne
    private Temporada temporada;

    private String assistiu;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Temporada getTemporada() {
        return temporada;
    }

    public void setTemporada(Temporada temporada) {
        this.temporada = temporada;
    }

    public String getAssistiu() {
        return assistiu;
    }

    public void setAssistiu(String assistiu) {
        this.assistiu = assistiu;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", temporada=" + temporada +
                ", assistiu='" + assistiu + '\'' +
                '}';
    }
}
