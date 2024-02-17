package com.sbu.todolistv15;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AddingActivity extends AppCompatActivity {
    public List<Task> lot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        lot = new ArrayList<Task>();

    }

    /*public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("my_string", "Welcome back!");
        super.onSaveInstanceState(savedInstanceState);
    }*/

    public void Returning(View v){
        Intent i = new Intent(this , MainActivity.class);

        EditText etNewItem = (EditText) findViewById(R.id.editText3);
        String itemText = etNewItem.getText().toString();
        MainActivity.itemsAdapter.add(itemText);
        etNewItem.setText("");
        // data haro bayad too constructor e Task berizim!!

        startActivity(i);
    }
}
