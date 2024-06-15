package io.emese.demohexagonalarchitecture.application.dao;

import java.util.List;
import java.util.Optional;

import io.emese.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.emese.demohexagonalarchitecture.domain.Movie;

public interface MovieDAO {
    Optional<Movie> findMovieByTitle(String title);
    List<Movie> findAllMovies();
    void saveMovie(NewMovieDto movie);
    void updateMovie(Movie newMovie);
    void deleteMovie(Movie oldMovie);
}
