package com.malrang.chatservice.service;

import com.malrang.chatservice.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class KafkaConsumer {

    private final SimpMessagingTemplate template;
    @KafkaListener(topics="chatting")
    public void listenChat(ChatDto chatDto){
        log.info("Received message: {}", chatDto);

        try {
            template.convertAndSend("/chatting/topic/room/" + chatDto.getRoomId(), chatDto);
            log.info("Message sent to WebSocket");
        } catch (Exception e) {
            log.error("Error sending message to WebSocket", e);
        }
    }

}