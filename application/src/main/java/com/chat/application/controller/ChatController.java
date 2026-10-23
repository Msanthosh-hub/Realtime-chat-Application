package com.chat.application.controller;

import com.chat.application.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    // Redirect the homepage to the chat page
    @GetMapping("/")
    public String home() {
        return "redirect:/chat";
    }

    // Display the chat application
    @GetMapping("/chat")
    public String chat() {
        return "chat";
    }

    // Receive and broadcast messages in real time
    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }
}
