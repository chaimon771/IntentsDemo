package edu.haim.intentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_USER_NAME = "UserName";
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
    }

    public void toDatails(View view) {
        //1) create instance Inntent for the 2nd activity (context = this, signature of the activity that we want move into it,
        // each activity inherit from context.)
        Intent detailsIntent = new Intent(this, Details2ndActivity.class);

        //put some extras... move info from Activity to another Activity
        //send data from activity A to activity B using Intent.putExtra(key, value)
        detailsIntent.putExtra(EXTRA_USER_NAME, etName.getText().toString());
        detailsIntent.putExtra("Sender", "MainActivity");
        detailsIntent.putExtra("Age", 24);

        //2) Start the Activuty - also context method.
        startActivity(detailsIntent);

    }

    public void ynet(View view) {
        //Intent... "(String,action) and Data how do i want to implement it" View -> data
    /*
        String u = "http://www.ynet.co.il";
       Uri uri = Uri.parse(u);
    */
        Intent ynetIntent = new Intent(Intent.ACTION_VIEW, /*, uri*/
                Uri.parse("http://www.ynet.co.il")
        );

        //Start the Activity of the Intent...
        startActivity(ynetIntent);


    }

    public void dial(View view) {
        Intent dialIntent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+972542075202"));
        startActivity(dialIntent);
    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);

        //put some extras...
        intent.putExtra(AlarmClock.EXTRA_HOUR, 13);
        intent.putExtra(AlarmClock.EXTRA_MINUTES, 35);
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Time to wake up!");

        startActivity(intent);

    }
}
