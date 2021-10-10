package br.edu.ifpb.iseries.controllers;

import br.edu.ifpb.iseries.models.Series;
import br.edu.ifpb.iseries.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String form(Series series) {
        seriesRepository.save(series);
        return "redirect:/cadastrarSerie";
    }

    @RequestMapping("/series")
    public ModelAndView showSeries(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Series> series = seriesRepository.findAll();
        System.out.println(series);
        mv.addObject("series", series);
        return mv;
    }
}
