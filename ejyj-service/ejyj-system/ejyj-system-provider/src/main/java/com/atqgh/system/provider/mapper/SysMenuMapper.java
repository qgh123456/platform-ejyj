package com.atqgh.system.provider.mapper;

import com.atqgh.system.provider.dto.SysPermissDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.atqgh.system.provider.entity.SysMenu;
import com.atqgh.system.provider.vo.SysMenuQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;

/**
 * 菜单权限表.
 * 
 * @author Mubai
 * @date 2022-08-14 10:45:24
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
    * 构建查询参数对象.
    *
    * @param queryVo 查询实体
    * @return 查询对象
    */
    default LambdaQueryWrapper<SysMenu> buildQueryPageWrapper(SysMenuQueryVo queryVo) {

        SysMenu entity = new SysMenu();
        BeanUtils.copyProperties(queryVo, entity);
        LambdaQueryWrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>().lambda();
        // TODO 构建查询参数
        return wrapper;
    }

    /**
     * 根据用户id查询数据.
     *
     * @param userCode 用户编码
     * @return 权限数据
     */
    List<SysPermissDto> getPermsByUserId(@Param("userCode") String userCode);

}
