package com.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LocalJsonResolutionUtils {

     public static String getJson(Context context,String fileName) {

         StringBuilder stringBuilder = null;
         try {
             stringBuilder = new StringBuilder();
             // 获得assets管理器
             AssetManager assetManager = context.getAssets();
             // 使用IO流读取json 内容
             BufferedReader bufferedReader = new BufferedReader(
                     new InputStreamReader(assetManager.open(fileName), "utf-8")
             );

             String line;
             while((line = bufferedReader.readLine()) != null) {
                 stringBuilder.append(line);
             }

         }catch (IOException e) {

             Log.e("====","11=== "+e.toString());

         }
         Log.e("====","22=== "+stringBuilder.toString());

         return stringBuilder.toString();
     }

     /**
      ***/
     public static <T> T JsonToObject(String json,Class<T> type) {

            Gson  gson =new Gson();
            return gson.fromJson(json,type);
     }






}
