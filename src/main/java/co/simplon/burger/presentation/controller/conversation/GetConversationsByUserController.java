package co.simplon.burger.presentation.controller.conversation;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.burger.business.dto.ConversationDto;
import co.simplon.burger.business.dto.UserDto;
import co.simplon.burger.business.service.conversation.IConversationService;

@RestController
@CrossOrigin
public class GetConversationsByUserController {
    private final IConversationService conversationService;

    /**
     * Dependencies injection for the Controller.
     * 
     * @param conversationService
     */
    public GetConversationsByUserController(final IConversationService conversationService) {
        this.conversationService = conversationService;
    }

    /**
     * Returns all conversations for a specific vendor.
     * 
     * @param user the {@link UserDto} who owns the conversations
     */
    @GetMapping("/conversations/byUser")
    public List<ConversationDto> getConversationsByUser(@RequestBody final UserDto user) {
        return conversationService.findByUser(user);
    }
}
