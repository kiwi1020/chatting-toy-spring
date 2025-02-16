package com.malrang.chatservice.service;

import com.malrang.chatservice.dto.ChatDto;
import com.malrang.chatservice.entity.ChatMessage;
import com.malrang.chatservice.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;
    public ChatDto saveChatMessage(ChatDto chatDto) {
        ChatMessage chatMessage = ChatMessage.builder()
                .message(chatDto.getMessage())
                .chatRoom(chatRoomService.findByRoomId(chatDto.getRoomId()))
                .build();
        chatMessageRepository.save(chatMessage);

        return chatDto;
    }
}
