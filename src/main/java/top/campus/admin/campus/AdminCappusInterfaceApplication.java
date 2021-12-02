package top.campus.admin.campus;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("top.campus.admin.campus.mapper")
public class AdminCappusInterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminCappusInterfaceApplication.class, args);
    }

}
