package com.edu.activity;

import com.edu.activity.DrawView2.DragListener;
import com.edu.signdemo.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements DragListener {
	RelativeLayout layout;
	DrawView2 view;
	TextView tvShow;
	int screen_w;
	int screen_h;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}

	private void init() {
		screen_w = getResources().getDisplayMetrics().widthPixels;
		screen_h = getResources().getDisplayMetrics().heightPixels;
		layout = (RelativeLayout) findViewById(R.id.ll_touch);
		tvShow = (TextView) findViewById(R.id.touch_show);

		view = new DrawView2(this);
		view.setOnDragListener(this);
		view.invalidate();
		layout.addView(view);
	}

	@Override
	public void onDragStart() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDragEnd(int x, int y) {
		// 通知view组件重绘
		layout.setBackgroundColor(getResources().getColor(R.color.white));
		tvShow.setText(x + "-----------" + y);
	}
}
