package com.atqgh.system.provider.login;//package com.atqgh.system.provider.login;
//
//import com.atqgh.common.exception.MicroException;
//import com.atqgh.system.provider.SysPermissDto;
//import com.atqgh.entity.SysUser;
//import com.atqgh.mapper.SysMenuMapper;
//import com.atqgh.mapper.SysUserMapper;
//import com.atqgh.security.domain.LoginSysUserDto;
//import com.atqgh.security.domain.LoginUserDetailDto;
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import com.google.common.collect.Lists;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//import javax.annotation.Resource;
//import org.apache.commons.lang3.ObjectUtils;
//import org.springframework.beans.BeanUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * 获取用户详情.
// * @author Mubai
// * @date 2022/7/12 9:55 下午
// **/
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Resource
//    private SysUserMapper userMapper;
//
//    @Resource
//    private SysMenuMapper menuMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        //根据用户名查询用户信息
//        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(SysUser::getUserName, username);
//        wrapper.eq(SysUser::getDelFlag, 0);
//        wrapper.eq(SysUser::getStatus, 0);
//        SysUser user = userMapper.selectOne(wrapper);
//        //如果查询不到数据就通过抛出异常来给出提示
//        if (Objects.isNull(user)) {
//            throw new MicroException("用户名或密码错误");
//        }
//        // 根据用户查询权限信息 添加到LoginUser中
//        List<SysPermissDto> list = this.menuMapper.getPermsByUserId(user.getUserId());
//        List<String> permisss = Lists.newArrayList();
//        if (ObjectUtils.isNotEmpty(list)) {
//            permisss = list.stream().map(SysPermissDto::getPerms).collect(Collectors.toList());
//        }
//        //封装成UserDetails对象返回
//        LoginSysUserDto loginSysUserDto = new LoginSysUserDto();
//        BeanUtils.copyProperties(user, loginSysUserDto);
//        return new LoginUserDetailDto(permisss, loginSysUserDto);
//    }
//}
