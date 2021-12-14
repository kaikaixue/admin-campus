package top.campus.admin.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.campus.admin.campus.domain.Do.PlaceDo;
import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.domain.dto.QueryPlaceDTO;
import top.campus.admin.campus.domain.enitiy.PlaceEntity;

import java.util.List;


@Mapper
public interface PlaceMapper {
    /**
     * 查询所有地点
     * @return
     */
    List<PlaceDo> queryPlace(QueryPlaceDTO queryPlaceDTO);

    /**
     * 查询数量
     * @param queryPlaceDTO
     * @return
     */
    Integer count(QueryPlaceDTO queryPlaceDTO);

    /**
     * 更新地点信息
     * @param placeDTO
     */
    Integer updatePlace(PlaceDTO placeDTO);

    /**
     * 添加地点
     * @param placeEntity
     * @return
     */
    Integer addPlace(PlaceEntity placeEntity);

    /**
     * 删除地点
     * @param placeEntity
     * @return
     */
    Integer deletePlace(PlaceEntity placeEntity);
}
