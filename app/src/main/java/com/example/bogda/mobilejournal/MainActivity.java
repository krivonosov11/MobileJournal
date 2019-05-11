package com.example.bogda.mobilejournal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.bogda.mobilejournal.days.FridayActivity;
import com.example.bogda.mobilejournal.days.MondayActivity;
import com.example.bogda.mobilejournal.days.ThursdayActivity;
import com.example.bogda.mobilejournal.days.TuesdayActivity;
import com.example.bogda.mobilejournal.days.WednesdayActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button_user;
    Button button_settings;
    Button bt_monday;
    Button bt_tuesday;
    Button bt_wednesday;
    Button bt_thursday;
    Button bt_friday;
    ImageButton bt_left;
    ImageButton bt_right;
    Button bt_createuser;
    Button bt_creasubject;
    Button bt_createtimetable;
    TextView text_week;
    SharedPreferences sPref;
    int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sPref = getSharedPreferences("My", MODE_PRIVATE);
       if(sPref.getAll().size()==0) {
            setContentView(R.layout.new_user);
            bt_createuser = (Button) findViewById(R.id.create_user);
            bt_creasubject = (Button) findViewById(R.id.create_subject);
            bt_createtimetable = (Button) findViewById(R.id.create_timetable);
            bt_createuser.setOnClickListener(this);
            bt_creasubject.setOnClickListener(this);
            bt_createtimetable.setOnClickListener(this);
        }
       else {
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        k = 1;
        button_user = (Button) findViewById(R.id.btn_user);
        button_settings = (Button) findViewById(R.id.btn_setting);
        bt_monday = (Button) findViewById(R.id.day_monday);
        bt_tuesday = (Button) findViewById(R.id.day_tuesday);
        bt_wednesday = (Button) findViewById(R.id.day_wednesday);
        bt_thursday = (Button) findViewById(R.id.day_thursday);
        bt_friday = (Button) findViewById(R.id.day_friday);
        bt_left = (ImageButton) findViewById(R.id.left_week);
        bt_right = (ImageButton) findViewById(R.id.right_week);
        text_week = (TextView) findViewById(R.id.text_week);
        button_settings.setOnClickListener(this);
        button_user.setOnClickListener(this);
        bt_monday.setOnClickListener(this);
        bt_tuesday.setOnClickListener(this);
        bt_wednesday.setOnClickListener(this);
        bt_thursday.setOnClickListener(this);
        bt_friday.setOnClickListener(this);
        bt_left.setOnClickListener(this);
        bt_right.setOnClickListener(this);
        text_week.setText("Тиждень №"+k);
      }

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Intent i = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.btn_user:
                intent = new Intent(this, User_Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_setting:
                intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            case R.id.day_monday:
                intent = new Intent(this, MondayActivity.class);
                startActivity(intent);
                break;
            case R.id.day_tuesday:
                intent = new Intent(this, TuesdayActivity.class);
                startActivity(intent);
                break;
            case R.id.day_wednesday:
                intent = new Intent(this, WednesdayActivity.class);
                startActivity(intent);
                break;
            case R.id.day_thursday:
                intent = new Intent(this, ThursdayActivity.class);
                startActivity(intent);
                break;
            case R.id.day_friday:
                intent = new Intent(this, FridayActivity.class);
                startActivity(intent);
                break;
            case R.id.left_week:
               if(k>1){
                   k--;
                   text_week.setText("Тиждень №"+k);
               }
                break;
            case R.id.right_week:
                k++;
                text_week.setText("Тиждень №"+k);
                break;
            case R.id.create_user:
                intent = new Intent(this, User_Activity.class);
                startActivity(intent);
                break;
            case R.id.create_subject:
                intent = new Intent(this, Add_Subject.class);
                startActivity(intent);
                break;
            case R.id.create_timetable:
                intent = new Intent(this, Add_NewTable.class);
                startActivity(intent);
                break;


        }
    }
}
