package top.campus.admin.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.campus.admin.campus.domain.Do.PlaceDo;
import top.campus.admin.campus.domain.dto.PlaceDTO;

import java.util.List;


@Mapper
public interface PlaceMapper {
    /**
     * 查询所有地点
     * @return
     */
    List<PlaceDo> queryPlace();

    /**
     * 更新地点信息
     * @param placeDTO
     */
    Integer updatePlace(PlaceDTO placeDTO);
}
