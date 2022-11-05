package dev.vorstu.database.entities.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MessageDto {
    String content;
    String user;
    Long chat;
}
