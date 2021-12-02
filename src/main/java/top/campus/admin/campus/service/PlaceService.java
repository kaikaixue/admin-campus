package top.campus.admin.campus.service;

import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.domain.vo.PlaceVo;

import java.util.List;

public interface PlaceService {
    /**
     * 查询所有地点
     * @return
     */
    List<PlaceVo> queryPlace();

    /**
     * 更新地点信息
     * @param placeDTO
     * @return
     */
    Integer updatePlace(PlaceDTO placeDTO);
}
