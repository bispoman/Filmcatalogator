package com.bisponet.filmcatalogator;

import com.bisponet.filmcatalogator.Model.Movie;
import com.bisponet.filmcatalogator.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmcatalogatorApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(FilmcatalogatorApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		String genericSynopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse finibus at lectus eget mattis. Morbi dapibus porta velit. Cras congue diam at enim egestas bibendum. Praesent malesuada feugiat molestie. Maecenas at mattis quam, ut pretium nunc. Nam venenatis turpis nibh. Morbi neque leo, scelerisque finibus sem nec, dignissim lobortis odio. Sed tincidunt tortor a tortor rhoncus rutrum. Sed rutrum vitae felis a placerat. Vivamus posuere urna velit, at tristique lacus bibendum sed. Cras est quam, dignissim non diam sit amet, porta porttitor lorem. Maecenas vitae lectus eget nulla malesuada eleifend. Quisque aliquam, quam ac pretium venenatis, lorem felis dictum augue, non eleifend leo justo convallis leo. Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
		String genericPlaceholder = "https://placeimg.com/200/300/any";

		repository.save(new Movie("Duro de matar", "Die Hard", "duro-de-matar", genericSynopsis, 7245, genericPlaceholder, 30, true, "Bruce Willis, Alan Rickman"));
		repository.save(new Movie("E o vento levou", "Gone with the wind", "e-o-vento-levou", genericSynopsis, 8445, genericPlaceholder, 15, true, "Clark Gable, Vivien Leigh, Thomas Mitchell"));
		repository.save(new Movie("Cidadão Kane", "Citizen Kane", "cidadao-kane", genericSynopsis, 9245, genericPlaceholder, 55, true, "Orson Welles, Joseph Cotten, Dorothy Comingore"));
		repository.save(new Movie("Jamaica abaixo de zero", "Cool Runnings", "jamaica-abaixo-de-zero", genericSynopsis, 6754, genericPlaceholder, 8, true, "John Candy, Leon, Doug E. Doug"));
		repository.save(new Movie("Jurassic Park: Parque dos Dinossauros", "Jurassic Park", "jurassic-park-o-parque-dos-dinossauros", genericSynopsis, 6123, genericPlaceholder, 7, false, "Sam Neill, Laura Dern, Jeff Goldblum"));
		repository.save(new Movie("Thelma", "Thelma", "thelma", genericSynopsis, 8213, genericPlaceholder, 12, true, "Eili Harboe, Kaya Wilkins, Henrik Rafaelsen"));
		repository.save(new Movie("E.T. – O Extraterrestre", "E.T. the Extra-Terrestrial", "et-o-extraterrestre", genericSynopsis, 7488, genericPlaceholder, 1, false, "Henry Thomas, Drew Barrymore, Peter Coyote"));
		repository.save(new Movie("A Grande Arte", "A Grande Arte", "a-grande-arte", genericSynopsis, 7002, genericPlaceholder, 245, true, "Peter Coyote, Tchéky Karyo, Amanda Pays"));

	}

}
