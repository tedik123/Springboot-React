package dev.tedi.Movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//so you know it's a repository
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
//    just by implementing this springboot can automatically interpret what you want to do
//    the findMovieByPROPERTYNAME is how it knows what it's searching for
    Optional<Movie> findMovieByImdbId(String imdbId);


}
