package in.microservices.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.microservices.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

    @RequestMapping("/books/{bookId}")
    public Rating getBookRating(@PathVariable("bookId") String bookId) {
        return new Rating(bookId, 4);
    }
    
    @RequestMapping("/users/{userId}")
    public List<Rating> getUserRating(@PathVariable("userId") String userId) {
    	List<Rating> ratings = Arrays.asList(
				new Rating("Book - 1", 3),
				new Rating("Book - 2", 4)
		);
		return ratings;
    }
}

