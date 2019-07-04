package com.bytedance.android.lesson.restapi.restapi.bean;

import android.support.annotation.Keep;

/**
 * @author Xavier.S
 * @date 2019.01.14 21:34
 */
@Keep
public class OSList {
    AndroidOS[] os;

    public AndroidOS[] getOs() {
        return os;
    }

    public void setOs(AndroidOS[] os) {
        this.os = os;
    }
}
