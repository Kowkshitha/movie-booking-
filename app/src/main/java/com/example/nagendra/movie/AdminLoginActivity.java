package com.example.nagendra.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class AdminLoginActivity extends AppCompatActivity {

    MaterialEditText admin_login,admin_password_login;
    Button admin_btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        initFun();

        admin_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminlogintext = admin_login.getText().toString().trim();
                String adminpasswordtext = admin_password_login.getText().toString().trim();

                if(TextUtils.isEmpty(adminlogintext) || TextUtils.isEmpty(adminpasswordtext))
                {
                    Toast.makeText(AdminLoginActivity.this, "All fields are Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(adminlogintext.equals("admin") && adminpasswordtext.equals("admin"))
                    {
                        Toast.makeText(AdminLoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(AdminLoginActivity.this,AdminFirstActivity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(AdminLoginActivity.this, "userid or password are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    private void initFun() {

        admin_login = (MaterialEditText)findViewById(R.id.admin_login);
        admin_password_login = (MaterialEditText)findViewById(R.id.admin_password_login);
        admin_btn_login = (Button) findViewById(R.id.admin_btn_login);
    }
}
