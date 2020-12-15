package in.microservices.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.microservices.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @RequestMapping("/books/{bookId}")
    public Rating getMovieRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 4);
    }
}

