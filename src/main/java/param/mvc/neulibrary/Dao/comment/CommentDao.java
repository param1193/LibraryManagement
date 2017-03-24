package param.mvc.neulibrary.Dao.comment;

import java.util.List;

import param.mvc.neulibrary.model.comment.Comment;

public interface CommentDao {
	
	Comment findById(Integer comment_id);
	
	void saveComment(Comment comment);
	
	void deleteCommentById(Integer comment_id);
	
	List<Comment> findAllComments();
}
