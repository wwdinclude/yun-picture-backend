package com.yupi.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.picturebackend.model.dto.space.SpaceAddRequest;
import com.yupi.picturebackend.model.dto.space.SpaceQueryRequest;
import com.yupi.picturebackend.model.dto.spaceuser.SpaceUserAddRequest;
import com.yupi.picturebackend.model.dto.spaceuser.SpaceUserQueryRequest;
import com.yupi.picturebackend.model.entity.Space;
import com.yupi.picturebackend.model.entity.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.picturebackend.model.entity.User;
import com.yupi.picturebackend.model.vo.SpaceUserVO;
import com.yupi.picturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author 27016
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2026-04-03 15:28:30
*/
public interface SpaceUserService extends IService<SpaceUser> {


    /**
     * 添加空间成员
     *
     * @param spaceUserAddRequest
     * @return
     */
    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);

    /**
     * 校验空间成员是否合法
     *
     * @param spaceUser
     */
    void validSpaceUser(SpaceUser spaceUser, boolean add);

    /**
     * 获取查询包装类
     *
     * @param spaceUserQueryRequest
     * @return
     */
    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);

    /**
     * 获取空间成员封装类（单条）
     *
     * @param spaceUser
     * @param request
     * @return
     */
    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    /**
     * 获取空间成员封装类（分页）
     *
     * @param spaceUserList
     * @return
     */
    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);
}
