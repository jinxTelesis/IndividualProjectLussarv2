package com.example.dre.individualprojectlussarv2;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.nfc.FormatException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActRecfactor extends AppCompatActivity {

    private Button mRegB;
    private TextView tV1;

    private EditText eTFN;
    private EditText eTLN;
    private EditText eTUN;
    private EditText eTP;
    private EditText eTEm;
    private EditText eTDOB;

    private Toast etyFormToast;

    private String mFirstNameReturn ="";
    private String mLastNameReturn ="";
    private String mUserNameReturn="";
    private String mPasswordReturn="";
    private String mEmailReturn="";
    private String mDOfBirthReturn="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_act_recfactor);

        mRegB = (Button) findViewById(R.id.regidbn);
        this.eTFN = (EditText) findViewById(R.id.eTFN);
        this.eTLN = (EditText) findViewById(R.id.eTLN);
        this.eTUN = (EditText) findViewById(R.id.eTUN);
        this.eTP = (EditText) findViewById(R.id.eTP);
        this.eTDOB = (EditText) findViewById(R.id.eTDOB);
        this.eTEm = (EditText) findViewById(R.id.eTEM);
        final LoginBackend backend = new LoginBackend();

        mRegB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    mFirstNameReturn = String.valueOf(eTFN.getText());
                }catch(Exception e){};

                try{
                    mLastNameReturn = String.valueOf(eTLN.getText());
                }catch(Exception e){};

                try{
                    mUserNameReturn = String.valueOf(eTUN.getText());
                }catch(Exception e){};

                try{
                    mPasswordReturn = String.valueOf(eTP.getText());
                }catch(Exception e){};

                try{
                    mDOfBirthReturn = String.valueOf(eTDOB.getText());
                }catch(Exception e){};

                try{
                    mEmailReturn = String.valueOf(eTEm.getText());
                }catch(Exception e){};


                if(backend.validNonBlank(mUserNameReturn,mPasswordReturn,
                        mFirstNameReturn,mLastNameReturn,mEmailReturn,mDOfBirthReturn))
                {
                    if(backend.addAccount(mUserNameReturn,mPasswordReturn,
                            mFirstNameReturn,mLastNameReturn,mEmailReturn,mDOfBirthReturn))
                    {
                        // entered a valid account now returned to login

                        Intent intent = new Intent(RegActRecfactor.this, LoginActivity.class);
                        startActivity(intent);
                        finish();

                    }
                    else // entered an invalid account reprompted
                    { // reprompt base on tf returns of backend
                        Context context = getApplicationContext();
                        CharSequence text = "Account already exists!";
                        int duration = Toast.LENGTH_LONG;
                        eTUN.setTextColor(Color.RED);
                        eTUN.setText("Username taken");
                        eTUN.setTextColor(Color.RED);

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                    }
                }
                else
                {
                    // toast of failed login
                    Context context = getApplicationContext();
                    CharSequence text = "One or more fields required!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    if(mFirstNameReturn.equals(""))
                    {
                        eTFN.setTextColor(Color.RED);
                        eTFN.setText("Invalid First Name");
                        eTFN.setTextColor(Color.GRAY);
                    }

                    if(mLastNameReturn.equals(""))
                    {
                        eTLN.setTextColor(Color.RED);
                        eTLN.setText("Invalid Last Name");
                        eTLN.setTextColor(Color.GRAY);
                    }

                    if(mUserNameReturn.equals(""))
                    {
                        eTUN.setTextColor(Color.RED);
                        eTUN.setText("Invalid User Name");
                        eTUN.setTextColor(Color.GRAY);
                    }

                    if(mPasswordReturn.equals(""))
                    {
                        eTP.setTextColor(Color.RED);
                        eTP.setText("Invalid Password");
                        eTP.setTextColor(Color.GRAY);
                    }

                    if(mDOfBirthReturn.equals(""))
                    {
                        eTDOB.setTextColor(Color.RED);
                        eTDOB.setText("Invalid Date of Birth");
                        eTDOB.setTextColor(Color.GRAY);
                    }

                    if(mEmailReturn.equals(""))
                    {
                        eTEm.setTextColor(Color.RED);
                        eTEm.setText("Invalid Email");
                        eTEm.setTextColor(Color.GRAY);
                    }
                }

            }
        });


    }
}
