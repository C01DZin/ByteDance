package com.bytedance.android.lesson.restapi.restapi.bean;

import android.support.annotation.Keep;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.14 21:28
 */
@Keep
public class AndroidOS {
    @SerializedName("name")
    String name;
    @SerializedName("code")
    int code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
