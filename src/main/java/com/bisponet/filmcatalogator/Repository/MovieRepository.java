package com.bisponet.filmcatalogator.Repository;

import com.bisponet.filmcatalogator.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String>{

    Movie findByTitle(String title);
    Movie findBySlug(String slug);

}
