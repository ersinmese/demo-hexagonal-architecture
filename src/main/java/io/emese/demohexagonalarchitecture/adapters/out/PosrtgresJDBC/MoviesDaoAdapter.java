package io.emese.demohexagonalarchitecture.adapters.out.PosrtgresJDBC;

import io.emese.demohexagonalarchitecture.adapters.out.PosrtgresJDBC.entities.MovieEntity;
import io.emese.demohexagonalarchitecture.adapters.out.PosrtgresJDBC.repositories.MoviesRepository;
import io.emese.demohexagonalarchitecture.application.dao.MovieDAO;
import io.emese.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.emese.demohexagonalarchitecture.domain.Movie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MoviesDaoAdapter implements MovieDAO {

    private final MoviesRepository moviesRepository;

    @Override
    public Optional<Movie> findMovieByTitle(String title) {

        return moviesRepository.findMovieByTitle(title);

    }

    @Override
    public List<Movie> findAllMovies() {

        return  ((List<MovieEntity>) moviesRepository.findAll())
                .stream()
                .map(movieEntity -> new Movie(
                            movieEntity.id(),
                            movieEntity.title(),
                            movieEntity.description(),
                            movieEntity.release(),
                            movieEntity.director()

                )).toList();

    }

    @Override
    public void saveMovie(NewMovieDto movie) {
        moviesRepository.save(new MovieEntity(
                null,
                movie.title(),
                movie.description(),
                movie.release(),
                movie.director(),
                null
        ));

    }

    @Override
    public void updateMovie(Movie newMovie) {

        moviesRepository.save(new MovieEntity(
                newMovie.id(),
                newMovie.title(),
                newMovie.description(),
                newMovie.release(),
                newMovie.director(),
                null
        ));



    }

    @Override
    public void deleteMovie(Movie oldMovie) {
        moviesRepository.delete(new MovieEntity(
                oldMovie.id(),
                oldMovie.title(),
                oldMovie.description(),
                oldMovie.release(),
                oldMovie.director(),
                null
        ));

    }
}
