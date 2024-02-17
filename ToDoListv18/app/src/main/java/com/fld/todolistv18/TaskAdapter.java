package com.fld.todolistv18;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import static com.fld.todolistv18.Showing_Task.done;

public class TaskAdapter extends ArrayAdapter<Task> {
    public static class ViewHolder {
        static TextView titleText;
        static Switch done_switch;
    }

    private Context context;
    private int resource;

    public TaskAdapter(@NonNull Context context, int resource, @NonNull List<Task> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        final Task task = getItem(position);

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(this.resource, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleText = convertView.findViewById(R.id.TitleText);
            viewHolder.done_switch = convertView.findViewById(R.id.doneBtn);
            if (task.getDone()) {
                viewHolder.titleText.setBackgroundColor(Color.YELLOW);
            } else {
                viewHolder.titleText.setBackgroundColor(Color.LTGRAY);
            }
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.titleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Showing_Task.class);
                intent.putExtra("task", task);
                context.startActivity(intent);
            }

        });
        viewHolder.done_switch.setChecked(task.getDone());
        viewHolder.done_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setIsDone(!task.getDone());
                if (task.getDone() ) {
                   // done.setChecked(true);
                    viewHolder.titleText.setBackgroundColor(Color.YELLOW);
                } else {
                   // done.setChecked(false);
                    viewHolder.titleText.setBackgroundColor(Color.LTGRAY);
                }

            }
        });

        viewHolder.titleText.setText(task.getTitle());
        return convertView;
    }
}
