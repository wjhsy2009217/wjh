package com.hzgc.project.system.dict.enums;

import lombok.Getter;


@Getter
public enum DictTypeEnum {

    FTP_HOST("ftp_host", "ftp服务映射"),
    CAPTURE_FACE_AGE_STAGE("sys_capture_face_age_stage", "人脸抓拍年龄阶段"),

    ;

    private String key;

    private String value;

    DictTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
