package edu.haim.intentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import static android.R.id.message;

public class Details2ndActivity extends AppCompatActivity implements TimePicker.OnTimeChangedListener {
    TimePicker picker;

    TextView tvMessage;
    private String UserName;
    EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details2nd);


        // 1) get the Intent:
        Intent intent = getIntent();

        // 2) get the Extras:
        String userName = intent.getStringExtra(MainActivity.EXTRA_USER_NAME);
        Toast.makeText(this, "Hello," + userName, Toast.LENGTH_SHORT).show();

        tvMessage = (TextView) findViewById(R.id.tvMessage);
        String message = intent.getStringExtra(MainActivity.EXTRA_USER_NAME);
        tvMessage.setText("Hello " + message);

        picker = (TimePicker) findViewById(R.id.timePicker);
        picker.setOnTimeChangedListener(this);

        etMessage = (EditText) findViewById(R.id.etMessage);

    }
    TimePicker timePicker;
    int hour;
    int minutes;
    String message;

    @Override
    public void onTimeChanged(TimePicker timePicker, int hour, int minutes) {
        this.hour = hour;
        this.minutes = minutes;
    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, etMessage.getText().toString())
                .putExtra(AlarmClock.EXTRA_HOUR, hour)
                .putExtra(AlarmClock.EXTRA_MINUTES, minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
