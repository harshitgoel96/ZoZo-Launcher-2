package com.harshit.zozo2;
import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

public class GridPageFragment extends Fragment {
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        ViewGroup rootView = (ViewGroup) inflater.inflate(
	                R.layout.home_grid, container, false);

	        ArrayList<String> myStringArray2 = new ArrayList<String>();
	        myStringArray2.add("something");
	        myStringArray2.add("something");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something");
	        myStringArray2.add("something2 in list");
	        myStringArray2.add("something2 in list");
	        GridView gv=(GridView)rootView.findViewById(R.id.homeGrid);
	        //lv.setAdapter(ad);
	        ArrayAdapter<String> adap2=new ArrayAdapter<String>(getActivity(),R.layout.simple_item,myStringArray2);
	        gv.setAdapter(adap2);
	        
	        return rootView;
	    }
}
