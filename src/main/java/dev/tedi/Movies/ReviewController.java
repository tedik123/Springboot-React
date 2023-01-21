package dev.tedi.Movies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//we're still using the movies endpoint because reviews are paired with movies, but you can easily argue it should be a seperate end point
//@RequestMapping("api/v1/movies")
@RequestMapping("api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
//    convert whatever the body is to a map of string, string
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(
                reviewService.createReviewBy(payload.get("reviewBody"), payload.get("imdbId")),
                HttpStatus.CREATED);
    }

}
