package com.sbu.todolistv16;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddingTask extends AppCompatActivity {
    private recyclerAdapter.RecyclerViewClickListener listener;
    // private EditText editText = findViewById(R.id.editText);
    EditText editText;
    EditText editText2;
    EditText editText3;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_task);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        addButton = (Button) findViewById(R.id.button2);

        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                String username = editText.getText().toString();
                String description = editText2.getText().toString();
                String expiration = editText3.getText().toString();
                /*User user = new User(username , description , expiration);
                i.putExtra("user" , user);*/
                /*i.putExtra("username", username);
                i.putExtra("description", description);
                i.putExtra("expiration", expiration);*/
                User user = new User(username , description , expiration);
                MainActivity.usersList.add(user);
                startActivity(i);

            }
        });
//        setOnClickListener();
    }

    public void AddUser(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    /*private void setOnClickListener() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                *//*intent.putExtra("username" , MainActivity.usersList.get(position).getUsername());
                intent.putExtra("description" , MainActivity.usersList.get(position).getDescription());
                intent.putExtra("expiration" , MainActivity.usersList.get(position).getExpiration());*//*
                startActivity(intent);
            }
        };
    }*/
}
