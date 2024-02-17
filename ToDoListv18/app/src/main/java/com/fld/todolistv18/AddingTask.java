package com.fld.todolistv18;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.fld.todolistv18.MainActivity.Task_List;

public class AddingTask extends AppCompatActivity {
    final Context context = this;
    EditText title,description,expiration;
    Intent i = getIntent();
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_task);

        addTask();
    }


    public void addTask(){
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        expiration = findViewById(R.id.expire);
        button = findViewById(R.id.add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title2 = title.getText().toString();
                String description2 = description.getText().toString();
                String expiration2 = expiration.getText().toString();

                Task_List.add(new Task(title2 , description2 , expiration2));
                Intent intent = new Intent(context , MainActivity.class);
                context.startActivity(intent);
            }
        });
    }
}
