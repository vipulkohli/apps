package com.androidunleashed.databaseapp;

import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseManager {
     public static final String DB_NAME = "shopping";
     public static final String DB_TABLE = "products";
     public static final int DB_VERSION = 1;
     private static final String CREATE_TABLE = "CREATE TABLE " + DB_TABLE + " (code INTEGER PRIMARY KEY, product_name TEXT, price FLOAT);";
     private SQLHelper helper;
     private SQLiteDatabase db;
     private Context context;

     public DatabaseManager(Context c){
         this.context = c;
         helper=new SQLHelper(c);
         this.db = helper.getWritableDatabase();
    }

    public DatabaseManager openReadable() throws android.database.SQLException {
        helper=new SQLHelper(context);
        db = helper.getReadableDatabase();
        return this; 
    }
    public void close(){
        helper.close();
    }
    public boolean addRow(int c, String n, float p){
        ContentValues newProduct = new ContentValues();
        newProduct.put("code", c); 
        newProduct.put("product_name", n); 
        newProduct.put("price", p); 
        try{db.insertOrThrow(DB_TABLE, null, newProduct);}
        catch(Exception e) {
            Log.e("Error in inserting rows ", e.toString());
            e.printStackTrace();
            return false;           
        }
        db.close();
        return true;
    }

    public ArrayList<String> retrieveRows(){
        ArrayList<String> productRows=new ArrayList<String>();
        String[] columns = new String[]{"code", "product_name", "price"};
        Cursor cursor = db.query(DB_TABLE, columns, null, null, null, null, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
            productRows.add(Integer.toString(cursor.getInt(0)) + ", "+cursor.getString(1)+", "+Float.toString(cursor.getFloat(2)));
            cursor.moveToNext();
        }  
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return productRows;
    }


    public class SQLHelper extends SQLiteOpenHelper {
        public SQLHelper(Context c){
            super(c, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("Products table","Upgrading database i.e. dropping table and recreating it");
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);  
        }
    }
}
