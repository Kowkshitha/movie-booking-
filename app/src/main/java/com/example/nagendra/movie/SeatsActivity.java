package com.example.nagendra.movie;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.nagendra.movie.Database.SqliteHelper;
import com.example.nagendra.movie.Models.TheatreModel;

import java.nio.channels.CancelledKeyException;

import static com.example.nagendra.movie.LoginActivity.mypreference;
import static com.example.nagendra.movie.RegisterActivity.MyPREFERENCES;

public class SeatsActivity extends AppCompatActivity {

    CheckBox one_one,one_two,one_three,one_four,one_five,one_six,one_seven,
            two_one,two_two,two_three,two_four,two_five,two_six,
            three_one,three_two,three_three,three_four,three_five,
            four_one,four_two,four_three,four_four,
            five_one,five_two,five_three;
    Button book_tickets;
    SharedPreferences sharedpreferences;
    SharedPreferences sharedpreferences1;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =112 ;
    SqliteHelper sqliteHelper = new SqliteHelper(this);


    public static final String Name = "emailid";
    public static final String moviename = "moviename";
    public static final String theatrename = "theatrename";
    public static final String Name1 = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    String phoneNo;
    String message;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);

        //Bundle extras = getIntent().getExtras();

        /*final String moviename = extras.getString("moviename");
        final String theatrename = extras.getString("theatrename");
*/
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        sharedpreferences1 = getSharedPreferences(MyPREFERENCES,
                Context.MODE_PRIVATE);

        final String userid = sharedpreferences.getString(Name, "");
        final String movie_name = sharedpreferences.getString(moviename, "");
        final String theatre_name = sharedpreferences.getString(theatrename, "");
        final String user_name = sharedpreferences1.getString(Name1, "");
        final String phone = sharedpreferences1.getString(Phone, "");

        //sendsms(phone,"this is test message");
        initFun();




        book_tickets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int count=0;

                if(one_one.isChecked())
                {
                    count++;
                }
                if(one_two.isChecked())
                {
                    count++;
                }
                if(one_three.isChecked())
                {
                    count++;
                }
                if(one_four.isChecked())
                {
                    count++;
                }
                if(one_five.isChecked())
                {
                    count++;
                }
                if(one_six.isChecked())
                {
                    count++;
                }
                if(one_seven.isChecked())
                {
                    count++;
                }
                if(two_one.isChecked())
                {
                    count++;
                }
                if(two_two.isChecked())
                {
                    count++;
                }
                if(two_three.isChecked())
                {
                    count++;
                }
                if(two_four.isChecked())
                {
                    count++;
                }
                if(two_five.isChecked())
                {
                    count++;
                }
                if(two_six.isChecked())
                {
                    count++;
                }
                if(three_one.isChecked())
                {
                    count++;
                }
                if(three_two.isChecked())
                {
                    count++;
                }
                if(three_three.isChecked())
                {
                    count++;
                }
                if(three_four.isChecked())
                {
                    count++;
                }
                if(three_five.isChecked())
                {
                    count++;
                }
                if(four_one.isChecked())
                {
                    count++;
                }
                if(four_two.isChecked())
                {
                    count++;
                }
                if(four_three.isChecked())
                {
                    count++;
                }
                if(four_four.isChecked())
                {
                    count++;
                }
                if(five_one.isChecked())
                {
                    count++;
                }
                if(five_two.isChecked())
                {
                    count++;
                }
                if(five_three.isChecked())
                {
                    count++;
                }

                TheatreModel theatreModel = new TheatreModel();

                theatreModel.setUsermailid(userid);
                theatreModel.setMoviename(movie_name);
                theatreModel.setTheatrename(theatre_name);
                theatreModel.setNoofseats(String.valueOf(count));

                phoneNo = phone;
                message = user_name+" has booked"+ count+" Tickets  Successfully in "+theatre_name+" for "+movie_name+" by "+userid;
                //sendsms(phoneNo,message);

                long register_statu = sqliteHelper.addMovie(theatreModel);
                if (register_statu != -1)
                {

                  //  sendSMSMessage(phone,user_name +count+"booked Tickets in "+theatre_name+" for "+movie_name+" by "+userid);
                    Intent intent = new Intent(SeatsActivity.this,UserInformation.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(SeatsActivity.this, "Booking Failure.Try again", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SeatsActivity.this,UserFirstActivity.class));
                    finish();
                }
            }
        });



    }


    private void initFun() {

        one_one = (CheckBox)findViewById(R.id.one_one);
        one_two = (CheckBox)findViewById(R.id.one_two);
        one_three = (CheckBox)findViewById(R.id.one_three);
        one_four = (CheckBox)findViewById(R.id.one_four);
        one_five = (CheckBox)findViewById(R.id.one_five);
        one_six = (CheckBox)findViewById(R.id.one_six);
        one_seven = (CheckBox)findViewById(R.id.one_seven);

        two_one = (CheckBox)findViewById(R.id.two_one);
        two_two = (CheckBox)findViewById(R.id.two_two);
        two_three = (CheckBox)findViewById(R.id.two_three);
        two_four = (CheckBox)findViewById(R.id.two_four);
        two_five = (CheckBox)findViewById(R.id.two_five);
        two_six = (CheckBox)findViewById(R.id.two_six);

        three_one = (CheckBox)findViewById(R.id.three_one);
        three_two = (CheckBox)findViewById(R.id.three_two);
        three_three = (CheckBox)findViewById(R.id.three_three);
        three_four = (CheckBox)findViewById(R.id.three_four);
        three_five = (CheckBox)findViewById(R.id.three_five);

        four_one = (CheckBox)findViewById(R.id.four_one);
        four_two = (CheckBox)findViewById(R.id.four_two);
        four_three = (CheckBox)findViewById(R.id.four_three);
        four_four = (CheckBox)findViewById(R.id.four_four);

        five_one = (CheckBox)findViewById(R.id.five_one);
        five_two = (CheckBox)findViewById(R.id.five_two);
        five_three = (CheckBox)findViewById(R.id.five_three);

        book_tickets = (Button)findViewById(R.id.book_tickets);


    }


    void sendsms(String mblNumVar, String smsMsgVar)
    {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
        {
            try
            {
                SmsManager smsMgrVar = SmsManager.getDefault();
                smsMgrVar.sendTextMessage(mblNumVar, null, smsMsgVar, null, null);
                Toast.makeText(getApplicationContext(), "Message Sent",
                        Toast.LENGTH_LONG).show();
            }
            catch (Exception ErrVar)
            {
                Toast.makeText(getApplicationContext(),ErrVar.getMessage().toString(),
                        Toast.LENGTH_LONG).show();
                ErrVar.printStackTrace();
            }
        }
        else
        {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            {
                requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 10);
            }
        }

    }

}
