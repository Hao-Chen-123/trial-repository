package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Password =(TextView) findViewById(R.id.password);
        TextView  Uname = (TextView) findViewById(R.id.username);
        Button btn = (Button) findViewById(R.id.Register);
        TextView Sup = findViewById(R.id.GoBack);

        Sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean login = false;
                for(int x = 0; x < RegisterActivity.registeredNum;x++){
                    if(Password.getText().toString().equals(RegisterActivity.passWord[x]) && Uname.getText().toString().equals(RegisterActivity.UserName[x])){
                        Toast.makeText(MainActivity.this,"<< Welcome : " + RegisterActivity.UserName[x] + " >>"+
                                "<<\n Gender : " + RegisterActivity.GeNder[x] + " >>",Toast.LENGTH_SHORT).show();


                        login = true;
                    }
                }
                if(login == false){
                    Toast.makeText(MainActivity.this,"<< Wrong Log In Credentials >>",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}