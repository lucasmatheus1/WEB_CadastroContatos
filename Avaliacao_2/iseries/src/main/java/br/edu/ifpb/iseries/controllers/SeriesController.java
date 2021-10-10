package br.edu.ifpb.iseries.controllers;

import br.edu.ifpb.iseries.models.Serie;
import br.edu.ifpb.iseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SeriesController {

    @Autowired
    private SeriesRepository seriesRepository;

    @RequestMapping(value= "/cadastrarSerie", method = RequestMethod.GET)
    public String form() {
        return "serie/formSerie";
    }

    @RequestMapping(value= "/cadastrarSerie", method = RequestMethod.POST)
    public String form(Serie serie) {
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

    @RequestMapping("/{id}")
    public ModelAndView detalhesSerie(@PathVariable("id") long id){
        System.out.println("Dsadasdsadsd");
        Serie serie = seriesRepository.findById(id);
        ModelAndView mv = new ModelAndView("serie/detalhesSerie");
        mv.addObject("serie", serie);

        return mv;
    }
}
