package br.edu.ifpb.iseries.controllers;

import br.edu.ifpb.iseries.models.Episodio;
import br.edu.ifpb.iseries.models.Serie;
import br.edu.ifpb.iseries.models.Temporada;
import br.edu.ifpb.iseries.repository.EpisodioRepository;
import br.edu.ifpb.iseries.repository.SeriesRepository;
import br.edu.ifpb.iseries.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

@Controller
public class SeriesController {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private TemporadaRepository temporadaRepository;

    @Autowired
    private EpisodioRepository episodioRepository;

    @RequestMapping(value= "/cadastrarSerie", method = RequestMethod.GET)
    public String form() {
        return "serie/formSerie";
    }

    @RequestMapping(value= "/cadastrarSerie", method = RequestMethod.POST)
    public String form(Serie serie) {
        System.out.println("=====================================" + serie);
        seriesRepository.save(serie);
        List<Temporada> temporadas = new ArrayList<>();
        for(int i=0; i< serie.getQtdTemporadas(); i++) {

            Temporada temporada = new Temporada();
            temporada.setNome("Temporada " + i);
            temporada.setSerie(serie);
            temporadaRepository.save(temporada);

            List<Episodio> episodios = new ArrayList<>();

            for (int j = 0; j < serie.getQtdEpisodios(); j++){
                Episodio episodio = new Episodio();
                episodio.setNome("Episódio " + j);
                episodio.setTemporada(temporada);
                episodioRepository.save(episodio);
                episodios.add(episodio);
            }

            temporada.setEpisodios(episodios);
            temporadaRepository.save(temporada);
            temporadas.add(temporada);
        }
        serie.setTemporadas(temporadas);
        seriesRepository.save(serie);
        return "redirect:/cadastrarSerie";
    }

    @RequestMapping("/series")
    public ModelAndView listaSeries(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Serie> series = seriesRepository.findAll();
        mv.addObject("series", series);
        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesSerie(@PathVariable("id") long id){
        Serie serie = seriesRepository.findById(id);
        ModelAndView mv = new ModelAndView("serie/detalhesSerie");
        mv.addObject("serie", serie);

        Iterable<Temporada> temporadas = temporadaRepository.findBySerie(serie);

        mv.addObject("temporadas", temporadas);
        return mv;
    }

    @RequestMapping(value = "/temporada/{id}", method = RequestMethod.GET)
    public ModelAndView detalhesEpisodio(@PathVariable("id") long id){
        Temporada temporada = temporadaRepository.findById(id);
        ModelAndView mv = new ModelAndView("serie/detalhesEpisodio");
        mv.addObject("temporada", temporada);

        Iterable<Episodio> episodios = episodioRepository.findByTemporada(temporada);
        mv.addObject("episodios", episodios);
        return mv;
    }


}
