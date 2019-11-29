package com.delevin.listmanger.rxjava.coustom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.delevin.listmanger.utils.DisPalyUtils;

public class DialView extends View {
    Paint mPaint ;
    private Context cxt;
    private int [] arr ;

    int dialColor = Color.parseColor("#1C86F5");
    int scaleColor = Color.parseColor("#333333");

    public DialView(Context context) {
        super(context);
        init();
    }


    public DialView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        cxt = context;
        init();
    }

    public DialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        cxt = context;
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public DialView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        cxt = context;
        init();
    }

    private void init() {
        mPaint = new Paint();
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(dialColor);
        mPaint.setStrokeWidth(DisPalyUtils.dip2px(cxt,15));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        int measuredWidth = getMeasuredWidth();
        Log.d("dialView:","width:"+measuredWidth);
        canvas.drawLine(DisPalyUtils.dip2px(cxt,15),DisPalyUtils.dip2px(cxt,100),measuredWidth-DisPalyUtils.dip2px(cxt,100),DisPalyUtils.dip2px(cxt,15),mPaint);
        mPaint.setColor(scaleColor);
        mPaint.setStrokeWidth(DisPalyUtils.dip2px(cxt,2));
        for(int i = 0 ; i>arr.length ; i ++){
            if(i == 0){}
            canvas.drawLine(DisPalyUtils.dip2px(cxt,30),DisPalyUtils.dip2px(cxt,65),measuredWidth-DisPalyUtils.dip2px(cxt,15),DisPalyUtils.dip2px(cxt,15),mPaint);
        }
    }
    public void setDialArray(int [] arr){
        this.arr = arr;
    }
}
