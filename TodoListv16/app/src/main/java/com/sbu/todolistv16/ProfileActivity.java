package com.sbu.todolistv16;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ProfileActivity extends AppCompatActivity {
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        TextView nameTxt = findViewById(R.id.nameText);
        TextView nameTxt2 = findViewById(R.id.des);
        TextView nameTxt3 = findViewById(R.id.date);
        done = (Button) findViewById(R.id.donebtn);

        String username = "Username not set";
        String description = "description not set";
        String expiration = "expiration not set";

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            username = extras.getString("username");
            description = extras.getString("description");
            expiration = extras.getString("expiration");
        }

        nameTxt.setText(username);
        nameTxt2.setText(description);
        nameTxt3.setText(expiration);

        /*done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                RelativeLayout r1 = (RelativeLayout) findViewById(R.id.ListItemLayout);
                r1.setBackgroundColor(Color.BLUE);
                startActivity(i);
            }
        });*/
    }
}

