package com.malrang.chatservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
    private long id;
    private String roomId;
    private String message;
    public String getMessage() {
        return message != null ? message : "No Message";
    }
}
