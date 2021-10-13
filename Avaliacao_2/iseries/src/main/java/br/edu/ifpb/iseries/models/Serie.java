package br.edu.ifpb.iseries.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Serie implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nome;

    private int qtdTemporadas;

    private int qtdEpisodios;

    @OneToMany
    private List<Temporada> temporadas;

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

    public int getQtdTemporadas() {
        return qtdTemporadas;
    }

    public void setQtdTemporadas(int qtdTemporadas) {
        this.qtdTemporadas = qtdTemporadas;
    }

    public int getQtdEpisodios() {
        return qtdEpisodios;
    }

    public void setQtdEpisodios(int qtdEpisodios) {
        this.qtdEpisodios = qtdEpisodios;
    }

    public List<Temporada> getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(List<Temporada> temporadas) {
        this.temporadas = temporadas;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", qtdTemporadas=" + qtdTemporadas +
                ", qtdEpisodios=" + qtdEpisodios +
                ", temporadas=" + temporadas +
                '}';
    }
}
