package top.campus.admin.campus.domain.Do;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class UserDo {
    private String pk_id;
    private String avatar;
    private String name;
    private Integer age;
    private String department;
    private String grade;
    private String dormitory;
    private String phone;
    private LocalDateTime create_time;
}
