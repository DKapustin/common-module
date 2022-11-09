package medical.common.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Exception {
    @Id
    private long uuid;

    private long systemTypeId;

    private String methodParams;
}
