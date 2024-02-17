package com.fld.todolistv18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import static com.fld.todolistv18.TaskAdapter.ViewHolder.done_switch;
import static com.fld.todolistv18.TaskAdapter.ViewHolder.titleText;

public class Showing_Task extends AppCompatActivity {
    final Context context = this;
    static Switch done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing__task);

        showTask();

        /*done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                *//*Intent intent = new Intent(context , MainActivity.class);
                context.startActivity(intent);*//*
                if (done.isChecked() ) {
                    done_switch.setChecked(true);
                    titleText.setBackgroundColor(Color.YELLOW);
                }
            }
        });*/
    }

    public void showTask() {
        Intent intent = getIntent();

        TextView title;
        TextView description;
        TextView expire;

        final com.fld.todolistv18.Task task = (com.fld.todolistv18.Task) intent.getSerializableExtra("task");

       /* done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!task.getDone()){
                    done_switch.setChecked(true);
                    done.setChecked(true);
                }else {
                    done_switch.setChecked(true);
                    done.setChecked(true);
                }
            }
        });*/

        title = findViewById(R.id.textView3);
        description = findViewById(R.id.textView4);
        expire = findViewById(R.id.textView5);
        done = findViewById(R.id.back);

        title.setText(task.getTitle());
        description.setText(task.getDescription());
        expire.setText(task.getExpire());
       // done.setChecked(task.getDone());
       // done_switch.setChecked(true);
        done.setChecked(task.getDone());
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setIsDone(!task.getDone());
                if (task.getDone() ) {
                    done_switch.setChecked(true);
                    titleText.setBackgroundColor(Color.YELLOW);
                } else {
                    done_switch.setChecked(false);
                    titleText.setBackgroundColor(Color.LTGRAY);
                }

            }
        });
    }
}
