package com.harshit.zozo2;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseController extends SQLiteAssetHelper{
	private static final String DATABASE_NAME = "Zozo2Launcher.sqlite";
	private static final int DATABASE_VERSION = 1;
	private static final String homeIconTable="homeScreen";
	private static final String appListTable="";

	public DatabaseController(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	// private MyDatabase db;
	public ArrayList<AppDetail> getAllHomeScreenIcons(){
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.query(homeIconTable, new String[] {"_id", "AppLabel", "PackageName","AppIcon","IsRemovable"}, 
				null, null, null, null, null);
		return null;
	}
	public ArrayList<AppDetail> getAppList(String serch){
		return null;
	}
}
