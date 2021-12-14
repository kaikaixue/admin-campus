package top.campus.admin.campus.service.Impl;

import org.springframework.stereotype.Service;
import top.campus.admin.campus.domain.Do.DistanceDo;
import top.campus.admin.campus.domain.dto.DistanceDTO;
import top.campus.admin.campus.domain.dto.QueryDistanceDTO;
import top.campus.admin.campus.domain.dto.QueryPlaceDTO;
import top.campus.admin.campus.domain.enitiy.DistanceEntity;
import top.campus.admin.campus.domain.vo.DistanceListVo;
import top.campus.admin.campus.domain.vo.PlaceListVO;
import top.campus.admin.campus.mapper.DistanceMapper;
import top.campus.admin.campus.service.DistanceService;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DistanceServiceImpl implements DistanceService {
    @Resource
    DistanceMapper distanceMapper;

    /**
     * 查所有路径
     * @param queryDistanceDTO
     * @return
     */
    @Override
    public DistanceListVo queryDistance(QueryDistanceDTO queryDistanceDTO) {
        QueryDistanceDTO queryDistanceDTO1 = QueryDistanceDTO.builder()
                .name(queryDistanceDTO.getName())
                .index(queryDistanceDTO.getIndex() * queryDistanceDTO.getLength())
                .length(queryDistanceDTO.getLength())
                .build();
        List<DistanceDo> list = distanceMapper.queryDistance(queryDistanceDTO1);
        DistanceListVo distanceListVo = DistanceListVo.builder()
                .total(distanceMapper.count(queryDistanceDTO1))
                .list(list)
                .build();
        return distanceListVo;
    }

    /**
     * 删除路径
     * @param distanceDTO
     * @return
     */
    @Override
    public Integer deleteDistance(DistanceDTO distanceDTO) {
        DistanceEntity distanceEntity = DistanceEntity.builder()
                .pkId(distanceDTO.getId())
                .build();
        Integer code = distanceMapper.deleteDistance(distanceEntity);
        return code;
    }

    /**
     * 添加路径
     * @param distanceDTO
     * @return
     */
    @Override
    public Integer addDistance(DistanceDTO distanceDTO) {
        DistanceEntity distanceEntity = DistanceEntity.builder()
                .primaryAddress(distanceDTO.getPrimaryId())
                .targetAddress(distanceDTO.getTargetId())
                .value(distanceDTO.getValue())
                .isDelete(0)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        Integer code = distanceMapper.addDistance(distanceEntity);
        return code;
    }

    /**
     * 修改路径
     * @param distanceDTO
     * @return
     */
    @Override
    public Integer updateDistance(DistanceDTO distanceDTO) {
        Integer code = distanceMapper.updateDistance(distanceDTO);
        return code;
    }
}
