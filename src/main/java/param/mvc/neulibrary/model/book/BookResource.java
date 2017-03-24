package param.mvc.neulibrary.model.book;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import param.mvc.neulibrary.model.comment.Comment;
import param.mvc.neulibrary.model.rating.Rating;

public class BookResource extends ResourceSupport {

	private String title;
	private BookStatus status;
	private List<Rating> ratings;
	private List<Comment> comments;

	public BookResource(String title, BookStatus status, List<Rating> ratings, List<Comment> comments) {
		this.title = title;
		this.status = status;
		this.ratings = ratings;
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookStatus getStatus() {
		return status;
	}

	public void setStatus(BookStatus status) {
		this.status = status;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
