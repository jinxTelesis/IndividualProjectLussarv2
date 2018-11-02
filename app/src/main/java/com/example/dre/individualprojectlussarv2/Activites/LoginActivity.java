package com.example.dre.individualprojectlussarv2.Activites;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dre.individualprojectlussarv2.Model.LoginBackend;
import com.example.dre.individualprojectlussarv2.R;

public class LoginActivity extends AppCompatActivity {

    private Button mLb;
    private Button mRb;
    private EditText eTUn;
    private EditText eTPa;
    private String mUserNameReturn;
    private String mPasswordReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLb = (Button) findViewById(R.id.loginbtnid);
        mRb = (Button) findViewById(R.id.regbtnid);

        eTUn = (EditText)findViewById(R.id.eTUnLogin);
        eTPa = (EditText)findViewById(R.id.eTPaLogin2);


        mLb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginBackend backend = new LoginBackend();

                try{
                    mUserNameReturn = String.valueOf(eTUn.getText());
                }catch(Exception e){};

                try{
                    mPasswordReturn = String.valueOf(eTPa.getText());
                }catch(Exception e){};

                if(backend.validUnPass(mUserNameReturn,mPasswordReturn))
                {
                    Intent intent1 = new Intent(LoginActivity.this, ProgramActivity.class);
                    startActivity(intent1);
                    finish();
                }
                else
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid user or password, please register or correct!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    eTUn.setTextColor(Color.RED);
                    eTPa.setTextColor(Color.RED);
                    eTUn.setHint("Invalid username/pass");
                    eTPa.setHint("Invalid username/pass");
                    eTUn.setTextColor(Color.GRAY);
                    eTUn.setTextColor(Color.GRAY);
                }
            }
        });

        mRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(LoginActivity.this, RegActRecfactor.class);
                startActivity(intent2);
                finish();
            }
        });



    }
}

