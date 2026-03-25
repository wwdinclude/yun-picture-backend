package com.yupi.picturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yupi.picturebackend.model.dto.space.SpaceAddRequest;
import com.yupi.picturebackend.model.dto.space.SpaceQueryRequest;
import com.yupi.picturebackend.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.picturebackend.model.entity.User;
import com.yupi.picturebackend.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 27016
 * @description 针对表【space(空间)】的数据库操作Service
 * @createDate 2026-03-24 22:28:26
 */
public interface SpaceService extends IService<Space> {

    /**
     * 校验空间是否合法
     *
     * @param space
     */
    void validSpace(Space space, boolean add);

    /**
     * 获取查询包装类
     *
     * @param spaceQueryRequest
     * @return
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);

    /**
     * 获取空间封装类（单条）
     *
     * @param space
     * @param request
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);


    /**
     * 获取空间封装类（分页）
     *
     * @param spacePage
     * @param request
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);

    void fillSpaceBySpaceLevel(Space space);

    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
}
