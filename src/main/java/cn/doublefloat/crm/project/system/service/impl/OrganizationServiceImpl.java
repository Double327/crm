package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.Organization;
import cn.doublefloat.crm.project.system.domain.vo.OrganizationVo;
import cn.doublefloat.crm.project.system.domain.vo.ResourceVo;
import cn.doublefloat.crm.project.system.mapper.OrganizationMapper;
import cn.doublefloat.crm.project.system.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/29 4:53 下午
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;


    @Override
    public List<OrganizationVo> findAll() {
        List<OrganizationVo> vos = new ArrayList<OrganizationVo>();
        List<Organization> list = organizationMapper.findAll();
        for (Organization org : list) {
            vos.add(new OrganizationVo(org));
        }
        return buildOrganizationTree(vos);
    }

    private List<OrganizationVo> buildOrganizationTree(List<OrganizationVo> vos) {
        return vos.stream().filter(organizationVo -> organizationVo.getParentId() == null).peek(parent -> parent.setChildren(getChildrenOrganization(vos, parent.getId()))).collect(Collectors.toList());
    }

    private List<OrganizationVo> getChildrenOrganization(List<OrganizationVo> vos, Long id) {
        List<OrganizationVo> children = vos.stream().filter(organizationVo -> organizationVo.getParentId() != null && organizationVo.getParentId().equals(id)).collect(Collectors.toList());

        if (children.isEmpty()) {
            return new ArrayList<>();
        }
        for (OrganizationVo organizationVo : children) {
            organizationVo.setChildren(getChildrenOrganization(vos, organizationVo.getId()));
        }
        return children;
    }

    @Override
    public int saveOrganization(Organization organization) {
        int n = 0;
        if (organization.getId() == null) {
            n = organizationMapper.save(organization);
        } else {
            n = organizationMapper.update(organization);
        }
        return n;
    }

    @Override
    public Organization findById(Long id) {
        return organizationMapper.findById(id);
    }

    @Override
    public int delete(Long id) {
        return organizationMapper.delete(id);
    }
}
