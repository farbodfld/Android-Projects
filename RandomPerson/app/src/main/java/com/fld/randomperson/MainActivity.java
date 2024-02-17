package com.fld.randomperson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private TextView name_txt, number_txt;
    private EditText enterName, unitsCounter;
    private Button add, done, addUnits;
   // private ArrayList<String> users = new ArrayList<>();
    private ArrayList<Integer> units = new ArrayList<>();
    private int count;
    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name_txt = findViewById(R.id.name_tex_view);
        number_txt = findViewById(R.id.unit_tex_view);
        enterName = findViewById(R.id.enter_name);
        unitsCounter = findViewById(R.id.units);
       // add = findViewById(R.id.button);
        done = findViewById(R.id.button2);
        addUnits = findViewById(R.id.button3);
        // myList = findViewById(R.id.my_list);

        addUnits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String counter = unitsCounter.getText().toString();
                count = Integer.parseInt(counter);

                if (counter == null || counter.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "INPUT FIELD IS EMPTY", Toast.LENGTH_SHORT).show();
                } else {
                    units.add(count);
                    unitsCounter.setText("");
                    Toast.makeText(getApplicationContext(), "DONE", Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getInput = enterName.getText().toString();

                if (users.contains(getInput)) {
                    Toast.makeText(getApplicationContext(), "NAME IS ALREADY ADDED", Toast.LENGTH_SHORT).show();
                } else if (getInput == null || getInput.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "INPUT FIELD IS EMPTY", Toast.LENGTH_SHORT).show();
                } else {
                    users.add(getInput);
                    enterName.setText("");
                    Toast.makeText(getApplicationContext(), "ADDED", Toast.LENGTH_SHORT).show();
                    *//*ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this , R.layout.activity_main , users);
                    myList.setAdapter(adapter);
                    enterName.setText(" ");*//*
                }
            }
        });*/

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (/*users.isEmpty() ||*/ units.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "NO PERSON OR NUMBER!!", Toast.LENGTH_SHORT).show();
                } else {
                    int units_number = random.nextInt(count) + 1;
                    String unitsNum = String.valueOf(units_number);
                    for (int i = 0; i < units.size(); i++) {
                        number_txt.setText(unitsNum);
                        // units.remove(units_number);
                    }
                    String name = enterName.getText().toString();
                    name_txt.setText(name);
                    /*int name_number = random.nextInt(users.size());
                    for (int i = 0; i < users.size(); i++) {
                        String name = users.get(name_number);
                        name_txt.setText(name);
                        // users.remove(name);
                    }*/
                }
            }
        });
    }
}
