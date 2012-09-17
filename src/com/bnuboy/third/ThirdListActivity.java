package com.bnuboy.third;

import com.bnuboy.second.SecondList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ThirdListActivity extends Activity {
	private Bundle bundle;
	private Intent intent;
	private String url;
	private ThirdList tList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		intent = this.getIntent();
		bundle = intent.getExtras();
		String fid = bundle.getString("fid");
		Log.v("fid",fid);
		String baseUrl = "http://www.oiegg.com/wap/index.php?action=forum&fid=";
		this.url = baseUrl + fid;
		Log.v("url",this.url);
		tList = new ThirdList(this);
		tList.setUsewap(true);
		tList.setUrl(this.url);
		String regex = "<a href=\"index\\.php\\?action=thread&amp;tid=(.*)\">(.*) ...</a>";
		tList.setRegex(regex);
		tList.list();
		
		this.setContentView(tList);
	}

}
