package co.simplon.burger.presentation.controller.conversation;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.service.conversation.IConversationService;

@RestController

@CrossOrigin
public class AddMessageController {
    private final IConversationService conversationService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param conversationService
     */
    public AddMessageController(IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping("conversations/messages")
    public void addMessage(@RequestBody final Map<String, String> json) {
        //TODO: Refactor this implementation because it's dumb
    }
}
