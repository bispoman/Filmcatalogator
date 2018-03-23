package com.bisponet.filmcatalogator.Controller;

import com.bisponet.filmcatalogator.Service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @Autowired
    private FilmesService service;

    @GetMapping("/filmes")
    public String webFilmes(Model model) {
        model.addAttribute("moviesList", service.getAllMovies());
        return "index";
    }
}
