package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    public static String[] UserName = new String[99];
    public static String[] passWord = new String[99];
    public static String[] GeNder = new String[99];
    public static int registeredNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView Password1 = findViewById(R.id.password1);
        TextView Password2 = findViewById(R.id.confirmpassword);
        TextView  Uname = findViewById(R.id.username1);
        Button btn = findViewById(R.id.Register);
        TextView Sup = findViewById(R.id.GoBack);
        CheckBox checkboxTndS = findViewById(R.id.termsANDservices);
        RadioButton radiobtnMale = findViewById(R.id.radioButton);
        RadioButton radiobtnFeMale = findViewById(R.id.radioButton2);

        Sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
            }
        });



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkboxTndS.isChecked()){
                    if(Password1.getText().toString().equals(Password2.getText().toString())){
                        UserName[registeredNum] = Uname.getText().toString();
                        passWord[registeredNum] = Password1.getText().toString();
                        if(radiobtnMale.isChecked()){
                            GeNder[registeredNum] = radiobtnMale.getText().toString();
                        }else{
                            GeNder[registeredNum] = radiobtnFeMale.getText().toString();
                        }

                        Toast.makeText(RegisterActivity.this,"<< User: " + UserName[registeredNum] + " has been registered >>",Toast.LENGTH_SHORT).show();
                        registeredNum++;
                    }
                    else{
                        Toast.makeText(RegisterActivity.this,"<< The password does not match >>",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"<<You need to agree to the terms and services>>",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
