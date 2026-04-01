package com.yupi.picturebackend.utils;

import java.awt.*;

/**
 * 颜色相似度工具类
 */
public class ColorSimilarUtils {

    private ColorSimilarUtils() {
        // 私有构造方法，防止外部实例化
    }

    /**
     * 计算两个颜色的相似度
     *
     * @param color1 颜色1
     * @param color2 颜色2
     * @return 颜色相似度，范围为[0, 1]，1表示完全相似
     */
    public static double calculateSimilarity(Color color1, Color color2) {
        int r1 = color1.getRed();
        int g1 = color1.getGreen();
        int b1 = color1.getBlue();

        int r2 = color2.getRed();
        int g2 = color2.getGreen();
        int b2 = color2.getBlue();


        double distance = Math.sqrt(Math.pow(r1 - r2, 2) + Math.pow(g1 - g2, 2) + Math.pow(b1 - b2, 2));


        return 1 - distance / Math.sqrt(3 * Math.pow(255, 2));
    }

    /**
     * 计算两个十六进制颜色的相似度
     *
     * @param hexColor1 颜色1的十六进制表示（例如："0xFF0000"）
     * @param hexColor2 颜色2的十六进制表示（例如："0xFE0101"）
     * @return 颜色相似度，范围为[0, 1]，1表示完全相似
     */
    public static double calculateSimilarity(String hexColor1, String hexColor2) {
        Color color1 = Color.decode(hexColor1);
        Color color2 = Color.decode(hexColor2);
        return calculateSimilarity(color1, color2);
    }

    /**
     * 主方法，用于测试
     */
    public static void main(String[] args) {

        Color color1 = Color.decode("0xFF0000");
        Color color2 = Color.decode("0xFE0101");
        double similarity = calculateSimilarity(color1, color2);

        System.out.println("颜色相似度为：" + similarity);


        double hexSimilarity = calculateSimilarity("0xFF0000", "0xFE0101");
        System.out.println("十六进制颜色相似度为：" + hexSimilarity);
    }
}