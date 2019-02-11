package com.image_switcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends Activity implements OnItemSelectedListener,
		ViewFactory {
	private ImageSwitcher mswitcher;
	
	//All Images stored im integer array
	private Integer[] mImageIds = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g,
			R.drawable.h, R.drawable.i };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Setting no title on window, it should be written before setting cotent view
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.activity_main);
		
		//Getting id for Image switcher and it is used to switch between images
		mswitcher = (ImageSwitcher) findViewById(R.id.image);
		mswitcher.setFactory(this);
		
		//Gallery for placing images
		Gallery g = (Gallery) findViewById(R.id.gallery);
		
		//Setting adapter over gallery
		g.setAdapter(new ImageAdapter(MainActivity.this, mImageIds));
		
		//Implementing itemselected listener over gallery
		g.setOnItemSelectedListener(MainActivity.this);

	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		
		//On item selected from gallery the image switcher will get the position and set it to background
		mswitcher.setImageResource(mImageIds[position]);
		

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		

	}

	@Override
	public View makeView() {
		//Adding dynamic image 
		ImageView i = new ImageView(this);
		
		//Setting background color
		i.setBackgroundColor(0xFF000000);
		
		//Setting scale type
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		
		//Now setting layout parameters for image view
		i.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

		//Returning imageview
		return i;
	}

}
