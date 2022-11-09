package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogDto {
    private Long uuid;
    private String systemTypeId;
    private String methodParams;
}
