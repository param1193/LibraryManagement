package param.mvc.neulibrary.service.comment;

import java.util.List;

import param.mvc.neulibrary.model.comment.Comment;

public interface CommentService {

	Comment findById(Integer comment_id);

	void saveComment(Comment comment);

	void deleteCommentById(Integer comment_id);

	List<Comment> findAllComments();
}
