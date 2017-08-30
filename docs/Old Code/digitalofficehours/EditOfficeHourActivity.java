package edu_chat.android.com.edu_chat.controller.digitalofficehours;

import android.R.id;
import android.R.layout;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import chat.edu.edu_chat.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by yuandali on 7/20/16.
 * Edu.Chat Inc.
 */
public class EditOfficeHourActivity extends AppCompatActivity {

    @NonNull private final String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"};
    @Nullable
    @BindView(R.id.spinner)
    Spinner daySpinner;
    @Nullable
    @BindView(R.id.from_textview)
    TextView fromTextView;
    @Nullable
    @BindView(R.id.from_image_button)
    ImageButton fromImageButton;
    @Nullable
    @BindView(R.id.to_textview)
    TextView toTextView;
    @Nullable
    @BindView(R.id.to_image_button)
    ImageButton toImageButton;
    private String selectedDay;

    @NonNull
    private static String getFormattedOfficeHour(final int hour, final int minute) {
        final String hourString = hour < 10 ? "0" + hour : String.valueOf(hour);
        final String minuteString = minute < 10 ? "0" + minute : String.valueOf(minute);
        return hourString + ':' + minuteString;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_edit_office_hour);
        ButterKnife.bind(this);
        final Toolbar toolbar = this.findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        if (this.getSupportActionBar() != null) {
            this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this,
                                                                   layout.simple_spinner_dropdown_item,
                                                                   this.days
        );
        this.daySpinner.setAdapter(dayAdapter);
        this.daySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final
            int position, final long id) {
                EditOfficeHourActivity.this.selectedDay = EditOfficeHourActivity.this
                        .days[position];
                Toast.makeText(EditOfficeHourActivity.this.getBaseContext(),
                               EditOfficeHourActivity.this.selectedDay + " selected.",
                               Toast.LENGTH_SHORT
                )
                        .show();
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {
            }
        });

       /* this.fromImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO: change initial time in TimePickerDialog
                final Calendar now = Calendar.getInstance();
                final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                        new OnTimeSetListener() {
                            @Override
                            public void onTimeSet(final RadialPickerLayout view, final int
                                    hourOfDay, final int
                                    minute, final int second) {
                                EditOfficeHourActivity.this.fromTextView.setText
                                        (getFormattedOfficeHour(hourOfDay, minute));
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false
                );
                timePickerDialog.show(EditOfficeHourActivity.this.getFragmentManager(),
                        "TimePickerDialog");
            }
        });

        this.toImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO: change initial time in TimePickerDialog
                final Calendar now = Calendar.getInstance();
                final TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                        new OnTimeSetListener() {
                            @Override
                            public void onTimeSet(final RadialPickerLayout view, final int
                                    hourOfDay, final int
                                    minute, final int second) {
                                EditOfficeHourActivity.this.toTextView.setText
                                        (getFormattedOfficeHour(hourOfDay, minute));
                            }
                        },
                        now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false
                );
                timePickerDialog.show(EditOfficeHourActivity.this.getFragmentManager(),
                        "TimePickerDialog");
            }
        });
*/
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        if (item.getItemId() == id.home) {
            this.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}