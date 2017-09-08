package com.xiaojinzi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by JQ on 2017/9/6.
 */

/**
 * 实体类
 */
@Component
@ConfigurationProperties(prefix = "Girl")
public class GirlModel {

    private String Age;
    private String Height;

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }
}
