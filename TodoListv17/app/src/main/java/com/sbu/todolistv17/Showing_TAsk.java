package com.sbu.todolistv17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Showing_TAsk extends AppCompatActivity {
    final Context context =this;
    Button done;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        showTask();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , MainActivity.class);
                context.startActivity(intent);
            }
        });
    }

    public void showTask(){
        Intent intent = getIntent();

        TextView  title;
        TextView description;
        TextView expire;

        com.sbu.todolistv17.Task task = (com.sbu.todolistv17.Task)intent.getSerializableExtra("task");

        title = findViewById(R.id.textView3);
        description = findViewById(R.id.textView4);
        expire = findViewById(R.id.textView5);
        done = findViewById(R.id.back);

        title.setText(task.getTitle());
        description.setText(task.getDescription());
        expire.setText(task.getExpire());
    }
}