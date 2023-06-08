package edu.pk.projektProgramowanieObiektowe.service;

import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;

import java.util.List;

import edu.pk.projektProgramowanieObiektowe.model.entity.MovieEntity;
import edu.pk.projektProgramowanieObiektowe.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    public MovieEntity getMovieById(Long id) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(id);
        return movieOptional.orElse(null);
    }

    public MovieEntity addMovie(MovieEntity movieEntity) {
        return movieRepository.save(movieEntity);
    }

    public MovieEntity updateMovie(Long id, MovieEntity movieEntity) {
        Optional<MovieEntity> existingMovieOptional = movieRepository.findById(id);
        if (existingMovieOptional.isPresent()) {
            MovieEntity existingMovie = existingMovieOptional.get();
            existingMovie.setTitle(movieEntity.getTitle());
            existingMovie.setDuration(movieEntity.getDuration());
            existingMovie.setDescription(movieEntity.getDescription());
            existingMovie.setGenre(movieEntity.getGenre());
            existingMovie.setDirector(movieEntity.getDirector());
            existingMovie.setActors(movieEntity.getActors());
            return movieRepository.save(existingMovie);
        }
        return null; // or throw an exception indicating that movie with given id was not found
    }

    public boolean deleteMovie(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
