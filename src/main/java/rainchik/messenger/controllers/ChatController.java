package rainchik.messenger.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import rainchik.messenger.Message;
import rainchik.messenger.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), /*message.getText*/"Pong", time);
    }
}
