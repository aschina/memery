package com.example.memery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class LAdapter extends BaseAdapter {
	 private Context context=null;
     private View[] itemViews; 
	public LAdapter(Context context,String[] str) {
		// TODO 自动生成的构造函数存根
		this.context=context;
        itemViews = new View[str.length];
        for(int i=0;i<str.length;i++)
        itemViews[i]=makeItemView(str[i]);
		
	}

	@Override
    public int getCount() {
            // TODO Auto-generated method stub
            return itemViews.length;
    }

    @Override
    public View getItem(int position) {
            // TODO Auto-generated method stub
            return this.itemViews[position];
    }

    @Override
    public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
    }

	@Override
	public View getView(int position, View arg1, ViewGroup arg2) {
		// TODO 自动生成的方法存根
		 //if (view == null)  
             return itemViews[position];  
          //return view; 
	}
	private View makeItemView(String str) {  
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);   
View itemView = inflater.inflate(android.R.layout.simple_list_item_multiple_choice, null);
TextView title = (TextView) itemView.findViewById(android.R.id.text1);
title.setText(str);  

        return itemView;
}  
}
