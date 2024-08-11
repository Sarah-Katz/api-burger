package co.simplon.burger.presentation.controller.conversation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.business.service.conversation.IConversationService;


@RestController
@CrossOrigin
public class SaveConversationController {
    private final IConversationService conversationService;

    /**
     * Dependencies injection for the Controller.
     * @param conversationService
     */
    public SaveConversationController(final IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    /**
     * Creates or updates an conversation if it already exists.
     * @param conversation the {@link ConversationDto} to be saved
     */
    @PostMapping("/conversations")
    public void saveConversation(@RequestBody final ConversationDto conversation) {
        conversationService.saveConversation(conversation);
    }
}
