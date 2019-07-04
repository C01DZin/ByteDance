package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.18 17:53
 */
public class PostVideoResponse {
    @SerializedName("url")private String url;
    @SerializedName("success")private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String isUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    // TODO-C2 (3) Implement your PostVideoResponse Bean here according to the response json

}

