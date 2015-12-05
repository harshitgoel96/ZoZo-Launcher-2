package com.harshit.zozo2;
import java.util.ArrayList;





import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class GridPageFragment extends Fragment {
	ArrayList<AppDetail> apps;
	private PackageManager manager;
	GridView gv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup rootView = (ViewGroup) inflater.inflate(
				R.layout.home_grid, container, false);
		manager=getActivity().getPackageManager();
		AppDetail dailer = new AppDetail();
		dailer.name="com.android.dialer";
		apps=new ArrayList<AppDetail>();
		try {
			ApplicationInfo inf=manager.getApplicationInfo(dailer.name.toString(),0);
			dailer.icon=manager.getApplicationIcon(inf);
			dailer.label=manager.getApplicationLabel(inf);
			apps.add(dailer);

		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			Log.e("zozo2","could not load dailer");
			e.printStackTrace();
		}

		AppDetail contacts = new AppDetail();
		contacts.name="com.android.contacts";

		try {
			ApplicationInfo inf=manager.getApplicationInfo(contacts.name.toString(),0);
			contacts.icon=manager.getApplicationIcon(inf);
			contacts.label=manager.getApplicationLabel(inf);
			apps.add(contacts);

		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		 gv=(GridView)rootView.findViewById(R.id.homeGrid);
		//lv.setAdapter(ad);
		ArrayAdapter<AppDetail> adap2=new ArrayAdapter<AppDetail>(getActivity(),R.layout.grid_item,apps){
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				if(convertView == null){
					convertView = getActivity().getLayoutInflater().inflate(R.layout.grid_item, null);
				}

				ImageView appIcon = (ImageView)convertView.findViewById(R.id.homeIcon);
				appIcon.setImageDrawable(apps.get(position).icon);

				TextView appLabel = (TextView)convertView.findViewById(R.id.homeLabel);
				appLabel.setText(apps.get(position).label);

				//	                TextView appName = (TextView)convertView.findViewById(R.id.item_app_name);
				//	                appName.setText(apps.get(position).name);
				//	                 
				return convertView;
			}
		};
		gv.setAdapter(adap2);
		addClickListener();
		return rootView;
	}
	 private void addClickListener(){        
		    gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		        @Override
		        public void onItemClick(AdapterView<?> av, View v, int pos,
		                long id) {
		            Intent i = manager.getLaunchIntentForPackage(apps.get(pos).name.toString());
		            GridPageFragment.this.startActivity(i);
		        }
		    });
		}
}
