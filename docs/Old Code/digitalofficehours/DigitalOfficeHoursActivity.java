package edu_chat.android.com.edu_chat.controller.digitalofficehours;

import android.R.id;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import chat.edu.edu_chat.R;
import chat.edu.edu_chat.R.layout;

/**
 * Created by yuandali on 7/20/16.
 * Edu.Chat Inc.
 */
public class DigitalOfficeHoursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_digital_office_hours);
        final Toolbar toolbar = this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final DigitalOfficeHoursListFragment digitalOfficeHoursListFragment = new
                DigitalOfficeHoursListFragment();
        final FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.digital_office_hours_fragment, digitalOfficeHoursListFragment);
        ft.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        if (item.getItemId() == id.home) {
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (this.getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            this.getSupportFragmentManager().popBackStack();
        }
    }
}
