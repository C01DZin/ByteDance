package com.bytedance.android.lesson.restapi.solution.bean;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;



public class PostVideoAsk {
    @SerializedName("cover_image") private Uri photo;
    @SerializedName("video")private Uri video;


    public Uri getVideo() {
        return video;
    }

    public void setVideo(Uri video) {
        this.video = video;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }
}
