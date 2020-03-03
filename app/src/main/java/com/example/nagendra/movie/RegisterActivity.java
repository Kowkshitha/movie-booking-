package com.example.nagendra.movie;

import android.app.ProgressDialog;
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

public class RegisterActivity extends AppCompatActivity {

    MaterialEditText username_register, user_phone_register, user_emailid_register, password_register;
    Button user_register;
    TextView loginref;

    SqliteHelper sqliteHelper = new SqliteHelper(this);

    ProgressDialog progressDialog;
    public static final String MyPREFERENCES = "UserData";
    public static final String Name1 = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";
    SharedPreferences sharedpreferences1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        sharedpreferences1 = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        initFun();

        user_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(RegisterActivity.this);
                progressDialog.setMessage("Registering wait..");
                progressDialog.show();

                String username_register_txt = username_register.getText().toString().trim();
                String user_phone_register_txt = user_phone_register.getText().toString().trim();
                String user_emailid_register_txt = user_emailid_register.getText().toString().trim();
                String password_register_txt = password_register.getText().toString().trim();


                SharedPreferences.Editor editor = sharedpreferences1.edit();

                editor.putString(Name1, username_register_txt);
                editor.putString(Phone, user_phone_register_txt);
                editor.putString(Email, user_emailid_register_txt);
                editor.commit();

                if (TextUtils.isEmpty(username_register_txt) || TextUtils.isEmpty(user_phone_register_txt) || TextUtils.isEmpty(user_emailid_register_txt) || TextUtils.isEmpty(password_register_txt)) {
                    Toast.makeText(RegisterActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                } else {
                    User user = new User();

                    user.setUsername(username_register_txt);
                    user.setUserphonenumber(user_phone_register_txt);
                    user.setUseremailid(user_emailid_register_txt);
                    user.setUserpassword(password_register_txt);


                    long register_status = sqliteHelper.addUser(user);

                    if (register_status != -1) {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration Failure", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        finish();
                    }

                }
            }
        });

        loginref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initFun() {

        username_register = (MaterialEditText) findViewById(R.id.username_register);
        user_phone_register = (MaterialEditText) findViewById(R.id.user_phone_register);
        user_emailid_register = (MaterialEditText) findViewById(R.id.user_emailid_register);
        password_register = (MaterialEditText) findViewById(R.id.password_register);
        user_register = (Button) findViewById(R.id.user_register);
        loginref = (TextView) findViewById(R.id.loginref);

    }
}
