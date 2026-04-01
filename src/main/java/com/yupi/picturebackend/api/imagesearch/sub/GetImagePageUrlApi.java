package com.yupi.picturebackend.api.imagesearch.sub;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.yupi.picturebackend.exception.BusinessException;
import com.yupi.picturebackend.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

// todo 百度识别变严格了，会被reject，可能需要添加模拟浏览器的请求头，虽然此刻试了没成功

/**
 * 获取以图搜图图片页面URL（step 1）
 */
@Slf4j
public class GetImagePageUrlApi {

    /**
     * 获取以图搜图图片页面URL
     */
    public static String getImagePageUrl(String imageUrl) {
        //image https%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fblog%2F202107%2F15%2F20210715031302_a9645.png
        //tn pc
        //from pc
        //image_source PC_UPLOAD_URL
        //sdkParams

        // 1.准备请求参数
        Map<String, Object> formData = new HashMap<>();
        formData.put("image", imageUrl);
        formData.put("tn", "pc");
        formData.put("from", "pc");
        formData.put("image_source", "PC_UPLOAD_URL");
        // 获取当前时间戳
        long uptime = System.currentTimeMillis();
        // 请求地址
        String url = "https://graph.baidu.com/upload?uptime=" + uptime;

        // 2.发送请求
        try {

            HttpResponse response = HttpRequest.post(url)
                    .form(formData)
                    .timeout(5000)
                    .execute();

            if (response.getStatus() != HttpStatus.HTTP_OK) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "接口调用失败");
            }
            // 解析响应体
            // {"status":0,"msg":"Success","data":{"url":"https://graph.baidu.com/s?car.....","sign":"1212f51029961d1502ad801774602596"}}
            String responseBody = response.body();
            Map<String, Object> result = JSONUtil.toBean(responseBody, Map.class);

            // 3.处理响应结果
            if (result == null || !Integer.valueOf(0).equals(result.get("status"))) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "接口调用失败");
            }
            Map<String, Object> data = (Map<String, Object>) result.get("data");
            String rawUrl = (String) data.get("url");
            // 解码URL
            String searchResultUrl = URLUtil.decode(rawUrl, StandardCharsets.UTF_8);
            // 如果解码后的URL为空，抛出异常
            if (searchResultUrl == null || StrUtil.isBlank(searchResultUrl)) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "未返回有效结果");
            }
            return searchResultUrl;
        } catch (Exception e) {
            log.error("搜索失败", e);
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "搜索失败");
        }
    }

    public static void main(String[] args) {

        String imageUrl = "https://yun-picture-1409980882.cos.ap-guangzhou.myqcloud.com/public/2030558294712090626/2026-03-26_h7EdfkkxXVhyTVRF.webp";
        String result = getImagePageUrl(imageUrl);
        System.out.println("搜索成功，结果 URL：" + result);
    }
}
