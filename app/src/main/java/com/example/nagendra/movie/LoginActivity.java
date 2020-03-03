package com.example.nagendra.movie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nagendra.movie.Database.SqliteHelper;
import com.example.nagendra.movie.Models.User;
import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginActivity extends AppCompatActivity {

    MaterialEditText user_login,password_login;
    Button user_btn_login;
    TextView registerref,adminlogin;
    SqliteHelper sqliteHelper = new SqliteHelper(this);
    SharedPreferences sharedpreferences;
    public static final String mypreference = "mypref";
    public static final String Name = "emailid";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);


        initFun();

        registerref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,AdminLoginActivity.class);
                startActivity(intent);
            }
        });


        user_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = user_login.getText().toString().trim();
                String password = password_login.getText().toString().trim();

                if(TextUtils.isEmpty(id) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(LoginActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    User user = sqliteHelper.Authenticate(new User(null, null, id, password));

                    if (user != null)
                    {
                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(Name, id);
                        editor.commit();

                        Intent intent = new Intent(LoginActivity.this,UserFirstActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Login Failure", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(LoginActivity.this,LoginActivity.class));
                        finish();
                    }

                }
            }
        });

    }

    private void initFun() {

        user_login = (MaterialEditText)findViewById(R.id.user_login);
        password_login = (MaterialEditText)findViewById(R.id.password_login);
        user_btn_login = (Button) findViewById(R.id.user_btn_login);
        registerref = (TextView) findViewById(R.id.registerref);
        adminlogin = (TextView) findViewById(R.id.adminlogin);


    }
}
