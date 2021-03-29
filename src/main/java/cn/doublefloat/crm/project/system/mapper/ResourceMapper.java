package cn.doublefloat.crm.project.system.mapper;

import cn.doublefloat.crm.project.system.domain.Resource;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TODO
 *
 * @author 李广帅
 * @version 1.0
 * @date 2021/3/26 5:51 下午
 */
@Repository
public interface ResourceMapper {

    /**
     * 获取所有资源信息
     *
     * @param type 类型
     * @return 结果
     */
    List<Resource> findResource(@Param("type") Integer type);

    /**
     * 保存资源
     *
     * @param r 资源信息
     * @return 结果
     */
    int saveResource(Resource r);

    /**
     * 根据ID获取资源信息
     *
     * @param id ID
     * @return 结果
     */
    Resource findResourceById(Long id);

    /**
     * 编辑资源信息
     *
     * @param r 资源信息
     * @return 结果
     */
    int editResource(Resource r);

    /**
     * 查找资源的子资源
     *
     * @param id 父资源ID
     * @return 结果
     */
    List<Long> findChildrenResourceId(Long id);

    /**
     * 批量删除资源
     *
     * @param list 列表
     * @return 结果
     */
    int batchRemoveResource(List<Long> list);

    /**
     * 查找角色资源ID
     *
     * @param roleId 角色ID
     * @return 结果
     */
    List<Long> findResourceIds(Long roleId);

    /**
     * 批量查找父类资源
     *
     * @param list 资源ID
     * @return 结果
     */
    List<Resource> batchFindParentByResourceId(List<Long> list);
}
