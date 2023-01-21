package dev.tedi.Movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection="movies")
@Data // this takes care of all the getters and setters methods
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id // tells you it's unique identifier
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
//    this is fine if you want it to be paired to the movie one-to many relationship
//    private List<Review> reviewIds;
//    if you want references so it's seperated you need the decorator
    @DocumentReference
    private List<Review> reviewIds;

}
