package param.mvc.neulibrary.Dao.author;

import java.util.List;

import param.mvc.neulibrary.model.author.Author;

public interface AuthorDao {
 
    Author findById(Long id);
 
    void saveAuthor(Author author);
     
    void deleteAuthorById(Long id);
    
    Author findAuthorByName(String authorName);
     
    List<Author> findAllAuthors();

    List<Author> findAuthorsByName(String authorName);
    
    List<Author> listAllAuthors(Integer offset, Integer maxResults);
    
    Long countAllAuthors();
}