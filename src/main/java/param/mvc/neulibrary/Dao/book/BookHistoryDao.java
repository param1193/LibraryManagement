package param.mvc.neulibrary.Dao.book;

import java.util.List;

import param.mvc.neulibrary.model.book.BookHistory;

public interface BookHistoryDao {
	
	BookHistory findById(Long id);

	void saveBookHistory(BookHistory bookHistory);
	
	List<BookHistory> findAllBooksHistory();	

	List<BookHistory> findAllBooksHistory(Integer offset, Integer maxResults, String username); 
	
	List<BookHistory> findAllBooksHistory(Integer offset, Integer maxResults, byte isReturned);
	
	Long countAllBooksHistory(String username);
	
	Long countAllBooksHistory(byte isReturned);
} 
