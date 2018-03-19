package com.bisponet.filmcatalogator.Service;

import com.bisponet.filmcatalogator.Model.Movie;
import com.bisponet.filmcatalogator.Repository.MovieRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

public class FilmesService {

    private MovieRepository repository;

    public List<Movie> getAllMovies(Sort sort) {
        return repository.findAll(sort);
    }

    public Optional<Movie> getMoviesById(String id) {
        return repository.findById(id);
    }

    public Movie getMovieByTitle(String title) {
        return repository.findByTitle(title);
    }

    public Movie getMovieBySlug(String slug) {
        return repository.findBySlug(slug);
    }

    public ResponseEntity<?> saveNewMovie(String user, String password, Map<String, String> payload){

        if (user.equals("usertest") && password.equals("passtest")) {
            try {

                Movie movie = new Movie(payload.get("title"), payload.get("originalTitle"),
                        toSlug(payload.get("title")), payload.get("synopsis"), Integer.parseInt(payload.get("duration")),
                        payload.get("image"), Integer.parseInt(payload.get("likes")),
                        Boolean.parseBoolean(payload.get("published")), payload.get("actorsList"));
                repository.save(movie);

            } catch (Exception e) {
                return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<String>(HttpStatus.CREATED);
        }
        return new ResponseEntity<String>(HttpStatus.FORBIDDEN);
    }

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");

    private static String toSlug(String input) {
        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
}
