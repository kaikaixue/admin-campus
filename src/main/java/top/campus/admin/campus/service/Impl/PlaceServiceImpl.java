package top.campus.admin.campus.service.Impl;

import org.springframework.stereotype.Service;
import top.campus.admin.campus.domain.Do.PlaceDo;
import top.campus.admin.campus.domain.dto.PlaceDTO;
import top.campus.admin.campus.domain.vo.PlaceVo;
import top.campus.admin.campus.mapper.PlaceMapper;
import top.campus.admin.campus.service.PlaceService;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
    public List<PlaceVo> queryPlace() {
        List<PlaceDo> queryPlaceDo = placeMapper.queryPlace();
        List<PlaceVo> list = new ArrayList<>();
        for (PlaceDo placeDos : queryPlaceDo) {
            String[] pictureArr = placeDos.getPicture().split(",");
            PlaceVo placeVo = PlaceVo.builder().id(placeDos.getPk_id())
                    .name(placeDos.getName())
                    .detail(placeDos.getDetail())
                    .picture(pictureArr)
                    .updateTime(placeDos.getUpdate_time())
                    .build();
            list.add(placeVo);
        }
        return list;
    }

    /**
     * 更新地点信息
     * @param placeDTO
     * @return
     */
    @Override
    public Integer updatePlace(PlaceDTO placeDTO) {
        Integer code = placeMapper.updatePlace(placeDTO);
        return code;
    }
}
