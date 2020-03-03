package com.example.nagendra.movie;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserInformation extends AppCompatActivity {

    Button payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        payment =  findViewById(R.id.completeorder);

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserInformation.this,"Tickets Booked Successfully...!!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInformation.this,UserNotificationActivity.class);
                startActivity(intent);
            }
        });

    }
}
