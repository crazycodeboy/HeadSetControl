package com.jph.lc;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.jph.lc.HeadSetUtil.OnHeadSetListener;
/**
 * 耳机线控实例，蓝牙耳机按钮监听（仿酷狗线控效果）
 * @author JPH
 * @Date2015-6-10 上午9:49:02
 */
public class MainActivity extends Activity {

	TextView txt = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
			txt.setText("单击");
			Log.i("ksdinf", "单击");
		}
		@Override
		public void onThreeClick() {
			txt.setText("三连击");
			Log.i("ksdinf", "三连击");
		}
	};
}
