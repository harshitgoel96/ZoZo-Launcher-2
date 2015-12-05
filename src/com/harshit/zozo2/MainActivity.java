package com.harshit.zozo2;


import java.util.ArrayList;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class MainActivity extends FragmentActivity{
	
	 private static final int NUM_PAGES = 2;

	    /**
	     * The pager widget, which handles animation and allows swiping horizontally to access previous
	     * and next wizard steps.
	     */
	    private ViewPager mPager;

	    /**
	     * The pager adapter, which provides the pages to the view pager widget.
	     */
	    private PagerAdapter mPagerAdapter;
	    ListView lv;
	    GridView gv;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.pager_main);

	        // Instantiate a ViewPager and a PagerAdapter.
	        mPager = (ViewPager) findViewById(R.id.pager);
	        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
	        mPager.setAdapter(mPagerAdapter);
	        
	      
	        
	    }

	    @Override
	    public void onBackPressed() {
	        if (mPager.getCurrentItem() == 0) {
	            // If the user is currently looking at the first step, allow the system to handle the
	            // Back button. This calls finish() on this activity and pops the back stack.
	            //super.onBackPressed();
	        } else {
	            // Otherwise, select the previous step.
	            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
	        }
	    }

	    /**
	     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
	     * sequence.
	     */
	    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
	        public ScreenSlidePagerAdapter(FragmentManager fm) {
	            super(fm);
	        }

	        @Override
	        public Fragment getItem(int position) {
	        	if(position==0){
	        		return new GridPageFragment();
	        	}
	        	else{
	        		return new ListPageFragment();
	        	}
	            //return new ScreenSlidePageFragment();
	        }

	        @Override
	        public int getCount() {
	            return NUM_PAGES;
	        }
	    }
}

//public class MainActivity extends Activity  
//
//{
//	ListView lv;
//	GridView gv;
//	private GestureDetectorCompat mDetector; 
//	@SuppressWarnings("deprecation")
//	@Override
//	    protected void onCreate(Bundle savedInstanceState) {
//	        super.onCreate(savedInstanceState);
//	        setContentView(R.layout.activity_main);
//	       
//	        ArrayList<String> myStringArray1 = new ArrayList<String>();
//	        myStringArray1.add("something");
//	        myStringArray1.add("something");
//	        myStringArray1.add("something2");
//	        myStringArray1.add("something");
//	        myStringArray1.add("something2");myStringArray1.add("something");
//	        myStringArray1.add("something2");myStringArray1.add("something");
//	        myStringArray1.add("something2");
//	        myStringArray1.add("something");
//	        myStringArray1.add("something2");
//	        myStringArray1.add("something");
//	        myStringArray1.add("something2");myStringArray1.add("something");
//	        myStringArray1.add("something2");myStringArray1.add("something2");
//	      
//	        ArrayList<String> myStringArray2 = new ArrayList<String>();
//	        myStringArray2.add("something");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something");
//	        myStringArray2.add("something2 in list");
//	        myStringArray2.add("something2 in list");
//	        lv=(ListView)findViewById(R.id.appList);
//	        gv=(GridView)findViewById(R.id.gridBox);
//	        ArrayAdapter<String> adap=new ArrayAdapter<String>(this,R.layout.simple_item,myStringArray1);
//	        ArrayAdapter<String> adap2=new ArrayAdapter<String>(this,R.layout.simple_item,myStringArray2);
//	        lv.setAdapter(adap);
//	        gv.setAdapter(adap2);
//	        mDetector = new GestureDetectorCompat(this, new GestureListener());
//	       //lv.setOnTouchListener(new GestureListener());
//	       
//	       
//	    }
//	 @Override 
//	    public boolean onTouchEvent(MotionEvent event){ 
//		 Log.d("Touch","onTouch "+event.toString());
//	        this.mDetector.onTouchEvent(event);
//	        return super.onTouchEvent(event);
//	    }
//	void toggleVisibility(){
//		if(gv.getVisibility()==View.INVISIBLE){
//			gv.setVisibility(View.VISIBLE);
//			lv.setVisibility(View.INVISIBLE);
//		}
//		else{
//			lv.setVisibility(View.VISIBLE);
//			gv.setVisibility(View.INVISIBLE);
//		}
//	}
//	
//	private static final int SWIPE_MIN_DISTANCE = 120;
//    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
//
//    private class GestureListener extends SimpleOnGestureListener {
//        @Override
//        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//        	 Log.d("Touch","onFling: " + e1.toString() +":"+e2.toString()); 
//            if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//            	toggleVisibility();
//            	return false; // Right to left
//            }  else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
//            	toggleVisibility();
//            	return false; // Left to right
//            }
//
//            if(e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
//            	
//                return true; // Bottom to top
//            }  else if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
//                return true; // Top to bottom
//            }
//            return true;
//        }
//        
//        @Override
//        public boolean onDown(MotionEvent event) { 
//            Log.d("Touch","onDown: " + event.toString()); 
//            return true;
//        }
////        @Override
////        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
////        	Log.d("Touch","onScroll: " + e1.toString() +":"+e2.toString());
////        	return true;
////        }
//    }	     
//
//}