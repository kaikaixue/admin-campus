package top.campus.admin.campus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.result.R;
import top.campus.admin.campus.service.PlaceService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/place")
public class PlaceController {
    @Resource
    PlaceService placeService;

    /**
     * 查询所有地点
     * @return
     */
    @PostMapping("/queryPlace")
    public R queryPlace() {
        return R.ok().data("item", placeService.queryPlace());
    }

    /**
     * 更新地点信息
     * @param placeDTO
     * @return
     */
    @PostMapping("/update")
    public R updatePlace(@RequestBody PlaceDTO placeDTO) {
        return R.ok().data("code", placeService.updatePlace(placeDTO));
    }
}
