package com.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by zhoushaosen on 2019/3/21.
 *
 *  glide 加载图片
 *
 */

public class LoadImage {

      /**
       *   @param context
       *   @param str  图片路径
       *   @param imageView
       *
       *   @param def  默认图片
       *
       * **/

      public static void loadImage(Context context,
                                   String str,
                                   ImageView imageView,
                                   int def) {

          Point targetImgSize = getTargetSize(context, imageView);

          loadImageSized(context, str, imageView, def, false, targetImgSize.x, targetImgSize.y, false);

      }

    private static void loadImageSized(Context context, String str, ImageView imageView, int def, boolean b, int x, int y, boolean b1) {

        try {
            Glide.with(context).load(str)
                    .asBitmap().placeholder(def)
                    .error(def)
                    .skipMemoryCache(true).override(x,y)
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .dontAnimate()
                    .into(imageView);
        } catch (Exception e) {
            //Log.e("====",e.toString());
        }
    }

    private static Point getTargetSize(Context context, ImageView imageView) {

        Point point = new Point();
        int x=0;
        int y = 0;

        if (imageView.getLayoutParams() != null && imageView.getLayoutParams().width > 0) {

            if (imageView.getLayoutParams().height > 0) {

                x = imageView.getLayoutParams().width;
                y = imageView.getLayoutParams().height;
                point.x = x;
                point.y = y;
                return point;
            }
        }
        //
        if (Build.VERSION.SDK_INT >= 16) {

            x = imageView.getMinimumWidth();
            y = imageView.getMinimumHeight();
        } else {

          //  ImageView dp2px = ScreenUtils.dp2px(context, 346.0f);
          //  imageView = ScreenUtils.dp2px(context, 150.0f);
          //  x = dp2px;
        }
        point.x = x;
        point.y = y;
        return point;
    }

}
