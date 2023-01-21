package dev.tedi.Movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    //    we want to find the movie first so we can match the review to it
    public Review createReviewBy(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));
//        we created the review time to add it to the movies
//        first in the movie collection find the matching movie where imdbId=imdbId
//        then update the reviews by adding a new review ID since it's a reference
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId")
                        .is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
//                you need first since it's a list and you just want the matching one
                .first();
        return review;
    }
}
