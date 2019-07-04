package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.17 18:08
 */
public class Cat  {
    // TODO-C1 (1) Implement your Cat Bean here according to the response json


    @SerializedName("url") private String url;
    @SerializedName("height") private int height;
    @SerializedName("width") private int width;

    public String getUrl() {
        return url;
    }

    public void setUrl(String Url) {
        this.url = Url;
    }





    @Override public String toString() {
        return url+" "+height;
    }
}
