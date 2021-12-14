package top.campus.admin.campus.domain.enitiy;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PlaceEntity {
    private Integer pkId;
    private String name;
    private String detail;
    private String latitude;
    private String longitude;
    private String picture;
    private int isDelete;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
