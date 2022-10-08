package com.example.memery;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.memery.tool.CrashHandler;

import org.xutils.x;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/19.
 */

public class BaseApplication extends Application {

    private static Context context;
    private static Handler handler;
    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init();
        //1. 获取Context
        context = getApplicationContext();
        //2. 创建handler
        handler = new Handler();
        //3. 获取主线程id
        mainThreadId = android.os.Process.myTid();
        x.Ext.init(this);
        x.Ext.setDebug(true); // 是否输出debug日志
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }


}
