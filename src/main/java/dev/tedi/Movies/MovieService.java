package dev.tedi.Movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
//        this is a builtin mongodb function that as the name suggest returns all the movies
        return movieRepository.findAll();
    }


//    it may return null hence the optional movie
    public Optional<Movie> singleMovie(ObjectId id) {
        return movieRepository.findById(id);
    }
}
