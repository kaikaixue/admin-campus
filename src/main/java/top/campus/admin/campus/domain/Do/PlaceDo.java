package top.campus.admin.campus.domain.Do;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class PlaceDo {
    private Integer pk_id;
    private String name;
    private String detail;
    private String picture;
    private LocalDateTime update_time;
}
