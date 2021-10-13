package br.edu.ifpb.iseries.models;

import javax.persistence.*;

@Entity
public class Episodio {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nome;

    @ManyToOne
    private Temporada temporada;

    public Episodio(String nome, Temporada temporada) {
        this.nome = nome;
        this.temporada = temporada;
    }

    public Episodio() {

    }

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

    @Override
    public String toString() {
        return "Episodio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", temporada=" + temporada +
                '}';
    }
}
