package com.bisponet.filmcatalogator.Repository;

import com.bisponet.filmcatalogator.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MovieRepository extends MongoRepository<Movie, String>{

    public Movie findByTitle(String title);
    public Movie findBySlug(String slug);
    public List<Movie> getOrderBy(String orderedField);

}
