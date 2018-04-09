package com.kevin.app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Created by zhoujunjie on 2018/4/8.
 */
public class NewLineEditText extends android.support.v7.widget.AppCompatEditText {

    public static final String TAG = NewLineEditText.class.getSimpleName();

    private Paint linePaint;
    protected float lineSpacingExtra;

    public NewLineEditText(Context context) {
        super(context);
        initView();
    }

    public NewLineEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public NewLineEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        linePaint = new Paint();
        /** 最低版本支持的是 16*/
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            lineSpacingExtra = getLineSpacingExtra();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int lineCount = getLineCount(); // 获取下划线的数量
        int lineHeight = getLineHeight();   // 获取下划线之间的高度
        int height = getHeight();   // 获取view的高度
        int drawLineCount = height/lineHeight +1; // 获取需要画下划线的数量
        if (lineCount < drawLineCount) {
            lineCount = drawLineCount;
        }
        int drawHeight = 0;

        // 绘制下划线(起点的x,y坐标和终点的x,y坐标)     绘制顶部的第一条线
//        canvas.drawLine(0.0F, top, getRight(), top, this.linePaint);
        // 死循环
        int padding = (int) (lineSpacingExtra / 2);
        int lineSpacing = padding*2;
        for (int i = 0;;i++) {
            // 判断i是否大于当前需要画下划线的数量
            if (i >= lineCount) {
                setPadding(0,lineSpacing,0,lineSpacing);
                super.onDraw(canvas);
                canvas.restore();
                return;
            }
            drawHeight = drawHeight+lineHeight;
            canvas.drawLine(0.0F, drawHeight+padding, getRight(), drawHeight+padding, this.linePaint);
            canvas.save();
        }
    }
}
