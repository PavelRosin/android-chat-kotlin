package edu_chat.android.com.edu_chat.adapter.digitalofficehour;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import chat.edu.edu_chat.R.id;
import chat.edu.edu_chat.R.layout;

import java.text.SimpleDateFormat;
import java.util.List;

import edu_chat.android.com.edu_chat.controller.digitalofficehours.EditOfficeHourActivity;

/**
 * Created by yuandali on 7/20/16.
 * Edu.Chat Inc.
 */
public class ClassOfficeHourListAdapter extends Adapter {

    private static final int EMPTY_VIEW = -1;
    private final List<SimpleDateFormat> classOfficeHourList;
    private final AppCompatActivity activity;

    public ClassOfficeHourListAdapter(final AppCompatActivity activity, final List<SimpleDateFormat>
            classOfficeHourList) {
        super();
        this.activity = activity;
        this.classOfficeHourList = classOfficeHourList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        final View itemView;
        if (viewType == EMPTY_VIEW) {
            itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(layout.empty_office_hour_view, parent, false);
            return new EmptyViewHolder(itemView);
        } else {
            itemView = LayoutInflater.
                    from(parent.getContext()).
                    inflate(layout.item_office_hour_class, parent, false);
            return new OfficeHourViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (this.classOfficeHourList.isEmpty()) {
        } else {
            final OfficeHourViewHolder officeHourViewHolder =
                    (OfficeHourViewHolder) holder;
            if (position == 0) {
                officeHourViewHolder.setOfficeHourDay("Monday");
                officeHourViewHolder.setOfficeHourTime("12:30PM - 1:30PM");
            } else if (position == 1) {
                officeHourViewHolder.setOfficeHourDay("Wednesday");
                officeHourViewHolder.setOfficeHourTime("2:00PM - 3:00PM");
            } else if (position == 2) {
                officeHourViewHolder.setOfficeHourDay("Friday");
                officeHourViewHolder.setOfficeHourTime("3:00PM - 4:00PM");
            }
        }
    }

    @Override
    public int getItemViewType(final int position) {
        return this.classOfficeHourList.isEmpty() ? EMPTY_VIEW : super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.classOfficeHourList.isEmpty() ? 1 : this.classOfficeHourList.size();
    }

    private static final class EmptyViewHolder extends ViewHolder {

        private EmptyViewHolder(@NonNull final View itemView) {
            super(itemView);
        }
    }

    private final class OfficeHourViewHolder extends ViewHolder implements OnClickListener {

        private final TextView dayTextView;
        private final TextView timeTextView;

        private OfficeHourViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.dayTextView = itemView.findViewById(id.dayTextView);
            this.timeTextView = itemView.findViewById(id.timeTextView);
        }

        private void setOfficeHourDay(final String day) {
            this.dayTextView.setText(day);
        }

        private void setOfficeHourTime(final String hour) {
            this.timeTextView.setText(hour);
        }

        @Override
        public void onClick(final View v) {
            Toast.makeText(ClassOfficeHourListAdapter.this.activity.getBaseContext(), "Go to " +
                    "office hour edit page.", Toast
                                   .LENGTH_SHORT).show();
            final Intent intent = new Intent(
                    ClassOfficeHourListAdapter.this.activity,
                    EditOfficeHourActivity.class
            );
            ClassOfficeHourListAdapter.this.activity.startActivity(intent);
        }
    }
}
