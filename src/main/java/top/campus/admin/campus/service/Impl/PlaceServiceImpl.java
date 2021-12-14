package top.campus.admin.campus.service.Impl;

import org.springframework.stereotype.Service;
import top.campus.admin.campus.domain.Do.PlaceDo;
import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.domain.dto.QueryPlaceDTO;
import top.campus.admin.campus.domain.enitiy.PlaceEntity;
import top.campus.admin.campus.domain.vo.PlaceListVO;
import top.campus.admin.campus.domain.vo.PlaceVo;
import top.campus.admin.campus.mapper.PlaceMapper;
import top.campus.admin.campus.service.PlaceService;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Resource
    PlaceMapper placeMapper;

    /**
     * 查所有地点
     * @return
     */
    @Override
    public PlaceListVO queryPlace(QueryPlaceDTO queryPlaceDTO) {
        QueryPlaceDTO queryPlaceDTO1 = QueryPlaceDTO.builder()
                .name(queryPlaceDTO.getName())
                .index(queryPlaceDTO.getIndex() * queryPlaceDTO.getLength())
                .length(queryPlaceDTO.getLength())
                .build();
        List<PlaceDo> queryPlaceDo = placeMapper.queryPlace(queryPlaceDTO1);
        List<PlaceVo> list = new ArrayList<>();
        for (PlaceDo placeDos : queryPlaceDo) {
            String[] pictureArr = placeDos.getPicture().split(",");
            PlaceVo placeVo = PlaceVo.builder()
                    .id(placeDos.getPk_id())
                    .name(placeDos.getName())
                    .detail(placeDos.getDetail())
                    .picture(pictureArr)
                    .updateTime(placeDos.getUpdate_time())
                    .longitude(placeDos.getLongitude())
                    .latitude(placeDos.getLatitude())
                    .build();
            list.add(placeVo);
        }
        PlaceListVO placeListVO = PlaceListVO.builder()
                .list(list)
                .total(placeMapper.count(queryPlaceDTO1))
                .build();
        return placeListVO;
    }

    /**
     * 添加地点
     * @param placeDTO
     * @return
     */
    @Override
    public Integer addPlace(PlaceDTO placeDTO) {
        PlaceEntity placeEntity = PlaceEntity.builder()
                .pkId(placeDTO.getId())
                .name(placeDTO.getName())
                .detail(placeDTO.getDetail())
                .latitude(placeDTO.getLatitude())
                .longitude(placeDTO.getLongitude())
                .picture(placeDTO.getPicture())
                .isDelete(0)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        Integer code = placeMapper.addPlace(placeEntity);
        return code;
    }

    /**
     * 更新地点信息
     * @param placeDTO
     * @return
     */
    @Override
    public Integer updatePlace(PlaceDTO placeDTO) {
//        PlaceEntity placeEntity = PlaceEntity.builder()
//                .pkId(placeDTO.getId())
//                .name(placeDTO.getName())
//                .detail(placeDTO.getDetail())
//                .latitude(placeDTO.getLatitude())
//                .longitude(placeDTO.getLongitude())
//                .picture(placeDTO.getPicture())
//                .isDelete(0)
//                .createTime(LocalDateTime.now())
//                .updateTime(LocalDateTime.now())
//                .build();
        Integer code = placeMapper.updatePlace(placeDTO);
        return code;
    }

    /**
     * 删除地点
     * @param placeDTO
     * @return
     */
    @Override
    public Integer deletePlace(PlaceDTO placeDTO) {
        PlaceEntity placeEntity = PlaceEntity.builder()
                .pkId(placeDTO.getId())
                .build();
        Integer code = placeMapper.deletePlace(placeEntity);
        return code;
    }
}
