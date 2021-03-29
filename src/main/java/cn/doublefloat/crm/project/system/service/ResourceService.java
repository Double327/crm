package cn.doublefloat.crm.project.system.service;

import cn.doublefloat.crm.project.system.domain.Resource;
import cn.doublefloat.crm.project.system.domain.vo.ResourceListVo;
import cn.doublefloat.crm.project.system.domain.vo.ResourceRightVo;
import cn.doublefloat.crm.project.system.domain.vo.ResourceVo;
import cn.doublefloat.crm.project.system.domain.vo.UserVo;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 8:00 下午
 */

public interface ResourceService {
    List<ResourceVo> findResource(UserVo userVo);

    List<ResourceListVo> findResourceList();

    int saveResource(Resource r);

    Resource findById(Long id);

    int deleteResource(Long[] ids);

    List<ResourceRightVo> findRightList(Long id);
}
