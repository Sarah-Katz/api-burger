package co.simplon.burger.business.service.message;

import org.springframework.stereotype.Service;

import co.simplon.burger.business.convert.MessageConvert;
import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.persistance.repository.message.IMessageRepository;

@Service
public class MessageServiceImpl implements IMessageService  {
    private IMessageRepository messageRepository;

    /**
     * Injects the required dependencies to the service.
     * @param messageRepository
     */
    public MessageServiceImpl(final IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveMessage(final MessageDto message) {
        messageRepository.save(MessageConvert.getInstance().toEntity(message));
    }
}
