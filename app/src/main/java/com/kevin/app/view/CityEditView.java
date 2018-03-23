package com.kevin.app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.blankj.utilcode.util.SizeUtils;
import com.kevin.app.R;


/**
 * Created by Administrator on 2018/3/22 0022.
 */

public class CityEditView extends View {
    private static final int MIN_WITH = SizeUtils.dp2px(120);
    private static final int MIN_HEIGHT = SizeUtils.dp2px(32);
    private String cityStr = "新疆维吾尔自治区";

    private Paint borderPaint;  //边框
    private Paint textPaint;  //文字
    private Paint triangularPaint; //三角
    private int textWidth;
    private int textHeight;

    public String getCityStr() {
        return cityStr;
    }

    public void setCityStr(String cityStr) {
        this.cityStr = cityStr;
    }

    public CityEditView(Context context) {
        this(context, null);
    }

    public CityEditView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CityEditView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        borderPaint = new Paint();
        borderPaint.setAntiAlias(true);
        borderPaint.setColor(getResources().getColor(R.color.gray_666));
        borderPaint.setStyle(Paint.Style.STROKE);

        triangularPaint = new Paint();
        triangularPaint.setAntiAlias(true);
        triangularPaint.setColor(getResources().getColor(R.color.gray_666));
        triangularPaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(getResources().getColor(R.color.black));
        textPaint.setTextSize(36f);
        textPaint.setFilterBitmap(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect();
        textPaint.getTextBounds(cityStr, 0, cityStr.length(), rect);
        if (textHeight < MIN_HEIGHT) {
            textHeight = MIN_HEIGHT;
        }
        int strEnd = textWidth - SizeUtils.dp2px(20);
        canvas.drawText(cityStr,SizeUtils.dp2px(4),textHeight/2,textPaint);

        canvas.drawRect(0, 0, strEnd, textHeight, borderPaint);
        Path borderPath = new Path();
        borderPath.moveTo(strEnd, 0);
        borderPath.lineTo(strEnd + SizeUtils.dp2px(20), 0);
        borderPath.lineTo(strEnd + SizeUtils.dp2px(20), textHeight);
        borderPath.lineTo(strEnd, textHeight);
        canvas.drawPath(borderPath, borderPaint);



        Path path = new Path();
        path.moveTo(strEnd + SizeUtils.dp2px(10), SizeUtils.dp2px(23));
        path.lineTo(strEnd + SizeUtils.dp2px(5), SizeUtils.dp2px(12));
        path.lineTo(strEnd + SizeUtils.dp2px(15), SizeUtils.dp2px(12));
        canvas.drawPath(path, triangularPaint);
    }

    /**
     * MeasureSpec.EXACTLY  指定模式，则使用指定的specSize,否则设置view的最小的高度为16dp
     * specMode == MeasureSpec.AT_MOST 自适应模式 则取出我们指定大小与specSize中最小的一个作为最后测量值
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = MIN_HEIGHT;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.max(result, specSize);
            }
        }
        textHeight = result;
        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            if (textWidth < MIN_WITH - SizeUtils.dp2px(20)) {
                result = MIN_WITH;
            } else {
                result = SizeUtils.dp2px(4) * 2 + SizeUtils.dp2px(20) + textWidth;
            }
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.max(result, specSize);
            }
        }
        textWidth = result;
        return result;
    }

}
