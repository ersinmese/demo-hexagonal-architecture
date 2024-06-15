package io.emese.demohexagonalarchitecture.application.usecases;


import io.emese.demohexagonalarchitecture.application.dao.MovieDAO;
import io.emese.demohexagonalarchitecture.application.dto.NewMovieDto;
import io.emese.demohexagonalarchitecture.domain.Movie;
import io.emese.demohexagonalarchitecture.infrastructure.exceptions.MovieAlreadyExistException;
import io.emese.demohexagonalarchitecture.infrastructure.exceptions.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class MovieUseCase {

    private final MovieDAO movieDAO;

    public String saveMovie(NewMovieDto newMovieDto) throws MovieAlreadyExistException{

        boolean isPresent =  movieDAO.findMovieByTitle(newMovieDto.title()).isPresent();
        if (isPresent) {
            throw new MovieAlreadyExistException("Movie already exist");
        }
        movieDAO.saveMovie(newMovieDto);


        return "Movie Saved.";
    }

    public List<Movie> getAllMovies(){
        return movieDAO.findAllMovies();
    }

    public String updateMovie(Movie movie) throws MovieNotFoundException{
        boolean isPresent =  movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent) {
            throw new MovieNotFoundException("Movie does not exist!");
        }

        movieDAO.updateMovie(movie);

        return "Movie updated.";
    }

    public Movie getMovieByTitle(String movieTitle){
    return movieDAO.findMovieByTitle(movieTitle).orElseThrow(
            ()-> new MovieNotFoundException("Movie does not exist!")
    );

    }

    public String deleteMovie(Movie movie){
        boolean isPresent =  movieDAO.findMovieByTitle(movie.title()).isPresent();
        if(!isPresent){
            throw new MovieNotFoundException("Movie does not exist!");
        }

        movieDAO.deleteMovie(movie);

        return "Movie deleted.";
    }

}
