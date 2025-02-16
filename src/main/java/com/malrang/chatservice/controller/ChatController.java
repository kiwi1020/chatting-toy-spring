package com.malrang.chatservice.controller;

import com.malrang.chatservice.dto.ChatDto;
import com.malrang.chatservice.service.ChatRoomService;
import com.malrang.chatservice.service.ChatService;
import com.malrang.chatservice.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ChatController {
    private final ChatRoomService chatRoomService;
    private final ChatService chatService;
    private final KafkaProducer producer;

//    @SecurityRequirement(name = "bearerAuth")
    @MessageMapping("/message")
    public void sendSocketMessage(ChatDto chatDto) {
        if (!chatRoomService.existsRoom(chatDto.getRoomId())) {
            log.error("Error finding ExitsRoom");
            return;
        }

        ChatDto savedMessage = chatService.saveChatMessage(chatDto);
        log.info("Message has been saved");
        producer.sendMessage(savedMessage);
    }
}