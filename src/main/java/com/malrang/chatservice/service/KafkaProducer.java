package com.malrang.chatservice.service;

import com.malrang.chatservice.dto.ChatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "chatting";
    private final KafkaTemplate<String, ChatDto> kafkaTemplate;

    public void sendMessage(ChatDto message) {

        CompletableFuture<SendResult<String, ChatDto>> future = kafkaTemplate.send(TOPIC, message);
        future.thenAccept(result -> {
            System.out.println("Message sent successfully: " + result.getRecordMetadata());
        }).exceptionally(ex -> {
            System.err.println("Failed to send message: " + ex.getMessage());
            return null;
        });
        log.info("Produce message: {}", message);
    }
}
