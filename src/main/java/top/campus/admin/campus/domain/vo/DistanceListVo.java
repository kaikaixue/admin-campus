package top.campus.admin.campus.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DistanceListVo {
    private Integer total;
    private List list;
}
