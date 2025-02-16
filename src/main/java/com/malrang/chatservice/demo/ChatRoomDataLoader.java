package com.malrang.chatservice.demo;

import com.malrang.chatservice.entity.ChatRoom;
import com.malrang.chatservice.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChatRoomDataLoader {
    private final ChatRoomRepository chatRoomRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        chatRoomRepository.deleteAll();
        ChatRoom chatRoom1 = ChatRoom.builder().roomId("1").build();
        chatRoomRepository.save(chatRoom1);
    }
}
