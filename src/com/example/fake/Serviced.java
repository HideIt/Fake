package com.example.fake;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class Serviced extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//Log.d("MINE", "onStartCommand");
		startFloatView();
		startForeground(startId, new Notification());
		return super.onStartCommand(intent, flags, startId);
	}
	
	protected void startFloatView() {
		//Log.d("MINE", "startFloatView");
		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		params.type = 2005;//WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
		int flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		params.flags = flags;
		params.format = PixelFormat.TRANSPARENT;//Í¸Ã÷  OPAQUE;//
		params.width = WindowManager.LayoutParams.MATCH_PARENT;
		params.height = WindowManager.LayoutParams.MATCH_PARENT;
		params.gravity = Gravity.CENTER;

		WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		ViewGroup parent = null;
		View view = LayoutInflater.from(this).inflate(R.layout.activity_main, parent, false);
		manager.addView(view, params);
	}
}
