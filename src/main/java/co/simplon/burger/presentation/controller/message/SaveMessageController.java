package co.simplon.burger.presentation.controller.message;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.MessageDto;
import co.simplon.burger.business.service.message.IMessageService;

@RestController
@CrossOrigin
public class SaveMessageController {
    private final IMessageService messageService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param messageService
     */
    public SaveMessageController(final IMessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Creates or updates an message if it already exists.
     * 
     * @param message the {@link MessageDto} to be saved
     */
    @PostMapping("/messages")
    public void saveMessage(@RequestBody final MessageDto message) {
        messageService.saveMessage(message);
    }
}
