package top.campus.admin.campus.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryDistanceDTO {
    private String name;
    private Integer index;
    private Integer length;
}
