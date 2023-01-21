package dev.tedi.Movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//so you know it's a respository
@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

}
