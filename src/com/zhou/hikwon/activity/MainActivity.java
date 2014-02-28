package com.zhou.hikwon.activity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private LinearLayout linearLayout, publish, change, more;
	private WebView webview;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);
		
		linearLayout = (LinearLayout) findViewById(R.id.home);
		linearLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				linearLayout
						.setBackgroundResource(R.drawable.tab_two_highlight);
				publish.setBackgroundResource(R.drawable.tab_one_normal);
				change.setBackgroundResource(R.drawable.tab_one_normal);
				more.setBackgroundResource(R.drawable.tab_one_normal);
				
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
			}
		});

		more = (LinearLayout) findViewById(R.id.more);
		more.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				more.setBackgroundResource(R.drawable.tab_two_highlight);
				linearLayout.setBackgroundResource(R.drawable.tab_one_normal);
				publish.setBackgroundResource(R.drawable.tab_one_normal);
				change.setBackgroundResource(R.drawable.tab_one_normal);
			}
		});
//		ImageView imview=(ImageView) findViewById(R.id.);
//		imview.setOnClickListener(new ImageOnClickListener());
		webview=(WebView) findViewById(R.id.WebView_index_products);
		webview.setWebViewClient(new WebViewClient(){

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{
				clip(url);
				return true;
			}

			
        	
        });
        webview.loadUrl("file:///android_asset/xinkang.html");
//        webview.loadUrl("http://www.xinkang.com.cn");
//		webview.loadUrl("http://www.baidu.com");
        WebSettings websettings=webview.getSettings();
        websettings.setJavaScriptEnabled(true);
		
	}
	
	private void clip(String url)
	{
		Intent intent =new Intent();
		intent.putExtra("address", url);
		intent.setClass(this, ProductListActivity.class);
		startActivity(intent);
	}
    /**
     * 按键响应，在WebView中查看网页时，按返回键的时候按浏览历史退回,如果不做此项处理则整个WebView返回退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack())
        {
            // 返回键退回
        	webview.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up
        // to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
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