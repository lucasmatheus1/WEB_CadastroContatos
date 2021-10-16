package br.edu.ifpb.iseries.controllers;

import br.edu.ifpb.iseries.models.Episodio;
import br.edu.ifpb.iseries.models.Temporada;
import br.edu.ifpb.iseries.repository.EpisodioRepository;
import br.edu.ifpb.iseries.repository.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EpisodioController {

    @Autowired
    private EpisodioRepository episodioRepository;

    @Autowired
    private TemporadaRepository temporadaRepository;

    @RequestMapping("/deletarEp")
    public String deletarEpisodio(long id) {
        Episodio episodio = episodioRepository.findById(id);
        Temporada temporada = episodio.getTemporada();
        episodioRepository.delete(episodio);
        return "redirect:/temporada"+temporada.getId();
    }

    @RequestMapping(value = "/editarEpisodio{id}", method = RequestMethod.GET)
    public ModelAndView editarEpisodio(@PathVariable("id") long id) {
        Episodio episodio = episodioRepository.findById(id);
        ModelAndView mv = new ModelAndView("episodio/formEditarEpisodio");
        mv.addObject("episodio", episodio);
        return mv;
    }

    @RequestMapping(value= "/editarEpisodio{id}", method = RequestMethod.POST)
    public String editarEpisodioPost(Episodio episodio) {
        Episodio episodioBD = episodioRepository.findById(episodio.getId());
        episodioBD.setNome(episodio.getNome());
        Temporada temporada = episodioBD.getTemporada();
        episodioRepository.save(episodioBD);
        return "redirect:/temporada"+temporada.getId();
    }

    @RequestMapping(value = "/adicionarEpisodio")
    public String adicionarEpisodio(long id) {
        Temporada temporada = temporadaRepository.findById(id);
        Episodio episodio = new Episodio();

        episodio.setAssistiu("false");
        episodio.setTemporada(temporada);
        episodio.setNome("Episódio " + (temporada.getEpisodios().size()+1));
        episodioRepository.save(episodio);

        return "redirect:/temporada" + id;
    }

}
