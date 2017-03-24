package param.mvc.neulibrary.service.rating;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import param.mvc.neulibrary.model.rating.Rating;

public interface RatingService {

	List<Rating> findAllRatings();

	@PreAuthorize("hasAuthority('USER')")
	void saveRating(Rating rating);

	@PreAuthorize("hasAuthority('ADMIN')")
	List<Rating> findAllRatingsByBook(Long bookId);

	@PreAuthorize("hasAuthority('ADMIN')")
	List<Rating> findAllRatingsByUser(Long userId);
}
