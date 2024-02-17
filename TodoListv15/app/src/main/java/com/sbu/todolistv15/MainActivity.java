package com.sbu.todolistv15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> items;
    public static ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                /*R.layout.activity_adding,items*/android.R.layout.simple_list_item_1, items);

        /*lvItems = findViewById(R.id.lvItems);*/

        lvItems.setAdapter(itemsAdapter);
        items.add("First Item");
        items.add("Second Item");

        /*if (savedInstanceState != null) {
            String myString = savedInstanceState.getString("my_string");
        }*/
    }

    public void AddingItem(View v){
        Intent i = new Intent(this , AddingActivity.class);
        startActivity(i);
    }
}
