package com.example.memery.tool;

import android.widget.Toast;

import com.example.memery.BaseApplication;

/**
 * Created by Administrator on 2017/1/19.
 */

public class ToastUtils {
    static Toast toast=null;

    public static  void showtoast(String text){
        if(toast==null){
            toast=Toast.makeText(BaseApplication.getContext(),text,Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            toast.setText(text);
        }

    }
}
