package io.emese.demohexagonalarchitecture.application.dto;


import java.time.LocalDate;

public record NewMovieDto(

        String title,
        String description,
        LocalDate release,
        String director) {


}
