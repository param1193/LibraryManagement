package param.mvc.neulibrary.model.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import param.mvc.neulibrary.model.book.Book;
import param.mvc.neulibrary.model.user.User;

@Entity
@Table(name = "comments")
public class Comment {

	@Id
	@Column(name = "comment_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer comment_id;

	@Size(min = 2, max = 200)
	@Column(name = "comment", nullable = false)
	private String comment;

	@ManyToOne
	@JoinColumn(name = "book_id")
	@JsonBackReference(value = "book-comments")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference(value = "user-comments")
	private User user;

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
