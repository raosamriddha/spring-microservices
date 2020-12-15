package in.microservices.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
		
		
		
		List<Rating> ratings = Arrays.asList(
				new Rating("Book - 1", 3),
				new Rating("Book - 2", 4)
		);
		
		return ratings.stream().map(rating -> {
			Book response = restTemplate.getForObject("http://localhost:8001/books/" + rating.getBookId(), Book.class);	
			return new CatalogItem(response.getName(), "Java resource", rating.getRating());
		
		})
		.collect(Collectors.toList());
		
	}
		
}
