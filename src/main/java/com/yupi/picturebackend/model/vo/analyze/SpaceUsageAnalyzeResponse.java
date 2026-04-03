package com.yupi.picturebackend.model.vo.analyze;

import lombok.Data;

import java.io.Serializable;

/**
 * 空间资源使用分析响应类
 */
@Data
public class SpaceUsageAnalyzeResponse implements Serializable {

    /**
     * 已用空间大小（字节）
     */
    private Long usedSize;

    /**
     * 最大空间大小（字节）
     */
    private Long maxSize;

    /**
     * 空间大小使用比例
     */
    private Double sizeUsageRatio;

    /**
     * 当前图片数量
     */
    private Long usedCount;

    /**
     * 最大图片数量
     */
    private Long maxCount;

    /**
     * 图片数量使用比例
     */
    private Double countUsageRatio;

    private static final long serialVersionUID = 1L;
}
