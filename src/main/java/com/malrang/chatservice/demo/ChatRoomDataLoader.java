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
        try {
            if (!chatRoomRepository.existsByRoomId("1")) {
                ChatRoom chatRoom1 = ChatRoom.builder().roomId("1").build();
                chatRoomRepository.save(chatRoom1);
            }
        } catch (Exception e) {
            System.err.println("채팅방 데이터 로드 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
