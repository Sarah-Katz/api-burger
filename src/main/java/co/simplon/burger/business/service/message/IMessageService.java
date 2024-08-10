package co.simplon.burger.business.service.message;

import co.simplon.burger.business.dto.MessageDto;

public interface IMessageService {
    /**
     * Creates or updates a message if it exists.
     * @param message the message to be saved.
     */
    public void saveMessage(final MessageDto message);
}
