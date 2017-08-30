package edu_chat.android.com.edu_chat.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.NonNull;

import com.squareup.picasso.Transformation;

/**
 * Created by yuandali on 6/27/16.
 * Edu.Chat Inc.
 */
public class CircleTransform implements Transformation {

    private final String colorString;

    public CircleTransform(final String colorString) {
        super();
        this.colorString = colorString;
    }

    @Override
    public Bitmap transform(@NonNull final Bitmap source) {
        final int size = Math.min(source.getWidth(), source.getHeight());

        final int width = (source.getWidth() - size) / 2;
        final int height = (source.getHeight() - size) / 2;

        final Bitmap bitmap = Bitmap.createBitmap(size, size, Config.ARGB_8888);

        final Canvas canvas = new Canvas(bitmap);
        final Paint picturePaint = new Paint();
        final BitmapShader shader = new BitmapShader(source, BitmapShader.TileMode.CLAMP,
                                                     BitmapShader
                                                             .TileMode.CLAMP
        );
        if (width != 0 || height != 0) {
            final Matrix matrix = new Matrix();
            matrix.setTranslate((float) -width, (float) -height);
            shader.setLocalMatrix(matrix);
        }
        picturePaint.setShader(shader);
        picturePaint.setAntiAlias(true);

        final float r = (float) size / 2f;

        if (this.colorString != null) {
            final Paint borderPaint = new Paint();
            borderPaint.setColor(Color.parseColor(this.colorString));
            borderPaint.setStyle(Style.STROKE);
            borderPaint.setStrokeWidth(10.0F);

            canvas.drawCircle(r, r, r - 5.0F, borderPaint);
            canvas.drawCircle(r, r, r - 10.0F, picturePaint);
        } else {
            canvas.drawCircle(r, r, r, picturePaint);
        }

        source.recycle();

        return bitmap;
    }

    @NonNull
    @Override
    public String key() {
        return "Circle";
    }

}