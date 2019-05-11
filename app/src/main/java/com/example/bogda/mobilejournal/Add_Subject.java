package com.example.bogda.mobilejournal;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Add_Subject extends AppCompatActivity implements View.OnClickListener{

    Button add_rozklad;
    EditText edit_new;
    LinearLayout linearLayoutR;
    LinearLayout linearLayoutL;
    SharedPreferences sPref_mySubject = null;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__subject);
        linearLayoutR = (LinearLayout) findViewById(R.id.liener_rozkladRGHT);
        linearLayoutL = (LinearLayout) findViewById(R.id.liener_rozkladLEFT);
        add_rozklad  = (Button) findViewById(R.id.add_rozklad);
        edit_new = (EditText) findViewById(R.id.edit_newRozklad);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of TextView
                LinearLayout.LayoutParams.WRAP_CONTENT);
        add_rozklad.setOnClickListener(this);
        sPref_mySubject = getSharedPreferences("Subjekt",MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        counter++;
        SharedPreferences.Editor ed = sPref_mySubject.edit();
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.BLACK);
        textView.setText(counter+". " +edit_new.getText().toString());
        String new_subject = edit_new.getText().toString();
        edit_new.setText("");
        if (counter<=20){
            linearLayoutR.addView(textView);
            ed.putString(String.valueOf(counter) , new_subject);
            ed.commit();
        }
        else if(counter >40)
            Toast.makeText(this, "Перевищено ліміт пердметів", Toast.LENGTH_SHORT).show();
        else{
            linearLayoutL.addView(textView);
            ed.putString(String.valueOf(counter) , new_subject);
            ed.commit();
        }

    }

}
