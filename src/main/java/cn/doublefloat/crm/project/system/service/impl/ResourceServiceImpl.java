package cn.doublefloat.crm.project.system.service.impl;

import cn.doublefloat.crm.project.system.domain.Resource;
import cn.doublefloat.crm.project.system.domain.vo.*;
import cn.doublefloat.crm.project.system.mapper.ResourceMapper;
import cn.doublefloat.crm.project.system.mapper.RoleResourceMapper;
import cn.doublefloat.crm.project.system.service.ResourceService;
import org.apache.ibatis.jdbc.Null;
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
 * @date 2021/3/26 8:15 下午
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<ResourceVo> findResource(UserVo userVo) {
        List<ResourceVo> resourceVos = new ArrayList<>();
        List<Long> roleIds = userVo.getRoleIds();
        // 角色为空
        if (roleIds == null || roleIds.size() == 0) {
            return resourceVos;
        } else if (userVo.getAdmin()) {
            List<Resource> resourceList = resourceMapper.findResource(0);
            for (Resource resource : resourceList) {
                ResourceVo resourceVo = new ResourceVo(resource);
                resourceVos.add(resourceVo);
            }
            return buildResourceTree(resourceVos);
        } else {
            // 获取多个角色对应的资源ID
            List<Long> resourceIds = roleResourceMapper.batchFindResourceId(roleIds);

            // 获取资源的父类资源
            List<Resource> parentResources = resourceMapper.batchFindParentByResourceId(resourceIds);
            List<Long> parentResourceIds = new ArrayList<>();
            for (Resource parentResource : parentResources) {
                parentResourceIds.add(parentResource.getId());
            }
            List<Resource> resourceList = resourceMapper.batchFindParentByResourceId(parentResourceIds);
            parentResources.addAll(resourceList);
            for (Resource resource : parentResources) {
                ResourceVo resourceVo = new ResourceVo(resource);
                resourceVos.add(resourceVo);
            }
            return buildResourceTree(resourceVos);
        }
    }

    public List<ResourceVo> buildResourceTree(List<ResourceVo> resourceVoList) {
        if (resourceVoList.isEmpty()) {
            return new ArrayList<>();
        }
        return resourceVoList.stream()
                .filter((e) -> {
                    return e.getParentId() == null;
                })
                .peek(parent -> parent.setChildren(getChildrenResource(resourceVoList, parent.getId())))
                .collect(Collectors.toList());
    }

    private List<ResourceVo> getChildrenResource(List<ResourceVo> resourceVoList, Long id) {
        List<ResourceVo> children = resourceVoList.stream().filter((e) -> {
            return e.getParentId() != null && e.getParentId().equals(id);
        }).collect(Collectors.toList());
        if (children.isEmpty()) {
            return new ArrayList<>();
        }
        for (ResourceVo menu : children) {
            menu.setChildren(getChildrenResource(resourceVoList, menu.getId()));
        }
        return children;
    }

    @Override
    public List<ResourceListVo> findResourceList() {
        List<Resource> resourceList = resourceMapper.findResource(null);
        //主菜单
        List<ResourceListVo> mainList = new ArrayList<>();
        //子菜单
        List<ResourceListVo> subList = new ArrayList<>();
        //功能菜单
        List<ResourceListVo> funcList = new ArrayList<>();
        for (Resource resource : resourceList) {
            if (resource.getParentId() == null) {
                mainList.add(new ResourceListVo(resource));
            } else if (resource.getResourceType() == 0) {
                subList.add(new ResourceListVo(resource));
            } else {
                funcList.add(new ResourceListVo(resource));
            }
        }
        parseParentAndChildren(subList, funcList);
        parseParentAndChildren(mainList, subList);
        return null;
    }

    @Override
    public int saveResource(Resource r) {
        int res = 0;
        if (r.getId() == null) {
            r.setDescription(r.getName());
            r.setCreateTime(new Date());
            res = resourceMapper.saveResource(r);
        } else {
            res = resourceMapper.editResource(r);
        }
        return res;
    }

    @Override
    public Resource findById(Long id) {
        return resourceMapper.findResourceById(id);
    }

    @Override
    public int deleteResource(Long[] ids) {
        List<Long> idList = new ArrayList<>();
        for (Long id : ids) {
            List<Long> childrenResourceId = resourceMapper.findChildrenResourceId(id);
            if (childrenResourceId.size() > 0) {
                idList = parseResourceIsContains(idList, childrenResourceId);
            }
        }
        return resourceMapper.batchRemoveResource(idList);
    }

    private List<Long> parseResourceIsContains(List<Long> idList, List<Long> childrenMenuIds) {
        for (Long child : childrenMenuIds) {
            if (!idList.contains(child)) {
                idList.add(child);
            }
        }
        return idList;
    }

    @Override
    public List<ResourceRightVo> findRightList(Long id) {
        List<Resource> resourceList = resourceMapper.findResource(null);
        // 主菜单
        List<ResourceRightVo> mainList = new ArrayList<>();
        // 功能菜单
        List<RightChildVo> funcList = new ArrayList<>();
        // 分类别
        for (Resource resource : resourceList) {
            //主菜单.子菜单
            if (resource.getParentId() == null || resource.getResourceType() == 0) {
                mainList.add(new ResourceRightVo(resource));
            } else {
                //功能菜单
                funcList.add(new RightChildVo(resource));
            }
        }
        //根据角色ID查询具有权限的菜单IDs
        List<Long> menuIds = resourceMapper.findResourceIds(id);
        parseRightParentAndChildren(mainList, funcList, menuIds);
        return mainList;
    }

    private void parseParentAndChildren(List<ResourceListVo> mainList, List<ResourceListVo> subList) {
        for (ResourceListVo menuVo : mainList) {
            List<ResourceListVo> list = new ArrayList<>();

            Long id = menuVo.getId();

            for (ResourceListVo menu : subList) {

                if (id.equals(menu.getParentId())) {
                    list.add(menu);
                }
            }
            menuVo.setChildren(list);
        }
    }

    private void parseRightParentAndChildren(List<ResourceRightVo> mainList, List<RightChildVo> subList, List<Long> menuIds) {
        for (ResourceRightVo menuVo : mainList) {
            if (subList.size() > 0) {
                List<RightChildVo> list = new ArrayList<RightChildVo>();
                Long id = menuVo.getId();
                for (RightChildVo menu : subList) {
                    if (id.equals(menu.getParentId())) {
                        if (menuIds.contains(menu.getId())) {
                            menu.setChecked(true);
                        }
                        list.add(menu);
                    }
                }
                menuVo.setFunctions(list);
            }
        }
    }
}
