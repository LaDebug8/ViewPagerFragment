package com.debug8.viewpagerfragment.util;

/**
 * Created by Debug8 on 2016/4/17.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
