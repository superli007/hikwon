package com.zhou.hikwon.activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




import com.zhou.hikwon.daompl.ProductService;
import com.zhou.hikwon.entity.Product;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ProductListActivity extends ListActivity {
	private Context context = null;
	private LayoutInflater inflater = null;
	// �������ListView��س���
		private static final int PAGESIZE = 5; // ÿ��ȡ������¼

		private int pageIndex = 0; // ���ڱ��浱ǰ�ǵڼ�ҳ,0�����һҳ
		private List<Product> products = null;
		private ListView lvProduct = null;
		private MyAdapter adapter = null;
		private View returnTitle=null;
		protected Menu myMenu;
		private WebView webview;
		public static Map<Integer, Boolean> isSelected;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inflater=LayoutInflater.from(this);
        initMainUI();
        
    }
    /*****
     * ��ʼ������
     */
    private void initMainUI() {
    	setContentView(R.layout.product_list);
    	setReturnImage();
    	TextView title=(TextView) findViewById(R.id.return_title);
    	title.setText("���");
    	
    	 webview=(WebView) findViewById(R.id.WebView_product_list);
    	Intent intent=getIntent();
    	String address=intent.getStringExtra("address");
    	webview.loadUrl(address);
    	
    	ProductService productsv =new ProductService();
		products=productsv.getAll();
		lvProduct = getListView();
		adapter = new MyAdapter(context);
		lvProduct.setItemsCanFocus(true);
//		lvProduct.setSelected(true);
//		lvProduct.setSelector(R.drawable.list_item_bg);
//		
		setListAdapter(adapter);
}
    //���÷���ͼ����Ч
	private void setReturnImage()
	{
		final ImageView imageview=(ImageView) findViewById(R.id.return_image);
		imageview.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v)
			{
				imageview.setBackgroundColor(Color.GREEN);
				finish();
			}});
	}
    


	class MyAdapter extends BaseAdapter {
		private Context context;
		private int item_layout_res = R.layout.productitem;

		public MyAdapter(Context context) {
			this.context = context;
		}

		public MyAdapter(Context context, int res) {
			this.context = context;
			this.item_layout_res = res;
		}

		public boolean isBatManager() {
			return this.item_layout_res == R.layout.productitem;
		}

		public void refresh() {
			notifyDataSetChanged();
		}

		
		public void changeUI(int item_layout_res) {
			this.item_layout_res = item_layout_res;
			notifyDataSetChanged();
		}

		@Override
		public int getCount() {
			return products.size();
		}

		@Override
		public Object getItem(int position) {
			return products.get(position - 1);
		}

		@Override
		public long getItemId(int position) {

			// return products.get(position - 1).getId();

			if (position == 0)// ѡ�е�һ��
			{
				return -1;// ���������ǵ�һ��
			} else if (position > 0 && (position < this.getCount() - 1)) {
				return products.get(position - 1).getId();// ����û�ѡ�����м���
				// mUserList.get(index-1).getId();
			} else {
				return -2;// ��ʾ�û�ѡ�����һ��
			}
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			if (position<=getCount()-1)
			{
				ViewHolder holder = new ViewHolder();
				convertView = inflater.inflate(this.item_layout_res, parent,
						false);
				holder.img = (ImageView) convertView
						.findViewById(R.id.imgPhoto);
				holder.title = (TextView) convertView
						.findViewById(R.id.txtName);
				holder.unitPrice = (TextView) convertView
						.findViewById(R.id.txtUnitPrice);
				convertView.setTag(holder);

				holder.img.setImageResource(products.get(position).getPhoto());
				holder.title.setText(position+1 + "��"
						+ products.get(position).getName().toString());
				holder.unitPrice.setText("RMB:"+String.valueOf(products.get(position)
						.getUnitPrice()));
				return convertView;
			} else
			{
				convertView=findViewById(R.id.publish);
				return convertView;
			}

		}

	}

	public final class ViewHolder {
		public ImageView img;
		public TextView title;
		public TextView unitPrice;
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		Intent intent = new Intent();
		intent.putExtra("id", position+1);
		intent.setClass(this, ProductActivity.class);
		startActivity(intent);
	}
	/**
     * ������Ӧ����WebView�в鿴��ҳʱ�������ؼ���ʱ�������ʷ�˻�,������������������WebView�����˳�
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        // Check if the key event was the Back button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack())
        {
            // ���ؼ��˻�
            webview.goBack();
            return true;
        }
        // If it wasn't the Back key or there's no web page history, bubble up
        // to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event);
    }
}