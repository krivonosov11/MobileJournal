package com.example.bogda.mobilejournal;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Add_NewTable extends AppCompatActivity  implements View.OnClickListener{

    Spinner firs_subject;
    Spinner second_subject;
    Spinner three_subject;
    Spinner four_subject;
    Spinner fife_subject;
    Spinner six_subject;
    Spinner seven_subject;
    Spinner eight_subject;
    int k = 0;
    TextView day_name;
    Button btn_next;
    SharedPreferences spMonday = null;
    SharedPreferences spTuesday = null;
    SharedPreferences spWednesday = null;
    SharedPreferences spThursday = null;
    SharedPreferences spFriday = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__new_table);
        firs_subject = (Spinner) findViewById(R.id.first_subject);
        second_subject = (Spinner) findViewById(R.id.second_subject);
        three_subject = (Spinner) findViewById(R.id.three_subject);
        four_subject = (Spinner) findViewById(R.id.four_subject);
        fife_subject = (Spinner) findViewById(R.id.fife_subject);
        six_subject = (Spinner) findViewById(R.id.six_subject);
        seven_subject = (Spinner) findViewById(R.id.seven_subject);
        eight_subject = (Spinner) findViewById(R.id.eight_subject);
        day_name = (TextView) findViewById(R.id.id_day_of_table);
        spMonday = getSharedPreferences("spMonday",MODE_PRIVATE);
        spTuesday = getSharedPreferences("spTuesday",MODE_PRIVATE);
        spWednesday = getSharedPreferences("spWednesday",MODE_PRIVATE);
        spThursday = getSharedPreferences("spThursday",MODE_PRIVATE);
        spFriday = getSharedPreferences("spFriday",MODE_PRIVATE);
        btn_next = (Button) findViewById(R.id.btn_result);
        btn_next.setOnClickListener(this);
        SharedPreferences sharedPreferences = getSharedPreferences("Subjekt",MODE_PRIVATE);//данные "предметы"
        String []data = new String[sharedPreferences.getAll().size()+1];
        for (int i = 0; i<sharedPreferences.getAll().size()+1; i++){
            data[i] = sharedPreferences.getString(String.valueOf(i),"");//в массив для адапетра
            if(data[i]=="")data[i]="Виберіть предмет";

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        firs_subject.setAdapter(adapter);
        firs_subject.setPrompt("Title");
        firs_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        second_subject.setAdapter(adapter);
        second_subject.setPrompt("Title");
        second_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        three_subject.setAdapter(adapter);
        three_subject.setPrompt("Title");
        three_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        four_subject.setAdapter(adapter);
        four_subject.setPrompt("Title");
        four_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
       fife_subject.setAdapter(adapter);
       fife_subject.setPrompt("Title");
       fife_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        six_subject.setAdapter(adapter);
        six_subject.setPrompt("Title");
        six_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        seven_subject.setAdapter(adapter);
        seven_subject.setPrompt("Title");
        seven_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
       eight_subject.setAdapter(adapter);
       eight_subject.setPrompt("Title");
       eight_subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


    }

    @Override
    public void onClick(View v) {
        if(true){
            SharedPreferences.Editor ed = spMonday.edit();
            if(!firs_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("1",firs_subject.getSelectedItem().toString());
                ed.commit();
            }
            if(!second_subject.getSelectedItem().toString().equals("Виберіть предмет")){
                   ed.putString("2",second_subject.getSelectedItem().toString());
            ed.commit();}
            if(!three_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("3", three_subject.getSelectedItem().toString());
                ed.commit();
            }
            if(!four_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("4", four_subject.getSelectedItem().toString());
                ed.commit();
            }
            if(!fife_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("5", fife_subject.getSelectedItem().toString());
                ed.commit();
            }
            if(!six_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("6", six_subject.getSelectedItem().toString());
                ed.commit();
            }
            if(!seven_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("7", seven_subject.getSelectedItem().toString());
                ed.commit();
            }
            if(!eight_subject.getSelectedItem().toString().equals("Виберіть предмет")) {
                ed.putString("8", seven_subject.getSelectedItem().toString());
                ed.commit();
            }

        }
       else{
            firs_subject.setSelection(0);
            second_subject.setSelection(0);
            three_subject.setSelection(0);
            four_subject.setSelection(0);
            fife_subject.setSelection(0);
            six_subject.setSelection(0);
            seven_subject.setSelection(0);
            eight_subject.setSelection(0);

            if(k==2){
                day_name.setText("Вівторок");
            }
            else if(k==3){
                day_name.setText("Середа");
            }
            else if(k==4){
                day_name.setText("Четвер");
            }
            else if(k==5){
                day_name.setText("П'ятниця");
                btn_next.setText("Зберігти");
            }
            else setContentView(R.layout.new_user);
        }
        k++;
    }
}
