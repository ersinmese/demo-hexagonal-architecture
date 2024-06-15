package io.emese.demohexagonalarchitecture.infrastructure.exceptions;

public class MovieAlreadyExistException extends  RuntimeException{
    public  MovieAlreadyExistException(String message){
        super(message);
    }

}
