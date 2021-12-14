package top.campus.admin.campus.service;

import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.domain.dto.QueryPlaceDTO;
import top.campus.admin.campus.domain.vo.PlaceListVO;
import top.campus.admin.campus.domain.vo.PlaceVo;

import java.util.List;

public interface PlaceService {
    /**
     * 查询所有地点
     * @return
     */
    PlaceListVO queryPlace(QueryPlaceDTO queryPlaceDTO);

    /**
     * 更新地点信息
     * @param placeDTO
     * @return
     */
    Integer updatePlace(PlaceDTO placeDTO);

    /**
     * 添加地点
     * @param placeDTO
     * @return
     */
    Integer addPlace(PlaceDTO placeDTO);

    /**
     * 删除地点
     * @param placeDTO
     * @return
     */
    Integer deletePlace(PlaceDTO placeDTO);
}
