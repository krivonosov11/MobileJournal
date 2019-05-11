package com.example.bogda.mobilejournal.days;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bogda.mobilejournal.R;

public class MondayActivity extends AppCompatActivity {

    Button button_save;
    EditText first_subject;
    EditText second_subject;
    EditText three_subject;
    EditText four_subject;
    EditText fife_subject;
    EditText six_subject;
    EditText seven_subject;
    EditText eight_subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);
        Toast.makeText(this, "Понеділок", Toast.LENGTH_SHORT).show();
        first_subject = (EditText) findViewById(R.id.first_edit);
        second_subject = (EditText) findViewById(R.id.second_edit);
        three_subject = (EditText) findViewById(R.id.three_edit);
        four_subject = (EditText) findViewById(R.id.four_edit);
        fife_subject = (EditText) findViewById(R.id.five_edit);
        six_subject = (EditText) findViewById(R.id.six_edit);
        seven_subject = (EditText) findViewById(R.id.seven_edit);
        eight_subject = (EditText) findViewById(R.id.eight_edit);
        push_sbject();
        button_save = (Button) findViewById(R.id.btn_save);
    }
    public void push_sbject(){
        SharedPreferences spM = getSharedPreferences("spMonday",MODE_PRIVATE);
        first_subject.setText("PIvbn52R");
        second_subject.setText(spM.getString("2", ""));
        three_subject.setText(spM.getString("3", ""));
        four_subject.setText(spM.getString("4", ""));
        fife_subject.setText(spM.getString("5", ""));
        six_subject.setText(spM.getString("6", ""));
        seven_subject.setText(spM.getString("7", ""));
        eight_subject.setText(spM.getString("8", ""));


    }
    public void func_edits(View view){

    }
}
