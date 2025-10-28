package com.example.deviceinfo;

import android.os.Build;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import io.dcloud.feature.uniapp.annotation.UniJSMethod;
import io.dcloud.feature.uniapp.bridge.UniJSCallback;
import io.dcloud.feature.uniapp.plugin.UniPlugin;

public class DeviceInfoPlugin extends UniPlugin {

    // 获取设备信息
    @UniJSMethod(uiThread = false)
    public void getDeviceInfo(UniJSCallback callback) {
        JSONObject result = new JSONObject();
        
        // 设备型号
        result.put("model", Build.MODEL);
        // 制造商
        result.put("manufacturer", Build.MANUFACTURER);
        // Android版本
        result.put("androidVersion", Build.VERSION.RELEASE);
        // SDK版本
        result.put("sdkVersion", Build.VERSION.SDK_INT);
        
        if (callback != null) {
            callback.invoke(result);
        }
    }
    
    // 显示Toast消息
    @UniJSMethod(uiThread = true)
    public void showToast(String message) {
        if (mUniSDKInstance != null && mUniSDKInstance.getContext() != null) {
            Toast.makeText(mUniSDKInstance.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
    
    // 简单的加法计算
    @UniJSMethod(uiThread = false)
    public int addNumbers(int a, int b) {
        return a + b;
    }
}