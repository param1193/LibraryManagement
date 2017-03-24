package param.mvc.neulibrary.service.message;

import java.util.List;

import param.mvc.neulibrary.model.message.Message;

public interface MessageService {

	Message findById(Integer message_id);

	void saveMessage(Message message);

	List<Message> findAllMessages();

	void updateMessageStatus(Message message);

	List<Message> listAllSentMessages(Integer offset, Integer maxResults, String username);

	Long countSentMessages(String username);

	List<Message> listAllReceivedMessages(Integer offset, Integer maxResults, String username);

	Long countReceivedMessages(String username);
	
	List<Message> generateMessageThread(Message parent);
}
