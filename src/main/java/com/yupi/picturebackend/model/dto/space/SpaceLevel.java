package com.yupi.picturebackend.model.dto.space;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 空间等级
 */
@Data
@AllArgsConstructor
public class SpaceLevel {

    /**
     * 等级值
     */
    private int value;

    /**
     * 等级文本
     */
    private String text;

    /**
     * 最大图片数量
     */
    private long maxCount;

    /**
     * 最大图片大小（字节）
     */
    private long maxSize;
}