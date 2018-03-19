package com.bisponet.filmcatalogator.Controller;

import com.bisponet.filmcatalogator.Model.Movie;
import com.bisponet.filmcatalogator.Service.FilmesService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
public class MovieController {

    private FilmesService service = new FilmesService();

    @RequestMapping(value = "/filmes", method = RequestMethod.GET)
    public List<Movie> filmes(@RequestParam(value = "sort", defaultValue = "id") Sort sort) {
        return service.getAllMovies(sort);
    }

    @RequestMapping(value = "/filmes/{id}", method = RequestMethod.GET)
    public Optional<Movie> filmesById(@PathVariable String id) {
        return service.getMoviesById(id);
    }

    @RequestMapping(value = "/filmes/{title}", method = RequestMethod.GET)
    public Movie filmesByTitle(@PathVariable String title) {
        return service.getMovieByTitle(title);
    }

    @RequestMapping(value = "/filmes/{slug}", method = RequestMethod.GET)
    public Movie filmesBySlug(@PathVariable String slug){
        return service.getMovieBySlug(slug);
    }

    @RequestMapping(value = "/filme", method = RequestMethod.POST)
    public ResponseEntity<?> addNewMovie(@RequestHeader("user") String user,
                                         @RequestHeader("password") String password,
                                         @RequestBody Map<String, String> payload) throws Exception {
        return service.saveNewMovie(user, password, payload);
    }
}
