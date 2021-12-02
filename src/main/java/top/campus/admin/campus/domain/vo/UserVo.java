package top.campus.admin.campus.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class UserVo {
    private String userId;
    private String avatar;
    private String name;
    private Integer age;
    private String department;
    private String grade;
    private String dormitory;
    private String phone;
    private LocalDateTime createTime;
}
