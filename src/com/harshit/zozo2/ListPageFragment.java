package com.harshit.zozo2;
import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
public class ListPageFragment extends Fragment{
	ViewGroup rootView;
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	         rootView = (ViewGroup) inflater.inflate(
	                R.layout.app_list_view, container, false);

	       loadApps();
	       loadListView();
	       addClickListener();
//	        ListView lv=(ListView)rootView.findViewById(R.id.appList1);
//	        //lv.setAdapter(ad);
//	        ArrayAdapter<String> adap2=new ArrayAdapter<String>(getActivity(),R.layout.simple_item,myStringArray2);
//	        lv.setAdapter(adap2);
	        return rootView;
	    }
	 ListView lv;
	 private PackageManager manager;
	   private List<AppDetail> apps; 
	   private void loadApps(){
	       manager = getActivity().getPackageManager();
	       apps = new ArrayList<AppDetail>();
	        
	       Intent i = new Intent(Intent.ACTION_MAIN, null);
	       i.addCategory(Intent.CATEGORY_LAUNCHER);
	        
	       List<ResolveInfo> availableActivities = manager.queryIntentActivities(i, 0);
	       for(ResolveInfo ri:availableActivities){
	           AppDetail app = new AppDetail();
	           app.label = ri.loadLabel(manager);
	           app.name = ri.activityInfo.packageName;
	           app.icon = ri.activityInfo.loadIcon(manager);
	           apps.add(app);
	       }
	   }
	   private void loadListView(){
	       lv = (ListView)rootView.findViewById(R.id.appList1);
	        lv.setDivider(null);
	       ArrayAdapter<AppDetail> adapter = new ArrayAdapter<AppDetail>(getActivity(), 
	               R.layout.app_list_item_view, 
	               apps) {
	           @Override
	           public View getView(int position, View convertView, ViewGroup parent) {
	               if(convertView == null){
	                   convertView = getActivity().getLayoutInflater().inflate(R.layout.app_list_item_view, null);
	               }
	                
	               ImageView appIcon = (ImageView)convertView.findViewById(R.id.item_app_icon);
	               appIcon.setImageDrawable(apps.get(position).icon);
	                
	               TextView appLabel = (TextView)convertView.findViewById(R.id.item_app_label);
	               
	               appLabel.setText(apps.get(position).label);
	               appLabel.setTextColor(Color.parseColor("#FF6600"));
	                
//	               TextView appName = (TextView)convertView.findViewById(R.id.item_app_name);
//	               appName.setText(apps.get(position).name);
//	                
	               return convertView;
	           }
	       };
	        
	       lv.setAdapter(adapter);           
	   }
	   private void addClickListener(){        
		    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		        @Override
		        public void onItemClick(AdapterView<?> av, View v, int pos,
		                long id) {
		            Intent i = manager.getLaunchIntentForPackage(apps.get(pos).name.toString());
		            ListPageFragment.this.startActivity(i);
		        }
		    });
		}
}
