package dev.tedi.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//movie controller is kind of like a router in JS all the business logic goes in movieService not here
// this just routes to the right places and functions

//annotation that tells it's the rest API controller
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
//    auto instantiates
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies() {
//        you should use this so it's more standardized and it comes with response status
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    //  path variable tells you to get the variable from the url
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }
}
