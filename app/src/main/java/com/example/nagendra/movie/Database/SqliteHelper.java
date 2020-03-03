package com.example.nagendra.movie.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nagendra.movie.Models.TheatreModel;
import com.example.nagendra.movie.Models.User;

import java.util.ArrayList;
import java.util.List;


public class SqliteHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "movie.db";
    public static final int DATABASE_VERSION = 1;


    //tables
    public static final String TABLE_USER = "user";
    public static final String TABLE_BOOKING = "moviebooking";

    //user table data
    public static final String KEY_ID = "id";

    public static final String KEY_USER_NAME = "username";
    public static final String KEY_USER_NUMBER = "usernumber";
    public static final String KEY_USER_MAIL_ID = "usermailid";
    public static final String KEY_USER_PASSWORD = "userpassword";

    //moviebooking table data
    public static final String KEY_MOVIE_ID = "id";

    public static final String KEY_USER_MAILID = "mailid";
    public static final String KEY_MOVIE_NAME = "moviename";
    public static final String KEY_THEATRE_NAME = "theatrename";
    public static final String KEY_NOOF_SEATS = "noofseats";


    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //SQL for creating USER table
    public static final String SQL_TABLE_USER = " CREATE TABLE " + TABLE_USER
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_USER_NUMBER + " TEXT, "
            + KEY_USER_MAIL_ID + " TEXT,"
            + KEY_USER_PASSWORD + " TEXT"
            + " ) ";

    //SQL for creating USER table
    public static final String SQL_TABLE_MOVIE = " CREATE TABLE " + TABLE_BOOKING
            + " ( "
            + KEY_MOVIE_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_MAILID + " TEXT, "
            + KEY_MOVIE_NAME + " TEXT, "
            + KEY_THEATRE_NAME + " TEXT,"
            + KEY_NOOF_SEATS + " TEXT"
            + " ) ";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Create Table when oncreate gets called
        sqLiteDatabase.execSQL(SQL_TABLE_USER);
        sqLiteDatabase.execSQL(SQL_TABLE_MOVIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //drop table to create new one if database version updated
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_USER);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_BOOKING);
        onCreate(sqLiteDatabase);
    }

    //using this method we can add users to user table
    public long addMovie(TheatreModel theatreModel) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_USER_MAILID, theatreModel.getUsermailid());
        values.put(KEY_MOVIE_NAME, theatreModel.getMoviename());
        values.put(KEY_THEATRE_NAME, theatreModel.getTheatrename());
        values.put(KEY_NOOF_SEATS, theatreModel.getNoofseats());


        // insert row
        long todo_id1 = db.insert(TABLE_BOOKING, null, values);

        return todo_id1;

    }

    //using this method we can add users to user table
    public long addUser(User user) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_USER_NAME, user.getUsername());
        values.put(KEY_USER_NUMBER, user.getUserphonenumber());
        values.put(KEY_USER_MAIL_ID, user.getUseremailid());
        values.put(KEY_USER_PASSWORD, user.getUserpassword());


        // insert row
        long todo_id = db.insert(TABLE_USER, null, values);

        return todo_id;

    }
    public User Authenticate(User user) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor1 = db.query(TABLE_USER,// Selecting Table
                new String[]{KEY_ID, KEY_USER_NAME, KEY_USER_NUMBER, KEY_USER_MAIL_ID,KEY_USER_PASSWORD},//Selecting columns want to query
                KEY_USER_MAIL_ID + "=?",
                new String[]{user.getUseremailid()},//Where clause
                null, null, null);

        if (cursor1 != null && cursor1.moveToFirst()&& cursor1.getCount()>0) {
            //if cursor has value then in user database there is user associated with this given email
            User user1 = new User(cursor1.getString(1), cursor1.getString(2), cursor1.getString(3),cursor1.getString(4));

            //Match both passwords check they are same or not
            if (user.getUserpassword().equalsIgnoreCase(user1.getUserpassword())) {
                return user1;
            }
        }

        //if user password does not matches or there is no record with that email then return @false
        return null;
    }

    /*public Cursor getBookedData(String userid) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_BOOKING+" where "+KEY_USER_MAILID+"="+ userid ,null);
        return cursor;
    }*/

    public Cursor getAllUsers()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_USER,null);
        return cursor;
    }

    public Cursor getAllBookings()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+TABLE_BOOKING,null);
        return cursor;
    }



    public Cursor getCount(String userid)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_BOOKING,
                new String[]{KEY_USER_MAILID, KEY_MOVIE_NAME, KEY_THEATRE_NAME,KEY_NOOF_SEATS},//Selecting columns want to query
                KEY_USER_MAILID + "=?",
                new String[]{userid},//Where clause
                null, null, null);

        return cursor;
    }
}
