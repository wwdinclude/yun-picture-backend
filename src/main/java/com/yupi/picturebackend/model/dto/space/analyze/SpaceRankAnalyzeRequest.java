package com.yupi.picturebackend.model.dto.space.analyze;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间使用排名分析请求（仅管理员）
 */
@Data
public class SpaceRankAnalyzeRequest implements Serializable {

    /**
     * 取前N名
     */
    private Integer topN = 10;

    private static final long serialVersionUID = 1L;
}