package com.edu.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DragView extends View {
	private int mMotionX = 0;
	private int mMotionY = 0;
	private Paint paint;
	Bitmap mBitmap;

	public DragView(Context context, Bitmap bitmap) {
		super(context);
		paint = new Paint();
		mBitmap = bitmap;
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		canvas.drawBitmap(mBitmap, mMotionX, mMotionY, paint);
		Log.e("draw", mMotionX + "-------" + mMotionY);
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {
			mMotionX = (int) ev.getX();
			mMotionY = (int) ev.getY();
			invalidate();
			return true;
		} else {
			return super.onTouchEvent(ev);
		}
	}
}
