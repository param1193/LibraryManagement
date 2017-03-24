package param.mvc.neulibrary.Dao.message;

import java.util.List;

import param.mvc.neulibrary.model.message.Message;

public interface MessageDao {

	Message findById(Integer message_id);

	void saveMessage(Message message);

	List<Message> findAllMessages();

	List<Message> listAllSentMessages(Integer offset, Integer maxResults, String username);

	List<Message> listAllReceivedMessages(Integer offset, Integer maxResults, String username);

	Long countReceivedMessages(String username);
	
	Long countSentMessages(String username);
}
