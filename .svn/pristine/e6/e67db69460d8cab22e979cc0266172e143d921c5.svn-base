package com.bnuboy.index;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class IndexActivity extends Activity {

	private String content;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.content = getContent();
		Log.v("content", this.content);
	}
	public String getContent(){
		String tempContent = "";
		Intent intent = getIntent();
		Bundle conBundle = intent.getExtras();
		tempContent = conBundle.getString("content");
		return tempContent;
	}
	
}
