package top.campus.admin.campus.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.campus.admin.campus.domain.dto.DistanceDTO;
import top.campus.admin.campus.domain.dto.QueryDistanceDTO;
import top.campus.admin.campus.result.RestResult;
import top.campus.admin.campus.result.RestResultBuilder;
import top.campus.admin.campus.service.DistanceService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/distance")
public class DistanceController {
    @Resource
    DistanceService distanceService;

    /**
     * 查所有路径
     * @param queryDistanceDTO
     * @return
     */
    @PostMapping("/queryDistance")
    public RestResult queryDistance(@RequestBody QueryDistanceDTO queryDistanceDTO) {
        return new RestResultBuilder<>().success(distanceService.queryDistance(queryDistanceDTO));
    }

    /**
     * 添加路径
     * @param distanceDTO
     * @return
     */
    @PostMapping("/add")
    public RestResult addDistance(@RequestBody DistanceDTO distanceDTO) {
        return new RestResultBuilder<>().success(distanceService.addDistance(distanceDTO));
    }

    /**
     * 修改路径
     * @param distanceDTO
     * @return
     */
    @PostMapping("/update")
    public RestResult updateDistance(@RequestBody DistanceDTO distanceDTO) {
        return new RestResultBuilder<>().success(distanceService.updateDistance(distanceDTO));
    }

    /**
     * 删除路径
     * @param distanceDTO
     * @return
     */
    @PostMapping("/delete")
    public RestResult deleteDistance(@RequestBody DistanceDTO distanceDTO) {
        return new RestResultBuilder<>().success(distanceService.deleteDistance(distanceDTO));
    }
}
