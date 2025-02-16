package com.malrang.chatservice.repository;

import com.malrang.chatservice.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoom,Long> {
    boolean existsByRoomId(String roomId);
    ChatRoom findByRoomId(String roomId);
}
