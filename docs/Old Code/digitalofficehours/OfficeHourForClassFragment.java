package edu_chat.android.com.edu_chat.controller.digitalofficehours;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import chat.edu.edu_chat.R.id;
import chat.edu.edu_chat.R.layout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu_chat.android.com.edu_chat.adapter.digitalofficehour.ClassOfficeHourListAdapter;
import edu_chat.android.com.edu_chat.view.DividerItemDecoration;

/**
 * Created by yuandali on 7/20/16.
 * Edu.Chat Inc.
 */
public class OfficeHourForClassFragment extends Fragment {

    @NonNull private final List<SimpleDateFormat> officeHourList = new ArrayList<>();
    @Nullable
    @BindView(id.classOfficeHourRecyclerView)
    RecyclerView classOfficeHourRecyclerView;
    @Nullable
    @BindView(id.addOfficeHourTextView)
    TextView addOfficeHourTextView;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle
                                     savedInstanceState) {
        final View view = inflater.inflate(layout.fragment_office_hour_for_class, container, false);
        ButterKnife.bind(this, view);

        this.retrieveClassOfficeHours();

        this.addOfficeHourTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Intent intent = new Intent(
                        OfficeHourForClassFragment.this.getActivity(),
                        EditOfficeHourActivity.class
                );
                OfficeHourForClassFragment.this.getActivity().startActivity(intent);
            }
        });

        return view;
    }

    private void retrieveClassOfficeHours() {
        for (int i = 0; i < 3; i++) {
            this.officeHourList.add(new SimpleDateFormat());
        }
        this.populateClassOfficeHoursView();
    }

    private void populateClassOfficeHoursView() {
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final ClassOfficeHourListAdapter classOfficeHourListAdapter = new
                        ClassOfficeHourListAdapter(
                        (AppCompatActivity) OfficeHourForClassFragment
                                .this.getActivity(),
                        OfficeHourForClassFragment.this.officeHourList
                );
                OfficeHourForClassFragment.this.classOfficeHourRecyclerView.addItemDecoration(new
                                                                                                      DividerItemDecoration
                                                                                                      (OfficeHourForClassFragment.this.getActivity()));
                OfficeHourForClassFragment.this.classOfficeHourRecyclerView.setHasFixedSize(false);
                OfficeHourForClassFragment.this.classOfficeHourRecyclerView.setLayoutManager(new
                                                                                                     LinearLayoutManager(
                        OfficeHourForClassFragment.this.getActivity
                                ()));
                OfficeHourForClassFragment.this.classOfficeHourRecyclerView.setAdapter
                        (classOfficeHourListAdapter);
            }
        });
    }

}
