package com.example.nagendra.movie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import static com.example.nagendra.movie.LoginActivity.mypreference;

public class UserFirstActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {



    SharedPreferences sharedpreferences;

    public static final String mypreference = "mypref";
    public static final String mailid = "emailid";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_first);

        Toolbar toolbar = findViewById(R.id.bar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Movie World");

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);



        //loading the default fragment
        loadFragment(new UserHomeFragment());

        //getting bottom navigation view and attaching the listener
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                fragment = new UserHomeFragment();
                break;

            /*case R.id.navigation_dashboard:
                fragment = new UserHomeFragment();
                break;*/

            /*case R.id.navigation_notifications:
                fragment = new UserNotificationsFragment();
                break;*/

        }
        return loadFragment(fragment);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.logout) {


            SharedPreferences.Editor editor = sharedpreferences.edit();

            editor.clear();
            editor.commit();

            Intent intent = new Intent(UserFirstActivity.this,LoginActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        if (id == R.id.navigation_notifications) {
            Intent intent = new Intent(UserFirstActivity.this,UserNotificationActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(UserFirstActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
