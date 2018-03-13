package com.edu.activity;

import com.edu.signdemo.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawView2 extends View {

	// private int mMotionX = 0;
	// private int mMotionY = 0;
	private DragListener mListener;
	int lastX;
	int lastY;

	public DrawView2(Context context) {
		super(context);
		// setOnTouchListener(this);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 创建画笔
		Paint p = new Paint();
		// 画图片，就是贴图
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gaizhang);
		canvas.drawBitmap(bitmap, lastX, lastY, p);
	}

	/**
	 * 设置拖拽监听
	 * 
	 * @param listener
	 */
	public void setOnDragListener(DragListener listener) {
		mListener = listener;
	}

	/**
	 * 拖拽接口
	 * 
	 * @author lyq
	 * 
	 */
	public interface DragListener {
		/**
		 * 拖动图片开始
		 */
		void onDragStart();

		/**
		 * 拖动图片结束
		 */
		void onDragEnd(int x, int y);

	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {
			lastX = (int) ev.getX();
			lastY = (int) ev.getY();
			invalidate();
			if (mListener != null) {
				mListener.onDragEnd(lastX, lastY);
			}
			return true;
		} else {
			return super.onTouchEvent(ev);
		}
	}

	// public boolean onTouch(View v, MotionEvent event) {
	// DisplayMetrics dm = getResources().getDisplayMetrics();
	// final int screenWidth = dm.widthPixels;
	// final int screenHeight = dm.heightPixels;
	// int action = event.getAction();
	// Log.i("TAG", "onTouch:" + action);
	// switch (action) {
	// case MotionEvent.ACTION_DOWN:
	// lastX = (int) event.getRawX();
	// lastY = (int) event.getRawY();
	// break;
	//
	// case MotionEvent.ACTION_MOVE:
	// int dx = (int) event.getRawX() - lastX;
	// int dy = (int) event.getRawY() - lastY;
	//
	// int left = v.getLeft() + dx;
	// int top = v.getTop() + dy;
	// int right = v.getRight() + dx;
	// int bottom = v.getBottom() + dy;
	// if (left < 0) {
	// left = 0;
	// right = left + v.getWidth();
	// }
	// if (right > screenWidth) {
	// right = screenWidth;
	// left = right - v.getWidth();
	// }
	// if (top < 0) {
	// top = 0;
	// bottom = top + v.getHeight();
	// }
	// if (bottom > screenHeight) {
	// bottom = screenHeight;
	// top = bottom - v.getHeight();
	// }
	// v.layout(left, top, right, bottom);
	// v.postInvalidate();
	// Log.i("TAG", "position----" + "------" + left + ", " + top + ", " + right
	// + ", " + bottom);
	// lastX = (int) event.getRawX();
	// lastY = (int) event.getRawY();
	//
	// Log.i("TAG", "position----" + "------" + lastX + ", --," + lastY);
	// if (mListener != null) {
	// mListener.onDragEnd(lastX, lastY);
	// }
	//
	// break;
	// case MotionEvent.ACTION_UP:
	//
	// // lastX = (int) event.getRawX();
	// // lastY = (int) event.getRawY();
	//
	// // Log.i(TAG, "position" + lastX + ", " + lastY);
	// // if (mListener != null) {
	// // mListener.onDragEnd(lastX, lastY,
	// // mData.getImgName().substring(20, 26));
	// // }
	// break;
	// }
	//
	// return true;
	// }
}
