package com.bnuboy.content;

import com.bnuboy.index.IndexList;
import com.bnuboy.web.WebContent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ContentActivity extends Activity {
	private ContentList cList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Intent intent = this.getIntent();
		Bundle bundle = intent.getExtras();
		String tid = bundle.getString("tid");
		Log.v("tid",tid);
		cList = new ContentList(this);
		String url = "http://www.oiegg.com/wap/index.php?action=thread&showall=true&tid=" + tid;
		cList.setUsewap(true);
		cList.setUrl(url);
		String regex = "<li>(.*)<small>(.*)</small>.*</li>";
		cList.setRegex(regex);
		cList.list();
		setContentView(cList);
		
	}

}
