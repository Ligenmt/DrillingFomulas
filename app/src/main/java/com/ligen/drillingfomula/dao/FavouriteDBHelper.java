package com.ligen.drillingfomula.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 记录
 * @author Ligen 2015/8/12
 *
 */
public class FavouriteDBHelper extends SQLiteOpenHelper {
	
	public FavouriteDBHelper(Context context) {
		super(context, "drillingformulas.db", null, 1);
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table favourite(_id integer primary key autoincrement, " +
				"titlename text, classname text, layoutid text)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}

}
