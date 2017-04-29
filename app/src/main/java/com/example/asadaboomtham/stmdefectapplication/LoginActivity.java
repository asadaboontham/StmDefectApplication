package com.example.asadaboomtham.stmdefectapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.asadaboomtham.stmdefectapplication.R.id.btnLogin;

public class LoginActivity extends AppCompatActivity {

    public Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(btnLogin);
        btnlogin.setOnClickListener(OnClickSubmitListener);
    }
    private View.OnClickListener OnClickSubmitListener = new View.OnClickListener() {//crtl+shift+spacebar
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), ProjectActivity.class);
            startActivity(i);

        }
    };
}