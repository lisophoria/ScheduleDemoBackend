package dev.vorstu.database.entities.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ChatDto {
    Long uniqueId;
    String name;
}
