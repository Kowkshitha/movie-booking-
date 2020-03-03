package com.example.nagendra.movie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nagendra.movie.Database.SqliteHelper;
import com.example.nagendra.movie.Models.TheatreModel;
import com.example.nagendra.movie.adapters.YourBookingAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.nagendra.movie.LoginActivity.mypreference;

public class UserNotificationActivity extends AppCompatActivity {

    ListView yourbookinglist;

    SharedPreferences sharedpreferences;

    public static final String mypreference = "mypref";
    public static final String mailid = "emailid";

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    List<TheatreModel> theatreModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_notification);
        Toolbar toolbar = findViewById(R.id.bar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ticket Booking List");
        yourbookinglist = (ListView)findViewById(R.id.yourbookinglist);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        final String userid = sharedpreferences.getString(mailid, "");

        Cursor cursor = sqliteHelper.getCount(userid);

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No Bookings", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                TheatreModel theatreModel = new TheatreModel();


                theatreModel.setMoviename(cursor.getString(1));
                theatreModel.setTheatrename(cursor.getString(2));
                theatreModel.setNoofseats(cursor.getString(3));

                theatreModelList.add(theatreModel);
            }
        }

        YourBookingAdapter yourBookingAdapter = new YourBookingAdapter(this,theatreModelList);
        yourbookinglist.setAdapter(yourBookingAdapter);



    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(UserNotificationActivity.this,UserFirstActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {


            SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.clear();
            editor.commit();

            Intent intent = new Intent(UserNotificationActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.home) {
            Intent intent = new Intent(UserNotificationActivity.this,UserFirstActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}
