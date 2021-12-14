package top.campus.admin.campus.service;

import top.campus.admin.campus.domain.dto.DistanceDTO;
import top.campus.admin.campus.domain.dto.QueryDistanceDTO;
import top.campus.admin.campus.domain.vo.DistanceListVo;

public interface DistanceService {
    /**
     * 查询所有路径
     * @param queryDistanceDTO
     * @return
     */
    DistanceListVo queryDistance(QueryDistanceDTO queryDistanceDTO);

    /**
     * 删除路径
     * @param distanceDTO
     * @return
     */
    Integer deleteDistance(DistanceDTO distanceDTO);

    /**
     * 添加路径
     * @param distanceDTO
     * @return
     */
    Integer addDistance(DistanceDTO distanceDTO);

    /**
     * 修改路径
     * @param distanceDTO
     * @return
     */
    Integer updateDistance(DistanceDTO distanceDTO);
}
