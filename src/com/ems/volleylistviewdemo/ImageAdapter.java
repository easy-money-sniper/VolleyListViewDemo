package com.ems.volleylistviewdemo;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

public class ImageAdapter extends BaseAdapter {

	private String[] mUrlList;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private Context mContext;

	public ImageAdapter(Context mContext, String[] mUrlList) {
		this.mContext = mContext;
		this.mUrlList = mUrlList;
		mRequestQueue = Volley.newRequestQueue(mContext);
		mImageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mUrlList.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mUrlList[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		String url = mUrlList[position];
		ViewHolder mViewHolder = null;
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item,
					null);
			mViewHolder = new ViewHolder();
			mViewHolder.mNetworkImageView = (NetworkImageView) convertView
					.findViewById(R.id.network_iv);
			convertView.setTag(mViewHolder);
		} else {
			mViewHolder = (ViewHolder) convertView.getTag();
		}
		if (!TextUtils.isEmpty(url)) {
			mViewHolder.mNetworkImageView.setErrorImageResId(R.drawable.ic_launcher);
			mViewHolder.mNetworkImageView.setDefaultImageResId(R.drawable.ic_launcher);
			mViewHolder.mNetworkImageView.setImageUrl(url, mImageLoader);
		}
		return convertView;
	}

	class ViewHolder {
		NetworkImageView mNetworkImageView;
	}

}
