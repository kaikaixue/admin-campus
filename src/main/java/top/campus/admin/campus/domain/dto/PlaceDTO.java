package top.campus.admin.campus.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceDTO {
    private Integer id;
    private String name;
    private String detail;
    private String picture;
    private String longitude;
    private String latitude;
}
