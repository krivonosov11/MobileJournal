package com.example.bogda.mobilejournal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SettingActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_delete_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        button_delete_user = (Button) findViewById(R.id.delet_user);
        button_delete_user.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       SharedPreferences sPref = getSharedPreferences("My",MODE_PRIVATE);
        sPref.edit().clear().commit();
        Toast.makeText(this, "Користувача видалено.", Toast.LENGTH_SHORT).show();

    }
}
