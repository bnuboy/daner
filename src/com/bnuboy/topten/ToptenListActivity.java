package com.bnuboy.topten;

import com.bnuboy.index.IndexList;

import android.app.Activity;
import android.os.Bundle;

public class ToptenListActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		IndexList iList = new IndexList(this);
		String url = "http://www.oiegg.com/index.php";
		iList.setUrl(url);
		String regex = "<a href=\"viewthread\\.php\\?tid=(.*)\" title.*>(.*)</a>";
		iList.setStrStart("<h3 class=\"hl\">当前十大话题</h3>");
		iList.setStrEnd("<h3 class=\"hl\">当前最新话题</h3>");
		iList.setRegex(regex);
		iList.list();
		setContentView(iList);
	}
	
}
