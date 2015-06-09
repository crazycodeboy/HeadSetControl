package com.jph.lc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jph.lc.HeadSetUtil.OnHeadSetListener;
public class MainActivity extends Activity {

	TextView txt = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("ksdinf", "onCreate");
		setContentView(R.layout.activity_main);
		txt = (TextView) findViewById(R.id.text);
		HeadSetUtil.getInstance().setOnHeadSetListener(headSetListener);
		HeadSetUtil.getInstance().open(this);
		
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		HeadSetUtil.getInstance().close(this);
	}
	OnHeadSetListener headSetListener = new OnHeadSetListener() {
		@Override
		public void onDoubleClick() {
			txt.setText("双击");
			Log.i("ksdinf", "双击");
		}
		@Override
		public void onClick() {
			txt.setText("单击,1秒延迟");
			Log.i("ksdinf", "单击,1秒延迟");
		}
		@Override
		public void onThreeClick() {
			txt.setText("三连击");
			Log.i("ksdinf", "三连击");
		}
	};
}
