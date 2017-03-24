package param.mvc.neulibrary.Dao.rating;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import param.mvc.neulibrary.Dao.AbstractDao;
import param.mvc.neulibrary.model.rating.Rating;

@Repository("ratingDao")
public class RatingDaoImpl extends AbstractDao<Long, Rating> implements RatingDao {

	public Rating findById(Long id) {
		return getByKey(id);
	}

	public void saveRating(Rating rating) {
		save(rating);

	}

	@SuppressWarnings("unchecked")
	public List<Rating> findAllRatings() {
		Criteria criteria = createEntityCriteria();
		List<Rating> authors = (List<Rating>) criteria.list();

		return authors;
	}

	@SuppressWarnings("unchecked")
	public List<Rating> findAllRatingsByBook(Long bookId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.ilike("book_id", bookId));
		List<Rating> authors = (List<Rating>) criteria.list();

		return authors;
	}

	@SuppressWarnings("unchecked")
	public List<Rating> findAllRatingsByUser(Long userId) {
		Criteria criteria = createEntityCriteria().add(Restrictions.ilike("user_id", userId));
		List<Rating> authors = (List<Rating>) criteria.list();

		return authors;
	}
}
