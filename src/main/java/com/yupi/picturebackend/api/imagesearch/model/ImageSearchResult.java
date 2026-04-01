package com.yupi.picturebackend.api.imagesearch.model;

import lombok.Data;

/**
 * 图片搜索结果
 */
@Data
public class ImageSearchResult {

    /**
     * 缩略图URL
     */
    private String thumbUrl;

    /**
     * 来源URL
     */
    private String fromUrl;
}
