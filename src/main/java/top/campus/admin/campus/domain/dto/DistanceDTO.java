package top.campus.admin.campus.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistanceDTO {
    private Integer id;
    private Integer primaryId;
    private Integer targetId;
    private Integer value;
}
