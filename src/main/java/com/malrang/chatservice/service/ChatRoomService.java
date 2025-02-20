package com.malrang.chatservice.service;

import com.malrang.chatservice.entity.ChatRoom;
import com.malrang.chatservice.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private static final Logger logger = LoggerFactory.getLogger(ChatRoomService.class);

    public boolean existsRoom(String roomId) {
        try {
            return chatRoomRepository.existsByRoomId(roomId);
        } catch (Exception e) {
            logger.error("Error occurred while checking if room exists with ID: {}", roomId, e);
            return false;
        }
    }

    public ChatRoom findByRoomId(String roomId) {
        try {
            return chatRoomRepository.findByRoomId(roomId);
        } catch (Exception e) {
            logger.error("Error occurred while finding room with ID: {}", roomId, e);
            return null;
        }
    }
}
