package br.edu.ifpb.iseries.controllers;

import br.edu.ifpb.iseries.models.Episodio;
import br.edu.ifpb.iseries.models.Serie;
import br.edu.ifpb.iseries.models.Temporada;
import br.edu.ifpb.iseries.models.Usuario;
import br.edu.ifpb.iseries.repository.EpisodioRepository;
import br.edu.ifpb.iseries.repository.SeriesRepository;
import br.edu.ifpb.iseries.repository.TemporadaRepository;
import br.edu.ifpb.iseries.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SeriesController {

    @Autowired
    private UserRepository userRepository;

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
        System.out.println("==========================");
        seriesRepository.save(serie);
        List<Temporada> temporadas = new ArrayList<>();
        int contTemp = 1;
        for(int i=0; i< serie.getQtdTemporadas(); i++) {

            Temporada temporada = new Temporada();
            temporada.setNome("Temporada " + contTemp);
            temporada.setSerie(serie);
            temporada.setQtdAssistiu("0/"+serie.getQtdEpisodios());
            temporadaRepository.save(temporada);
            contTemp++;

            List<Episodio> episodios = new ArrayList<>();
            int contEp = 1;
            for (int j = 0; j < serie.getQtdEpisodios(); j++){
                Episodio episodio = new Episodio();
                episodio.setNome("Episódio " + contEp);
                episodio.setTemporada(temporada);
                episodio.setAssistiu("false");
                episodioRepository.save(episodio);
                episodios.add(episodio);
                contEp++;
            }

            temporada.setEpisodios(episodios);
            temporadaRepository.save(temporada);
            temporadas.add(temporada);
        }
        serie.setTemporadas(temporadas);
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = userRepository.findByEmail(email);
        serie.setUser(user);
        seriesRepository.save(serie);

        return "redirect:/series";
    }

    @RequestMapping("/series")
    public ModelAndView listaSeries(){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Usuario user = userRepository.findByEmail(email);
        ModelAndView mv = new ModelAndView("dashboard");
        mv.addObject("user", user);
        Iterable<Serie> series = seriesRepository.findByUser(user);
        mv.addObject("series", series);
        return mv;
    }

    @RequestMapping(value = "/serie{id}", method = RequestMethod.GET)
    public ModelAndView detalhesSerie(@PathVariable("id") long id){
        Serie serie = seriesRepository.findById(id);
        ModelAndView mv = new ModelAndView("serie/detalhesSerie");
        mv.addObject("serie", serie);
        Iterable<Temporada> temporadas = temporadaRepository.findBySerie(serie);
        mv.addObject("temporadas", temporadas);
        return mv;
    }

    @RequestMapping(value = "/serie{id}", method = RequestMethod.POST)
    public String adicionarTemporada(Serie serie,String nome, String qtdEpisodios) {
        Serie serieBD = seriesRepository.findById(serie.getId());

        Temporada temporada = new Temporada();
        temporada.setSerie(serieBD);
        temporada.setNome(nome);
        temporada.setQtdAssistiu("0/"+qtdEpisodios);
        temporadaRepository.save(temporada);

        List<Episodio> episodios = new ArrayList<>();
        for (int j = 0; j < Integer.parseInt(qtdEpisodios); j++){
            Episodio episodio = new Episodio();
            episodio.setNome("Episódio " + (j+1));
            episodio.setTemporada(temporada);
            episodio.setAssistiu("false");
            episodioRepository.save(episodio);
            episodios.add(episodio);
        }

        temporada.setEpisodios(episodios);
        temporadaRepository.save(temporada);

        return "redirect:/serie" + serie.getId();
    }

    @RequestMapping(value = "/editarSerie{id}", method = RequestMethod.GET)
    public ModelAndView editarSerie(@PathVariable("id") long id) {
        Serie serie = seriesRepository.findById(id);
        ModelAndView mv = new ModelAndView("serie/formEditarSerie");
        mv.addObject("serie", serie);
        return mv;
    }

    @RequestMapping(value= "/editarSerie{id}", method = RequestMethod.POST)
    public String editarSeriePost(Serie serie) {
        Serie serieBD = seriesRepository.findById(serie.getId());
        serieBD.setNome(serie.getNome());
        seriesRepository.save(serieBD);
        return "redirect:/series";
    }

    @RequestMapping("/deletar")
    public String deletarSerie(long id) {
        Serie serie = seriesRepository.findById(id);
        seriesRepository.delete(serie);
        return "redirect:/series";
    }


}
