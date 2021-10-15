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

import java.util.List;

@Controller
public class TemporadaController {

    @Autowired
    private TemporadaRepository temporadaRepository;

    @Autowired
    private EpisodioRepository episodioRepository;

    @RequestMapping(value = "/temporada{id}", method = RequestMethod.GET)
    public ModelAndView detalhesEpisodio(@PathVariable("id") long id){
        Temporada temporada = temporadaRepository.findById(id);
        ModelAndView mv = new ModelAndView("episodio/detalhesEpisodio");
        mv.addObject("temporada", temporada);
        Iterable<Episodio> episodios = episodioRepository.findByTemporada(temporada);
        mv.addObject("episodios", episodios);
        return mv;
    }

    @RequestMapping(value = "/temporada{id}", method = RequestMethod.POST)
    public String detalhesEpisodioAssistido(@PathVariable("id") long id, String idEpisodio){

        String[] ids;

        if (idEpisodio == null) {
            ids = new String[1];
            ids[0] = "-1";
        } else {
            ids = idEpisodio.split(",");
        }

        Temporada temporada = temporadaRepository.findById(id);

        List<Episodio> episodios = temporada.getEpisodios();


        for (Episodio episodio: episodios ) {
            int verif = 0;
            for (String idEp : ids) {
                if (episodio.getId() == Long.parseLong(idEp)) {
                    episodio.setAssistiu("true");
                    verif = 1;
                }
            }
            if(verif==0){
                episodio.setAssistiu("false");
            }
            episodioRepository.save(episodio);
        }

        episodios = temporada.getEpisodios();

        int cont = 0;
        for (Episodio episodio: episodios) {
            if(episodio.getAssistiu().equals("true")){
                cont++;
            }
        }
        temporada.setQtdAssistiu(cont +"/"+episodios.size());
        temporadaRepository.save(temporada);

        return "redirect:/series";
    }

    @RequestMapping(value = "/editarTemporada{id}", method = RequestMethod.GET)
    public ModelAndView editarTemporada(@PathVariable("id") long id) {
        Temporada temporada = temporadaRepository.findById(id);
        ModelAndView mv = new ModelAndView("temporada/formEditarTemporada");
        mv.addObject("temporada", temporada);
        return mv;
    }

    @RequestMapping(value= "/editarTemporada{id}", method = RequestMethod.POST)
    public String editarTemporadaPost(Temporada temporada) {
        Temporada temporadaBD = temporadaRepository.findById(temporada.getId());
        temporadaBD.setNome(temporada.getNome());
        temporadaRepository.save(temporadaBD);
        return "redirect:/series";
    }


    @RequestMapping("/deletarTemp")
    public String deletarTemporada(long id) {
        Temporada temporada = temporadaRepository.findById(id);
        temporadaRepository.delete(temporada);
        return "redirect:/series";
    }



}
