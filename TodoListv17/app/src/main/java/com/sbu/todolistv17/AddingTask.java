package com.sbu.todolistv17;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import static com.sbu.todolistv17.MainActivity.Task_List;

public class AddingTask extends AppCompatActivity {
    final Context context = this;
    EditText title,description,expiration;
    Intent i = getIntent();
    Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

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
