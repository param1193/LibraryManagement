package param.mvc.neulibrary.Dao.rating;

import java.util.List;

import param.mvc.neulibrary.model.rating.Rating;

public interface RatingDao {

	Rating findById(Long id);

	void saveRating(Rating rating);

	List<Rating> findAllRatings();
	
	List<Rating> findAllRatingsByBook(Long bookId);
	
	List<Rating> findAllRatingsByUser(Long userId);
}
