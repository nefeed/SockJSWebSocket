package com.gavin.controller;

import com.gavin.entity.WebSocketMessage;
import com.gavin.response.WebSocketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * User: Gavin
 * E-mail: GavinChangCN@163.com
 * Desc:
 * Date: 2017-03-06
 * Time: 11:01
 */
@Controller
public class WebSocketController {
    protected static final String TAG = "WebsocketController";

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private String mContent = "";

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public WebSocketResponse say(WebSocketMessage message) throws Exception {
        mContent += "Welcome, " + message.getName() + "!";
        Thread.sleep(500);
        return new WebSocketResponse(mContent);

    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if ("huajun".equals(principal.getName())){
            messagingTemplate.convertAndSendToUser("gavin", "/queue/notifications", principal.getName() + "-send:" + msg);
        } else {
            messagingTemplate.convertAndSendToUser("huajun", "/queue/notifications", principal.getName() + "-send:" + msg);
        }
    }


}
