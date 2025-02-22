package com.malrang.chatservice.entity;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@RequiredArgsConstructor
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "chatRoom_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ChatRoom chatRoom;

    @Builder
    public ChatMessage(String message, ChatRoom chatRoom) {
        this.message = message;
        this.chatRoom = chatRoom;
    }
}
