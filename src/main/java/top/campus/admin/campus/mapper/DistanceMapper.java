package top.campus.admin.campus.mapper;

import org.apache.ibatis.annotations.Mapper;
import top.campus.admin.campus.domain.Do.DistanceDo;
import top.campus.admin.campus.domain.dto.DistanceDTO;
import top.campus.admin.campus.domain.dto.QueryDistanceDTO;
import top.campus.admin.campus.domain.dto.QueryPlaceDTO;
import top.campus.admin.campus.domain.enitiy.DistanceEntity;

import java.util.List;

@Mapper
public interface DistanceMapper {
    /**
     * 查询所有路径
     * @param queryDistanceDTO
     * @return
     */
    List<DistanceDo> queryDistance(QueryDistanceDTO queryDistanceDTO);

    /**
     * 查询数量
     * @param queryDistanceDTO
     * @return
     */
    Integer count(QueryDistanceDTO queryDistanceDTO);

    /**
     * 添加路径
     * @param distanceEntity
     * @return
     */
    Integer addDistance(DistanceEntity distanceEntity);

    /**
     * 修改路径
     * @param distanceDTO
     * @return
     */
    Integer updateDistance(DistanceDTO distanceDTO);

    /**
     * 删除路径
     * @param distanceEntity
     * @return
     */
    Integer deleteDistance(DistanceEntity distanceEntity);
}
