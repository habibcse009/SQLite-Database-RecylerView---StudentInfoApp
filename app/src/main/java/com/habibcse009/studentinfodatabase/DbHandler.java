package com.habibcse009.studentinfodatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DbHandler extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "users.db";
    private static final String TABLE_Users = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_DEPARTMENT = "department";
    private static final String KEY_UNIVERSITY = "university";
    private static final String KEY_MOBILE = "mobile";
    private static final String KEY_EMAIL = "email";

    public DbHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
                + KEY_DEPARTMENT + " TEXT,"
                + KEY_UNIVERSITY + " TEXT,"
                + KEY_MOBILE + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        // Create tables again
        onCreate(db);
    }
    // **** CRUD (Create, Read, Update, Delete) Operations ***** //

    // Adding new User Details
    void insertUserDetails(String name, String department, String university, String mobile, String email) {
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_DEPARTMENT, department);
        cValues.put(KEY_UNIVERSITY, university);
        cValues.put(KEY_MOBILE, mobile);
        cValues.put(KEY_EMAIL, email);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users, null, cValues);
        db.close();
    }


    // Get User Details
    public ArrayList<HashMap<String, String>> GetUsers() {

        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT id,name, department, university, mobile, email FROM " + TABLE_Users;
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("name", cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("department", cursor.getString(cursor.getColumnIndex(KEY_DEPARTMENT)));
            user.put("university", cursor.getString(cursor.getColumnIndex(KEY_UNIVERSITY)));
            user.put("mobile", cursor.getString(cursor.getColumnIndex(KEY_MOBILE)));
            user.put("email", cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            userList.add(user);
        }
        return userList;
    }


    // Get User Details based on userid
    public ArrayList<HashMap<String, String>> GetUserByUserId(int userid) {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT id,name, department, university, mobile, email FROM " + TABLE_Users;
        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_ID,KEY_NAME, KEY_DEPARTMENT, KEY_UNIVERSITY, KEY_MOBILE, KEY_EMAIL}, KEY_ID + "=?", new String[]{String.valueOf(userid)}, null, null, null, null);
        if (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("id", cursor.getString(cursor.getColumnIndex(KEY_ID)));
            user.put("name", cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            user.put("department", cursor.getString(cursor.getColumnIndex(KEY_DEPARTMENT)));
            user.put("university", cursor.getString(cursor.getColumnIndex(KEY_UNIVERSITY)));
            user.put("mobile", cursor.getString(cursor.getColumnIndex(KEY_MOBILE)));
            user.put("email", cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            userList.add(user);
        }
        return userList;
    }

    // Delete User Details
    public void DeleteUser(int userid) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_ID + " = ?", new String[]{String.valueOf(userid)});
        db.close();
    }

    // Update User Details
    public int UpdateUserDetails(String name, String department, String university, String mobile, String email, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cVals = new ContentValues();
        cVals.put(KEY_ID, id);
        cVals.put(KEY_NAME, name);
        cVals.put(KEY_DEPARTMENT, department);
        cVals.put(KEY_UNIVERSITY, university);
        cVals.put(KEY_MOBILE, mobile);
        cVals.put(KEY_EMAIL, email);
        int count = db.update(TABLE_Users, cVals, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        return count;
    }
}