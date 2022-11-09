package liga.medical.dto;

import lombok.Data;

@Data
public class MessageDto {
    long id;
    MessageType messageType;
    String description;
}