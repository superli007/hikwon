package com.zhou.hikwon.activity;


import java.util.zip.Inflater;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private LinearLayout linearLayout, publish, change, more,addToView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		addToView=(LinearLayout) findViewById(R.id.add_to_view);
		final LayoutInflater inflater=LayoutInflater.from(this);
		linearLayout = (LinearLayout) findViewById(R.id.home);
		linearLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				linearLayout
						.setBackgroundResource(R.drawable.tab_two_highlight);
				publish.setBackgroundResource(R.drawable.tab_one_normal);
				change.setBackgroundResource(R.drawable.tab_one_normal);
				more.setBackgroundResource(R.drawable.tab_one_normal);
				addToView.removeAllViews();
				ViewGroup.LayoutParams param=new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
				addToView.addView(inflater.inflate(R.layout.index_products, null).findViewById(R.id.index_products),param);
			}
		});
		linearLayout.setBackgroundResource(R.drawable.tab_two_highlight);

		publish = (LinearLayout) findViewById(R.id.publish);
		publish.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				publish.setBackgroundResource(R.drawable.tab_two_highlight);
				linearLayout.setBackgroundResource(R.drawable.tab_one_normal);
				change.setBackgroundResource(R.drawable.tab_one_normal);
				more.setBackgroundResource(R.drawable.tab_one_normal);
				addToView.removeAllViews();
				ViewGroup.LayoutParams param=new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT, 850);
				addToView.addView(inflater.inflate(R.layout.search, null).findViewById(R.id.search_layout),param);
			}
		});

		change = (LinearLayout) findViewById(R.id.change);
		change.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				change.setBackgroundResource(R.drawable.tab_two_highlight);
				linearLayout.setBackgroundResource(R.drawable.tab_one_normal);
				publish.setBackgroundResource(R.drawable.tab_one_normal);
				more.setBackgroundResource(R.drawable.tab_one_normal);
				addToView.removeAllViews();
				ViewGroup.LayoutParams param=new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT, 850);
				addToView.addView(inflater.inflate(R.layout.buycart, null).findViewById(R.id.buycart_layout),param);			}
		});

		more = (LinearLayout) findViewById(R.id.more);
		more.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				more.setBackgroundResource(R.drawable.tab_two_highlight);
				linearLayout.setBackgroundResource(R.drawable.tab_one_normal);
				publish.setBackgroundResource(R.drawable.tab_one_normal);
				change.setBackgroundResource(R.drawable.tab_one_normal);
				addToView.removeAllViews();
				ViewGroup.LayoutParams param=new ViewGroup.LayoutParams(LayoutParams.FILL_PARENT, 850);
				addToView.addView(inflater.inflate(R.layout.user, null).findViewById(R.id.user_layout),param);			}
		});
		ImageView imview=(ImageView) findViewById(R.id.jk_image);
		imview.setOnClickListener(new ImageOnClickListener());
	}
	class ImageOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v)
		{
			intent();
			
		}
		
	}
	void intent(){
		Intent intent = new Intent();
		intent.putExtra("id", 1);
		intent.setClass(this, ProductListActivity.class);
		startActivity(intent);
	}
}