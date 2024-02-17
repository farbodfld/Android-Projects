package com.sbu.todolistv16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private recyclerAdapter.RecyclerViewClickListener listener;
    User temp;
    //private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        usersList = new ArrayList<>();
        usersList.add(new User("mamad" ,"slm","52"));
        usersList.add(new User("sh" ,"slm","52"));
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, AddingTask.class);
                context.startActivity(i);
            }
        });

       // setUserInfo();
        setAdapter();
    }

    /*public void AddTask(View v){
        Intent i = new Intent(this , AddingTask.class);
        startActivity(i);
    }*/

    private void setAdapter() {
        setOnClickListener();
        recyclerAdapter adapter = new recyclerAdapter(usersList , listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new recyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext() , ProfileActivity.class);
                intent.putExtra("username" , usersList.get(position).getUsername());
                intent.putExtra("description" , usersList.get(position).getDescription());
                intent.putExtra("expiration" , usersList.get(position).getExpiration());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        // too in tabe bayad constructor hayi ke ba data hayi ke vared shode zakhire konim to list
        /*String username = "";
        String description = "";
        String expiration = "";

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            username = extras.getString("username");
            description = extras.getString("description");
            expiration = extras.getString("expiration");
        }

        usersList.add(new User(username,description,expiration));*/

        /*temp = (User) getIntent().getParcelableExtra("user");
        usersList.add(temp);*/

//        editText = (EditText) findViewById(R.id.editText);
       // String username  = editText.getText().toString();
       // usersList.add(new User(username,"slm","99"));

        /*usersList.add(new User("john","slam man john hastam","99/2/12"));
        usersList.add(new User("Bob" , "man BOB HASTAM" , "33/3/5"));
        usersList.add(new User("Alice" , "man alice hastam" , "55/6/4"));*/
    }
}
