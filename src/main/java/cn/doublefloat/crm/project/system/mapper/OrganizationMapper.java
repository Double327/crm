package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 10:57 下午
 */

public interface OrganizationMapper {

    List<Organization> findAll();

    Organization findById(@Param("organizationId") Long organizationId);

    int save(Organization organization);

    int update(Organization organization);

    int delete(Long id);
}
