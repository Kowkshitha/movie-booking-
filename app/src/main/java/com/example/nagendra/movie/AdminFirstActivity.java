package com.example.nagendra.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminFirstActivity extends AppCompatActivity {

    Button userslist,usersbookinglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_first);

        initFun();

        userslist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminFirstActivity.this,UsersListActivity.class);
                startActivity(intent);
            }
        });
        usersbookinglist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminFirstActivity.this,UsersBookingListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initFun() {

        userslist = (Button)findViewById(R.id.userslist);
        usersbookinglist = (Button)findViewById(R.id.usersbookinglist);
    }
}
