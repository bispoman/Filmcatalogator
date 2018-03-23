package com.bisponet.filmcatalogator.Controller;

import com.bisponet.filmcatalogator.Model.Movie;
import com.bisponet.filmcatalogator.Service.FilmesService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class MovieController {

    private FilmesService service = new FilmesService();

    @GetMapping("/filmes")
    public List<Movie> filmes(@RequestParam(value = "sort", defaultValue = "id") Sort sort) {
        return service.getAllMovies(sort);
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
