package com.hzgc.project.system.config.enums;

import lombok.Getter;

/**
 * @author Created by zyD
 * @date 2020/3/29 20:42:00 .
 */
@Getter
public enum ConfigEnum {

        ES_PAGE_SIZE("sys.es.window.size", "es的分页条数"),
        SEMO_URL("sys.semo.algorithm.url", "semo算法Url"),
        ZIP_NUMBER("sys.algorithm.zip.number", "算法压缩数量"),
        ;

        private String key;

        private String value;

    ConfigEnum(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
