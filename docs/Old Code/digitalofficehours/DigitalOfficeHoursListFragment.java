package edu_chat.android.com.edu_chat.controller.digitalofficehours;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import chat.edu.edu_chat.R.id;
import chat.edu.edu_chat.R.layout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu_chat.android.com.edu_chat.view.DividerItemDecoration;

/**
 * Created by yuandali on 7/20/16.
 * Edu.Chat Inc.
 */
public class DigitalOfficeHoursListFragment extends Fragment {

    @Nullable
    @BindView(id.officeHourRecyclerView)
    RecyclerView digitalHourRecyclerView;

    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                             final Bundle
                                     savedInstanceState) {
        final View view = inflater.inflate(layout.fragment_digital_office_hours_list, container,
                                           false
        );
        ButterKnife.bind(this, view);
        this.retrieveOfficeHoursList();
        return view;
    }

    private void retrieveOfficeHoursList() {
        // TODO: retrieve from API
        List<OfficeHourForClassFragment> officeHourList = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
           // this.officeHourList.add(new ECDigitalOfficeHour(i, "a", "#000000"));
        }
        this.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                DigitalOfficeHoursListFragment.this.populateOfficeHoursListView();
            }
        });
    }

    private void populateOfficeHoursListView() {
//        final DigitalOfficeHourListAdapter digitalOfficeHourAdapter
//                = new DigitalOfficeHourListAdapter(
//                (AppCompatActivity) this.getActivity(),
//                this.officeHourList
//        );
        this.digitalHourRecyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity
                ()));
        this.digitalHourRecyclerView.setHasFixedSize(false);
        this.digitalHourRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        this.digitalHourRecyclerView.setAdapter(null /*digitalOfficeHourAdapter*/);
    }

}
