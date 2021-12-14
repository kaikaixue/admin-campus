package top.campus.admin.campus.domain.Do;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DistanceDo {
    private Integer id;
    private String primaryName;
    private String targetName;
    private double value;
}
