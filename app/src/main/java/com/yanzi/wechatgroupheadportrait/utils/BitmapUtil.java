package com.yanzi.wechatgroupheadportrait.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.Log;

import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BitmapUtil {

    //得到图片的拉伸度
    static public Drawable getScaleDraw(String imgPath, Context mContext) {
        if (imgPath == null || "".equals(imgPath)) {
            Logger.d("BitmapUtil getScaleDraw imgPath can not be empty ");
            return null;
        }
        Bitmap bitmap = null;
        try {
            File imageFile = new File(imgPath);
            if (!imageFile.exists()) {
                Logger.d("BitmapUtil getScaleDraw imgPath is wrong or not exists");
                return null;
            }
            //得到图片的尺寸
            BitmapFactory.Options opts = new BitmapFactory.Options();
            //bitmap 为null 为了获取图片大小和压缩比例，从而进行深一步的操作
            opts.inJustDecodeBounds = true;
            //此时得到的bitmap为null
            bitmap = BitmapFactory.decodeFile(imgPath, opts);
            //如果图片过大 则进行压缩 防止OOM
            opts.inSampleSize = computeSampleSize(opts, -1, 800 * 480);
            // Log.d("BitmapUtil","inSampleSize===>"+opts.inSampleSize);
            opts.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeFile(imgPath, opts);

        } catch (OutOfMemoryError err) {
            Log.d("BitmapUtil", "[getScaleDraw] out of memory");

        }
        if (bitmap == null) {
            return null;
        }
        Drawable resizeDrawable = new BitmapDrawable(mContext.getResources(),
                bitmap);
        return resizeDrawable;
    }

    public static void saveMyBitmap(Context mContext, Bitmap bitmap,
                                    String desName) throws IOException {
        FileOutputStream fOut = null;

        if (Environment.getExternalStorageState() != Environment.MEDIA_MOUNTED) {
            Logger.d("sdcard doesn't exit, save png to app dir");
            fOut = mContext.openFileOutput(desName + ".png",
                    Context.MODE_PRIVATE);
        } else {
            File f = new File(Environment.getExternalStorageDirectory()
                    .getPath() + "/Asst/cache/" + desName + ".png");
            f.createNewFile();
            fOut = new FileOutputStream(f);
        }
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
        try {
            fOut.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public Bitmap getScaleBitmap(Resources res, int id) {

        Bitmap bitmap = null;
        try {
            BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(res, id, opts);

            opts.inSampleSize = computeSampleSize(opts, -1, 800 * 480);
            // Log.d("BitmapUtil","inSampleSize===>"+opts.inSampleSize);
            opts.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(res, id, opts);
        } catch (OutOfMemoryError err) {
            Log.d("BitmapUtil", "[getScaleBitmap] out of memory");

        }
        return bitmap;
    }

    /**
     * @param options
     * @param minSideLength
     * @param maxNumOfPixels
     * @return
     */
    public static int computeSampleSize(BitmapFactory.Options options,
                                        int minSideLength, int maxNumOfPixels) {

        int initialSize = computeInitialSampleSize(options, minSideLength,
                maxNumOfPixels);
        int roundedSize;
        if (initialSize <= 8) {
            roundedSize = 1;
            while (roundedSize < initialSize) {
                roundedSize <<= 1;
            }
        } else {
            roundedSize = (initialSize + 7) / 8 * 8;
        }

        return roundedSize;

    }

    private static int computeInitialSampleSize(BitmapFactory.Options options,
                                                int minSideLength, int maxNumOfPixels) {

        double w = options.outWidth;
        double h = options.outHeight;
        int lowerBound = (maxNumOfPixels == -1) ? 1 : (int) Math.ceil(Math
                .sqrt(w * h / maxNumOfPixels));
        int upperBound = (minSideLength == -1) ? 128 : (int) Math.min(
                Math.floor(w / minSideLength), Math.floor(h / minSideLength));

        if (upperBound < lowerBound) {
            // return the larger one when there is no overlapping zone.
            return lowerBound;
        }

        if ((maxNumOfPixels == -1) && (minSideLength == -1)) {
            return 1;
        } else if (minSideLength == -1) {
            return lowerBound;
        } else {
            return upperBound;
        }

    }

    public static Bitmap drawableToBitmap(Drawable drawable) {

        Bitmap bitmap = Bitmap
                .createBitmap(
                        drawable.getIntrinsicWidth(),
                        drawable.getIntrinsicHeight(),
                        drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888
                                : Config.RGB_565);
        Canvas canvas = new Canvas(bitmap);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    /**
     * 根据资源id得到bitmap
     *
     * @param res
     * @param id
     * @return
     */
    public static Bitmap decodeBitmap(Resources res, int id) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        //此方法比较耗内存 很容易oom
        Bitmap bitmap = BitmapFactory.decodeResource(res, id, options);
        if (bitmap == null) {
            Logger.d("bitmap is null ");
        }
        float realWidth = options.outWidth;
        float realHeight = options.outHeight;
        Logger.d("real height" + realHeight + "real realWidth " + realWidth);
        //宽高不同，拉升成正方形
        int scale = (int) ((realHeight > realWidth ? realHeight : realWidth) / 100);
        if (scale <= 0) {
            scale = 1;
        }
        Logger.d("scale=>" + scale);
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        //	options.inSampleSize = scale; options.inJustDecodeBounds
        bitmap = BitmapFactory.decodeResource(res, id, options);
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        Logger.d("new bitmap height" + h + "new bitmap width" + w);
        return bitmap;
    }

//    public static Bitmap getCombineBitmaps(List<MyBitmapEntity> mEntityList,
//                                           Bitmap... bitmaps) {
//        Logger.d("count=>" + mEntityList.size());
//        Bitmap newBitmap = Bitmap.createBitmap(200, 200, Config.ARGB_8888);
//        Logger.d("newBitmap=>" + newBitmap.getWidth() + ","
//                + newBitmap.getHeight());
//        for (int i = 0; i < mEntityList.size(); i++) {
//            Logger.d("i==>" + i);
//            newBitmap = mixtureBitmap(newBitmap, bitmaps[i], new PointF(
//                    mEntityList.get(i).x, mEntityList.get(i).y));
//        }
//        return newBitmap;
//    }

    /**
     * @param columns
     * @param bitmaps
     * @return
     */
    public static Bitmap combineBitmaps(int columns, Bitmap... bitmaps) {
        if (columns <= 0 || bitmaps == null || bitmaps.length == 0) {
            throw new IllegalArgumentException(
                    "Wrong parameters: columns must > 0 and bitmaps.length must > 0.");
        }
        int maxWidthPerImage = 20;
        int maxHeightPerImage = 20;
        for (Bitmap b : bitmaps) {
            maxWidthPerImage = maxWidthPerImage > b.getWidth() ? maxWidthPerImage
                    : b.getWidth();
            maxHeightPerImage = maxHeightPerImage > b.getHeight() ? maxHeightPerImage
                    : b.getHeight();
        }
        Logger.d("maxWidthPerImage=>" + maxWidthPerImage
                + ";maxHeightPerImage=>" + maxHeightPerImage);
        int rows = 0;
        if (columns >= bitmaps.length) {
            rows = 1;
            columns = bitmaps.length;
        } else {
            rows = bitmaps.length % columns == 0 ? bitmaps.length / columns
                    : bitmaps.length / columns + 1;
        }
        Bitmap newBitmap = Bitmap.createBitmap(columns * maxWidthPerImage, rows
                * maxHeightPerImage, Config.ARGB_8888);
        Logger.d("newBitmap=>" + newBitmap.getWidth() + ","
                + newBitmap.getHeight());
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                int index = x * columns + y;
                if (index >= bitmaps.length)
                    break;
                Logger.d("y=>" + y + " * maxWidthPerImage=>"
                        + maxWidthPerImage + " = " + (y * maxWidthPerImage));
                Logger.d("x=>" + x + " * maxHeightPerImage=>"
                        + maxHeightPerImage + " = " + (x * maxHeightPerImage));
                newBitmap = mixtureBitmap(newBitmap, bitmaps[index],
                        new PointF(y * maxWidthPerImage, x * maxHeightPerImage));
            }
        }
        return newBitmap;
    }

    /**
     * Mix two Bitmap as one.
     *
     * @param first
     * @param second
     * @param fromPoint where the second bitmap is painted.
     * @return
     */
    public static Bitmap mixtureBitmap(Bitmap first, Bitmap second,
                                       PointF fromPoint) {
        if (first == null || second == null || fromPoint == null) {
            return null;
        }
        Bitmap newBitmap = Bitmap.createBitmap(first.getWidth(),
                first.getHeight(), Config.ARGB_8888);
        Canvas cv = new Canvas(newBitmap);
        cv.drawBitmap(first, 0, 0, null);
        cv.drawBitmap(second, fromPoint.x, fromPoint.y, null);
        cv.save(Canvas.ALL_SAVE_FLAG);
        cv.restore();
        return newBitmap;
    }

    public static void getScreenWidthAndHeight(Activity mContext) {
        DisplayMetrics metric = new DisplayMetrics();
        mContext.getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels; // 当前像素密度下的宽
        int height = metric.heightPixels; // 当前屏幕像素密度下的高
        Logger.d("screen width=>" + width + ",height=>" + height);
    }

}
