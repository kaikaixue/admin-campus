package top.campus.admin.campus.domain.enitiy;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DistanceEntity {
    private Integer pkId;
    private Integer primaryAddress;
    private Integer targetAddress;
    private Integer value;
    private Integer isDelete;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
