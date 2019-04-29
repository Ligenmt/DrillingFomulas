package com.ligen.drillingfomula.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * 收藏的增删改查
 * @author Ligen
 *
 */
public class FavouriteDao {
	
	private FavouriteDBHelper helper;
	
	public FavouriteDao(Context context) {
		helper = new FavouriteDBHelper(context);
	}
	
	
	public void add(String titleName, String className, String layoutId) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("insert into favourite values(null, ?, ?, ?)", new String[]{titleName, className, layoutId});
		db.close();
	}
	
	public void delete(String titleName) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from favourite where titlename=?", new String[]{titleName});
		db.close();
	}
	
	public List<Favourite> findAll() {
		SQLiteDatabase db = helper.getWritableDatabase();
		List<Favourite> favourites = new ArrayList<Favourite>();
		Favourite favourite = null;
		Cursor cursor = db.rawQuery("select * from favourite", null);
		while(cursor.moveToNext()) {
			String titleName = cursor.getString(cursor.getColumnIndex("titlename"));
			String className = cursor.getString(cursor.getColumnIndex("classname"));
			String layoutId = cursor.getString(cursor.getColumnIndex("layoutid"));
			favourite = new Favourite(titleName, className, layoutId);
			favourites.add(favourite);
		}
		cursor.close();
		db.close();
		return favourites;
	}
	
	public void deleteAll() {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from favourite where _id>0");
		db.close();
	}
	
}
