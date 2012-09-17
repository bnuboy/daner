package com.bnuboy.second;

import com.bnuboy.second.SecondList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondListActivity extends Activity {
	private Bundle bundle;
	private Intent intent;
	private String url;
	private SecondList sList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		intent = this.getIntent();
		bundle = intent.getExtras();
		String gid = bundle.getString("gid");
		String baseUrl = "http://www.oiegg.com/index.php?gid=";
		this.url = baseUrl + gid;
		Log.v("url",this.url);
		sList = new SecondList(this);
		sList.setUrl(this.url);
		String regex = "<a href=\"forumdisplay\\.php\\?fid=(.*)\">(.*)</a>";
		sList.setRegex(regex);
		sList.list();
		sList.setUsewap(false);
		this.setContentView(sList);
	}

}
