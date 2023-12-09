package com.app.webchat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {

    @MessageMapping("/web-chat")
    @SendTo("/topic/messages")
    public Message greet(Message message) throws Exception {
        return new Message(message.getUserName(), HtmlUtils.htmlEscape(message.getContent()));
    }
}