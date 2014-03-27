package com.example.xlistviewtest.adapter;

import java.util.ArrayList;
import java.util.TreeSet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xlistviewtest.R;

public class XListViewAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;
    private static final int TYPE_MAX_COUNT = TYPE_SEPARATOR + 1;

    private ArrayList<String> mData = new ArrayList<String>();
    private LayoutInflater mInflater;

    private TreeSet<Integer> mSeparatorsSet = new TreeSet<Integer>();

    public XListViewAdapter(Context context) {
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(final String item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSeparatorItem(final String item) {
        mData.add(item);
        // save separator position
        mSeparatorsSet.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return mSeparatorsSet.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE_MAX_COUNT;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public String getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        switch(type){
        case TYPE_ITEM:
        	convertView = setupItemView(position,convertView,parent);
        	break;
        case TYPE_SEPARATOR:
        	convertView = setupSeparatorView(position,convertView,parent);
        	break;
        }
        
        return convertView;
    }
    
    /**
     * TYPE_ITEM init view
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
	public View setupItemView(int position, View convertView, ViewGroup parent) {
		
		//init view items
		ItemHolder itemHolder = null;
		if(convertView==null){
			convertView = mInflater.inflate(R.layout.item1, null);
			itemHolder = new ItemHolder();
			
			itemHolder.item_textView = (TextView) convertView.findViewById(R.id.text);
			
			convertView.setTag(itemHolder);
		}
		
		//reuse view items
		itemHolder = (ItemHolder) convertView.getTag();
		
		//bind data
		String dataX =  mData.get(position);
		itemHolder.item_textView.setText(dataX);
		
		return convertView;
	}
	
	/**
	 * TYPE_SEPARATOR_ITEM
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	public View setupSeparatorView(int position, View convertView,
			ViewGroup parent) {
		
		//init
		SeparatorHolder separatorHolder = null;
		if(convertView == null){
			separatorHolder = new SeparatorHolder();
			convertView = mInflater.inflate(R.layout.item2, null);
			
			separatorHolder.sep_textView = (TextView) convertView.findViewById(R.id.textSeparator);
			
			convertView.setTag(separatorHolder);
		}
		
		//reuse
		separatorHolder = (SeparatorHolder) convertView.getTag();
		
		//bind 
		separatorHolder.sep_textView.setText(mData.get(position));
		
		return convertView;
	}
	
	public static class ItemHolder {
	    public TextView item_textView;
	}

	public static class SeparatorHolder {
	    public TextView sep_textView;
	}
}
