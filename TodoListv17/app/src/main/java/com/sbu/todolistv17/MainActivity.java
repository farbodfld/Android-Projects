package com.sbu.todolistv17;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<Task> Task_List = new LinkedList<>();
    ListView listView;
    TaskAdapter ListAdapter;
    final Context context = this;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // readItems();
        setTask();
    }

    public void setTask(){
        listView = findViewById(R.id.ListView);
        readItems();
        ListAdapter = new TaskAdapter(this,R.layout.task_layout, Task_List);
        listView.setAdapter(ListAdapter);
       // writeItems();
        button = findViewById(R.id.addTask);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddingTask.class);
                context.startActivity(intent);
            }
        });
    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            Task_List = new ArrayList<Task>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            Task_List = new ArrayList<>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, Task_List);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
