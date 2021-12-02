package top.campus.admin.campus.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PlaceVo {
    private Integer id;
    private String name;
    private String detail;
    private String[] picture;
    private LocalDateTime updateTime;
}
