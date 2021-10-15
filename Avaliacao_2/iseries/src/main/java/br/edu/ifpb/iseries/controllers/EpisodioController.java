package br.edu.ifpb.iseries.controllers;

import br.edu.ifpb.iseries.models.Episodio;
import br.edu.ifpb.iseries.repository.EpisodioRepository;
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

    @RequestMapping("/deletarEp")
    public String deletarEpisodio(long id) {
        Episodio episodio = episodioRepository.findById(id);
        episodioRepository.delete(episodio);
        return "redirect:/series";
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
        episodioRepository.save(episodioBD);
        return "redirect:/series";
    }

}
