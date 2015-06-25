package com.ems.volleylistviewdemo;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.text.TextUtils;

import com.android.volley.toolbox.ImageLoader.ImageCache;

public class BitmapCache implements ImageCache {

	private LruCache<String, Bitmap> mLruCache;

	public BitmapCache() {
		int maxSize = 10 * 1024 * 1024;
		mLruCache = new LruCache<String, Bitmap>(maxSize) {

			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				return value.getRowBytes() * value.getHeight();
			}
		};
	}

	@Override
	public Bitmap getBitmap(String url) {
		// TODO Auto-generated method stub
		return mLruCache.get(url);
	}

	@Override
	public void putBitmap(String url, Bitmap bitmap) {
		// TODO Auto-generated method stub
		if (bitmap != null && !TextUtils.isEmpty(url)) {
			mLruCache.put(url, bitmap);
		}
	}

}
