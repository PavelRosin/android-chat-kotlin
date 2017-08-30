package edu_chat.android.com.edu_chat.adapter.digitalofficehour;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import chat.edu.edu_chat.R.id;
import chat.edu.edu_chat.R.layout;

import java.util.List;

import edu_chat.android.com.edu_chat.controller.digitalofficehours.OfficeHourForClassFragment;

/**
 * Created by yuandali on 7/20/16.
 * Edu.Chat Inc.
 */
public class DigitalOfficeHourListAdapter extends Adapter {

    private static final int EMPTY_VIEW = -1;
    private final List<OfficeHourViewHolder> digitalOfficeHourList;
    private final AppCompatActivity activity;

    public DigitalOfficeHourListAdapter(final AppCompatActivity activity, final
    List<OfficeHourViewHolder>
            digitalOfficeHourList) {
        super();
        this.digitalOfficeHourList = digitalOfficeHourList;
        this.activity = activity;
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
                    inflate(layout.item_office_hour_overview, parent, false);
            return new OfficeHourViewHolder(itemView);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
//        if (holder.getItemViewType() == EMPTY_VIEW) {
//        } else {
//            final OfficeHourViewHolder officeHourViewHolder =
//                    (OfficeHourViewHolder) holder;
//            officeHourViewHolder.setClassName(this.digitalOfficeHourList.get(position)
//                                                      .getClassName());
//            officeHourViewHolder.setDigitalOfficeHoursInfo(this.digitalOfficeHourList.get(position)
//                                                                   .getOfficeHourCount());
//        }
    }

    @Override
    public int getItemViewType(final int position) {
        return this.digitalOfficeHourList.isEmpty() ? EMPTY_VIEW : super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return this.digitalOfficeHourList.isEmpty() ? 1 : this.digitalOfficeHourList.size();
    }

    private static final class EmptyViewHolder extends ViewHolder {

        private EmptyViewHolder(@NonNull final View itemView) {
            super(itemView);
        }
    }

    private final class OfficeHourViewHolder extends ViewHolder implements OnClickListener {

        private final TextView officeHourNameTextView;
        private final TextView officeHourInfoTextView;

        private OfficeHourViewHolder(@NonNull final View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.officeHourNameTextView = itemView.findViewById(id
                                                                        .officeHourNameTextView);
            this.officeHourInfoTextView = itemView.findViewById(id
                                                                        .officeHourInfoTextView);
        }

        private void setClassName(final String className) {
            this.officeHourNameTextView.setText(className);
        }

        private void setDigitalOfficeHoursInfo(final int num) {
            this.officeHourInfoTextView.setText(String.format("%d Office Hour(s)", num));
        }

        @Override
        public void onClick(final View v) {
            final OfficeHourForClassFragment officeHourForClassFragment = new
                    OfficeHourForClassFragment();
            final FragmentTransaction ft = DigitalOfficeHourListAdapter.this.activity
                    .getSupportFragmentManager().beginTransaction();
            ft.replace(id.digital_office_hours_fragment, officeHourForClassFragment);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
