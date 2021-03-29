package cn.doublefloat.crm.project.system.service;

import cn.doublefloat.crm.project.system.domain.Organization;
import cn.doublefloat.crm.project.system.domain.vo.OrganizationVo;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/29 4:50 下午
 */

public interface OrganizationService {
    List<OrganizationVo> findAll();

    int saveOrganization(Organization organization);

    Organization findById(Long id);

    int delete(Long id);
}
