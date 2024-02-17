package com.sbu.todolistv17;

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

public class TaskAdapter extends ArrayAdapter<Task> {
    public static class ViewHolder {
        TextView titleText;
        Switch done_switch;
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
                Intent intent = new Intent(context, Showing_TAsk.class);
                intent.putExtra("task", task);
                context.startActivity(intent);
            }

        });
        viewHolder.done_switch.setChecked(task.getDone());
        viewHolder.done_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                task.setIsDone(!task.getDone());
                if (task.getDone()) {
                    viewHolder.titleText.setBackgroundColor(Color.YELLOW);
                } else {
                    viewHolder.titleText.setBackgroundColor(Color.LTGRAY);
                }

            }
        });

        viewHolder.titleText.setText(task.getTitle());
        return convertView;
    }
}
