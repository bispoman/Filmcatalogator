package com.bisponet.filmcatalogator.Service;

import com.bisponet.filmcatalogator.Model.Movie;
import com.bisponet.filmcatalogator.Repository.MovieRepository;
import com.bisponet.filmcatalogator.Util.ServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FilmesService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Optional<Movie> getMoviesById(String id) {
        return repository.findById(id);
    }

    public Movie getMovieBySlug(String slug) {
        return repository.findBySlug(slug);
    }

    public ResponseEntity<?> saveNewMovie(String user, String password, Map<String, String> payload){

        if (user.equals("usertest") && password.equals("passtest")) {
            try {

                Movie movie = new Movie(payload.get("title"), payload.get("originalTitle"),
                        ServiceUtil.toSlug(payload.get("title")), payload.get("synopsis"), Integer.parseInt(payload.get("duration")),
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

}
