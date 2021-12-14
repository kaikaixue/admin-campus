package top.campus.admin.campus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.domain.dto.QueryPlaceDTO;
import top.campus.admin.campus.result.RestResult;
import top.campus.admin.campus.result.RestResultBuilder;
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
    public RestResult queryPlace(@RequestBody QueryPlaceDTO queryPlaceDTO) {
        return new RestResultBuilder<>().success(placeService.queryPlace(queryPlaceDTO));
    }

    /**
     * 更新地点信息
     * @param placeDTO
     * @return
     */
    @PostMapping("/update")
    public RestResult updatePlace(@RequestBody PlaceDTO placeDTO) {
        return new RestResultBuilder<>().success(placeService.updatePlace(placeDTO));
    }

    /**
     * 添加地点
     * @param placeDTO
     * @return
     */
    @PostMapping("/add")
    public RestResult addPlace(@RequestBody PlaceDTO placeDTO) {
        return new RestResultBuilder<>().success(placeService.addPlace(placeDTO));
    }

    @PostMapping("/delete")
    public RestResult deletePlace(@RequestBody PlaceDTO placeDTO) {
        return new RestResultBuilder<>().success(placeService.deletePlace(placeDTO));
    }
}
