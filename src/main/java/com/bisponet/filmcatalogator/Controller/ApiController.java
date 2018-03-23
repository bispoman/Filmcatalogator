package com.bisponet.filmcatalogator.Controller;

import com.bisponet.filmcatalogator.Model.Movie;
import com.bisponet.filmcatalogator.Service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private FilmesService service;

    @GetMapping("/filmes")
    public List<Movie> filmes() {
        return service.getAllMovies();
    }

    @GetMapping("/filmes/{id}")
    public Optional<Movie> filmesById(@PathVariable String id) {
        return service.getMoviesById(id);
    }

    @GetMapping(value = "/filmes/{slug}")
    public Movie filmesBySlug(@PathVariable String slug){
        return service.getMovieBySlug(slug);
    }

    @PostMapping(value = "/filme")
    public ResponseEntity<?> addNewMovie(@RequestHeader("user") String user,
                                         @RequestHeader("password") String password,
                                         @RequestBody Map<String, String> payload) throws Exception {
        return service.saveNewMovie(user, password, payload);
    }
}
