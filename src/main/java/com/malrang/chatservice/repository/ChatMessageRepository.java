package com.malrang.chatservice.repository;

import com.malrang.chatservice.entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ChatMessageRepository extends JpaRepository<ChatMessage,Long> {


}
