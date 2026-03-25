package com.yupi.picturebackend.model.dto.picture;

import lombok.Data;

import java.io.Serializable;

@Data
public class PictureUploadRequest implements Serializable {

    /**
     * 图片ID（用于修改）
     */
    private Long id;

    /**
     * 图片文件URL（用于文件上传）
     */
    private String fileUrl;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 所属空间 id
     */
    private Long spaceId;

    private static final long serialVersionUID = 1L;
}