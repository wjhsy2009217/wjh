package com.hzgc.common.utils;

import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.util.Base64;

public class FaceUtil {
    private static final String SPLIT = ":";

    private static int HANMING_THRESHOLD = 200;
    private static int SAVE_INDEX_MAX = 999;

    public static void init(int hanming_Threshold, int saveIndexMax){
        HANMING_THRESHOLD = hanming_Threshold;
        SAVE_INDEX_MAX = saveIndexMax;
    }

    /**
     * 将特征值（String）转换为特征值（float[]）（内）（赵喆）
     *
     * @param feature 传入编码为UTF-8的String
     * @return 返回float[]类型的特征值
     */
    @Deprecated
    public static float[] string2floatArray(String feature) {
        if (feature != null && feature.length() > 0) {
            float[] featureFloat = new float[512];
            String[] strArr = feature.split(SPLIT);
            for (int i = 0; i < strArr.length; i++) {
                featureFloat[i] = Float.valueOf(strArr[i]);
            }
            return featureFloat;
        }
        return new float[0];
    }

    /**
     * 将特征值（float[]）转换为字符串（String）（内）（赵喆）
     *
     * @param feature 传入float[]类型的特征值
     * @return 输出指定编码为UTF-8的String
     */
    public static String floatArray2string(float[] feature) {
        if (feature != null && feature.length == 512) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < feature.length; i++) {
                if (i == 511) {
                    sb.append(feature[i]);
                } else {
                    sb.append(feature[i]).append(":");
                }
            }
            return sb.toString();
        }
        return "";
    }

    /**
     * 将float特征值转为Base64加密的String类型
     *
     * @param feature float特征值
     * @return Base64加密的String类型
     */
    public static String floatFeature2Base64Str(float[] feature) {
        if (feature != null && feature.length == 512) {
            try {
                byte[] zipFeautre = Snappy.compress(feature);

                return Base64.getEncoder().encodeToString(zipFeautre);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /**
     * 将Base64加密的特征值转为float特征值
     *
     * @param base64Str Base64加密的特征值
     * @return float特征值
     */
    public static float[] base64Str2floatFeature(String base64Str) {
        if (base64Str != null && !"".equals(base64Str)) {
            byte[] zipFeature = Base64.getDecoder().decode(base64Str);
            try {
                return Snappy.uncompressFloatArray(zipFeature);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new float[0];
    }

    /**
     * 将bit特征值转为Base64字符串
     *
     * @param bitFeature bit特征值
     * @return Base64字符串
     */
    public static String bitFeautre2Base64Str(byte[] bitFeature) {
        if (bitFeature != null && bitFeature.length > 0) {
            return Base64.getEncoder().encodeToString(bitFeature);
        }
        return "";
    }

    /**
     * 将Base64字符串转为bit特征值
     *
     * @param base64Str Base64字符串
     * @return bit特征值
     */
    public static byte[] base64Str2BitFeature(String base64Str) {
        if (base64Str != null && !"".equals(base64Str)) {
            return Base64.getDecoder().decode(base64Str);
        }
        return new byte[0];
    }
}
