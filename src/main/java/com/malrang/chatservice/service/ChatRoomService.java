package com.malrang.chatservice.service;

import com.malrang.chatservice.entity.ChatRoom;
import com.malrang.chatservice.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    public boolean existsRoom(String roomId) {
        return chatRoomRepository.existsByRoomId(roomId);
    }

    public ChatRoom findByRoomId(String roomId) {
        return chatRoomRepository.findByRoomId(roomId);
    }
}
