package com.bnuboy.third;

import com.example.daner.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ThirdListActivity extends Activity {
	private Bundle bundle;
	private Intent intent;
	private String url;
	private ThirdListView tList;
	private TextView prePage;
	private TextView nextPage;
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
		this.setContentView(R.layout.thirdlist);
		prePage = (TextView)this.findViewById(R.id.prePage);
		nextPage = (TextView)this.findViewById(R.id.nextPage);
		this.show();
	}
	
	public void show(){
		tList = (ThirdListView)this.findViewById(R.id.thirdlistview);
		tList.setUsewap(true);
		tList.setUrl(this.url);
		String regex = "<a href=\"index\\.php\\?action=thread&amp;tid=(.*)\">(.*) ...</a>";
		tList.setRegex(regex);
		tList.list();
	}

	class PageNavListener implements OnClickListener{

		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
		}
		
	}
}
