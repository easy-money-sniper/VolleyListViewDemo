package com.ems.volleylistviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView mListView;
	private ImageAdapter mImageAdapter;
	
	private String[] mUrlList = new String[] {
			"http://a4.att.hudong.com/07/77/01300000029734119381778520311.jpg",
			"http://y2.ifengimg.com/a/2014_49/a25be4e0552434a.png",
			"http://news.xinhuanet.com/sports/2014-12/07/127282165_14178318732671n.jpg",
			"http://epaper.lpswz.com/ldwb/res/1/2/2012-05/23/22/res01_attpic_brief.jpg",
			"http://img001.21cnimg.com/photos/album/20140130/m320/7E8F8D31A9A0B325EE4CB317AFAFA4F9.jpeg",
			"http://www.zsnews.cn/data/photo/Backup/2012/12/07/tw_201212711371752802.jpg",
			"http://www.chinashanghaishm.cn/img/aHR0cDovL3d3dy51c3BvcnRuZXdzLmNvbS91cGxvYWRmaWxlLzIwMTMvMDcyNy8yMDEzMDcyNzA1MDE1MjUxMi5qcGc=.jpg",
			"http://res.76868.com/res/images/173d98ed-f14b-46f0-9e9b-b0ddc1206fe2.jpg",
			"http://zzwb.zhuzhouwang.com/images/2012-06/22/A22/zoujh_1206240_b.jpg",
			"http://hsb.hsw.cn/images/2012-12/25/xin_27120925030816607447.jpg",
			"http://pic7.nipic.com/20100525/5002777_190317024648_2.jpg",
			"http://y0.ifengimg.com/news_spider/dci_2012/06/88c3a5e1cad5138485e9ec9d6a802b26.jpg",
			"http://pic22.nipic.com/20120630/10378828_002529432162_2.jpg",
			"http://www.bohaimz.com/uploadfile/2013/1024/20131024040758855.jpg",
			"http://www.sinaimg.cn/dy/slidenews/2_img/2012_23/786_714410_725796.jpg",
			"http://i1.chexun.net/images/2014/0127/10308/news_default_E19600C8ED9E4B96E81FB69C9EC8CD7D.jpg",
			"http://stimgcn4.s-msn.com/msnportal/roll/2012/12/28/8f456843-be5b-45dd-ac8c-9a9eb0c22294.jpg"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		mListView = (ListView) findViewById(R.id.listview);
		mImageAdapter = new ImageAdapter(this, mUrlList);
		mListView.setAdapter(mImageAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
