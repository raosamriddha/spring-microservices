package in.microservices.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import in.microservices.model.Book;
import in.microservices.model.CatalogItem;
import in.microservices.model.Rating;

@RestController
@RequestMapping("/catalog")
public class BookCatalogResource {

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		RestTemplate restTemplate  = new RestTemplate();
		Book response = restTemplate.getForObject("http://localhost:books/bookId", Book.class);
		List<Rating> ratings = Arrays.asList(
				new Rating("Book - 1", 3),
				new Rating("Book - 2", 4)
		);
		
		return ratings.stream().map(rating -> new CatalogItem("Java - Complete reference", "Java resource", 4))
				.collect(Collectors.toList());
		}
		
}
