package top.campus.admin.campus.domain.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class PlaceListVO {
    private Integer total;
    private List list;
}
