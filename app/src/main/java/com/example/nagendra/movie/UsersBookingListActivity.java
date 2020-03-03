package com.example.nagendra.movie;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nagendra.movie.Database.SqliteHelper;
import com.example.nagendra.movie.Models.TheatreModel;
import com.example.nagendra.movie.Models.User;
import com.example.nagendra.movie.adapters.UserAdapter;
import com.example.nagendra.movie.adapters.UserBookingAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersBookingListActivity extends AppCompatActivity {


    ListView usersbookinglist;
    SqliteHelper sqliteHelper = new SqliteHelper(this);

    List<TheatreModel> theatreModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_booking_list);


        usersbookinglist = (ListView)findViewById(R.id.usersbookinglist);

        Cursor cursor = sqliteHelper.getAllBookings();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No Bookings", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                TheatreModel theatreModel = new TheatreModel();

                theatreModel.setUsermailid(cursor.getString(1));
                theatreModel.setMoviename(cursor.getString(2));
                theatreModel.setTheatrename(cursor.getString(3));
                theatreModel.setNoofseats(cursor.getString(4));

                theatreModelList.add(theatreModel);
            }
        }

        UserBookingAdapter userBookingAdapter = new UserBookingAdapter(this,theatreModelList);
        usersbookinglist.setAdapter(userBookingAdapter);
    }
}
