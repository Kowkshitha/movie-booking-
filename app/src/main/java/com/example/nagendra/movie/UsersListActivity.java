package com.example.nagendra.movie;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nagendra.movie.Database.SqliteHelper;
import com.example.nagendra.movie.Models.User;
import com.example.nagendra.movie.adapters.UserAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersListActivity extends AppCompatActivity {

    ListView users_list_view;
    SqliteHelper sqliteHelper = new SqliteHelper(this);
    List<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        users_list_view = (ListView)findViewById(R.id.users_list_view);

        Cursor cursor = sqliteHelper.getAllUsers();

        if(cursor.getCount() == 0)
        {
            Toast.makeText(this, "No Users", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                User user = new User();

                user.setUsername(cursor.getString(1));
                user.setUserphonenumber(cursor.getString(2));
                user.setUseremailid(cursor.getString(3));
                user.setUserpassword(cursor.getString(4));

                users.add(user);
            }
        }

        UserAdapter userAdapter = new UserAdapter(this,users);
        users_list_view.setAdapter(userAdapter);
    }
}
