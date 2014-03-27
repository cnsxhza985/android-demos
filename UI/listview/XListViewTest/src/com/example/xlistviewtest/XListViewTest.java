package com.example.xlistviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

import com.example.xlistviewtest.adapter.XListViewAdapter;
import com.example.xlistviewtest.view.XListView;
import com.example.xlistviewtest.view.XListView.IXListViewListener;

public class XListViewTest extends Activity implements IXListViewListener,OnItemClickListener,OnItemLongClickListener {
	
    private XListView mListView = null;
    
    private XListViewAdapter mAdapter = null;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xlist_view_test);
		
        mListView = (XListView) findViewById(R.id.xlistview);
        mListView.setPullRefreshEnable(true); 
        mListView.setPullLoadEnable(true);
        mAdapter = new XListViewAdapter(getApplicationContext());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemLongClickListener(this);
        mListView.setOnItemClickListener(this);
        mListView.setXListViewListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.xlist_view_test, menu);
		return true;
	}

	@Override
	public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onRefresh() {
		for(int i=0;i<2;i++){
			mAdapter.addItem(" "+ i);
		}

		mListView.stopRefresh();	
	}

	@Override
	public void onLoadMore() {
		for(int i=0;i<1;i++){
			mAdapter.addItem(" "+ (i+100));
		}

		mListView.stopLoadMore();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
	}

}
