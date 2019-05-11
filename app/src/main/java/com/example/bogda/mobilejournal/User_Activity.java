package com.example.bogda.mobilejournal;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class User_Activity extends AppCompatActivity implements View.OnClickListener{

    EditText et_name;
    EditText et_surname;
    EditText et_vater;
    EditText et_date;
    EditText et_syti;
    EditText et_school;
    EditText et_class;
    EditText et_kuraot;
    Button button_editing;
    Button button_saved;
    ImageButton button_image;
    SharedPreferences sPref = null;
    int DIALOG_DATE = 1; int myYear = 2011;
    int myMonth = 02; int myDay = 03;
    Button btn_data;
    Spinner spinner_stat;
    private final int IDD_LIST_CATS = 1;
    private final int Pick_image = 1;
    Uri imageUri= null;
    String[] data = {"Київ",
            "Вінницька область" ,
            "Волинська область" ,
            "Дніпропетровська область" ,
            "Донецька область" ,
            "Житомирська область" ,
            "Закарпатська область" ,
            "Запорізька область" ,
            "Івано-Франківська область" ,
            "Київська область" ,
            "Кіровоградська область" ,
            "Луганська область" ,
            "Львівська область" ,
            "Миколаївська область" ,
            "Одеська область" ,
            "Полтавська область" ,
            "Рівненська область" ,
            "Сумська область" ,
            "Тернопільська область" ,
            "Харківська область" ,
            "Херсонська область" ,
            "Хмельницька область" ,
            "Черкаська область" ,
            "Чернівецька область" ,
            "Чернігівська область "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_);
        sPref = getSharedPreferences("My",MODE_PRIVATE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        et_name = (EditText) findViewById(R.id.edit_name);
        et_surname = (EditText) findViewById(R.id.edit_surname);
        et_vater = (EditText) findViewById(R.id.edit_vater);
        et_date  =(EditText) findViewById(R.id.edit_date);
        et_syti = (EditText) findViewById(R.id.edit_syti);
        et_school = (EditText) findViewById(R.id.edit_school);
        et_class = (EditText) findViewById(R.id.edit_class);
        et_kuraot = (EditText) findViewById(R.id.edit_kurator);
        button_editing = (Button) findViewById(R.id.btn_editing);
        button_saved = (Button) findViewById(R.id.btn_saved);
        btn_data = (Button) findViewById(R.id.btn_date);
        spinner_stat = (Spinner) findViewById(R.id.spinner_stat);
        button_image = (ImageButton) findViewById(R.id.btn_image);
        button_image.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Вызываем стандартную галерею для выбора изображения с помощью Intent.ACTION_PICK:
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                //Тип получаемых объектов - image:
                photoPickerIntent.setType("image/*");
                //Запускаем переход с ожиданием обратного результата в виде информации об изображении:
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });
        button_image.setEnabled(false);
        et_name.setEnabled(false);
        et_surname.setEnabled(false);
        et_vater.setEnabled(false);
        et_syti.setEnabled(false);
        et_school.setEnabled(false);
        et_class.setEnabled(false);
        et_kuraot.setEnabled(false);
        et_date.setEnabled(false);
        btn_data.setEnabled(false);
        spinner_stat.setEnabled(false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_stat.setAdapter(adapter);
        spinner_stat.setPrompt("Title");
        spinner_stat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        button_editing.setOnClickListener(this);
        button_saved.setOnClickListener(this);
        load();

    }
    /**Для вызова галереи********************/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case Pick_image:
                if(resultCode == RESULT_OK){

                   if(data!=null){
                       //Получаем URI изображения, преобразуем его в Bitmap
                       //объект и отображаем в элементе ImageView нашего интерфейса:

                       imageUri = imageReturnedIntent.getData();
                       this.grantUriPermission(this.getPackageName(), imageUri, Intent.FLAG_GRANT_READ_URI_PERMISSION);

                       button_image.setImageURI(imageUri);
                       button_image.invalidate();


                   }


                }
        }
    }

    /****************методы выбора даты рождения пользователя*******************/
    public void func_date(View view) {
        showDialog(DIALOG_DATE);
    }


    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, myYear, myMonth, myDay);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myYear = year;
            myMonth = monthOfYear;
            myDay = dayOfMonth;
            et_date.setText(myDay + "." + myMonth + "." + myYear);
        }
    };

   /************метод сохраенния данных пользователья********/
    public void func_saved(){
        button_saved.setVisibility(View.INVISIBLE);
        et_name.setEnabled(false);
        et_surname.setEnabled(false);
        et_vater.setEnabled(false);
        button_image.setEnabled(false);
        et_syti.setEnabled(false);
        et_date.setEnabled(false);
        et_school.setEnabled(false);
        et_class.setEnabled(false);
        et_kuraot.setEnabled(false);
        btn_data.setEnabled(false);
        spinner_stat.setEnabled(false);

        save();
        Toast.makeText(this, "Готово!", Toast.LENGTH_SHORT).show();
    }
   @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editing:
               button_saved.setVisibility(View.VISIBLE);
                et_name.setEnabled(true);
                et_surname.setEnabled(true);
                et_vater.setEnabled(true);
                et_date.setEnabled(true);
                spinner_stat.setEnabled(true);
                et_syti.setEnabled(true);
                et_school.setEnabled(true);
                et_class.setEnabled(true);
                et_kuraot.setEnabled(true);
                btn_data.setEnabled(true);
                button_image.setEnabled(true);
                break;
            case R.id.btn_saved:
                func_saved();
                break;

        }

    }

    public void load() {

        String new_name = sPref.getString("name","");
        String new_surname = sPref.getString("surname","");
        String new_vater = sPref.getString("vater","");
        String new_date = sPref.getString("data", "");
        int pos = sPref.getInt("oblast",0);
        String new_syti = sPref.getString("syti","");
        String new_school = sPref.getString("school","");
        String new_class = sPref.getString("class","");
        String new_kurator = sPref.getString("kurator","");
        String new_image = sPref.getString("key", null);
        et_name.setText(new_name);
        et_surname.setText(new_surname);
        et_vater.setText(new_vater);
        et_date.setText(new_date);
        spinner_stat.setSelection(pos);
        et_syti.setText(new_syti);
        et_school.setText(new_school);
        et_class.setText(new_class);
        et_kuraot.setText(new_kurator);
        if(new_image!=null){
            button_image.setImageURI(Uri.parse(new_image));
            button_image.invalidate();
        }

    }

    public void save() {

        SharedPreferences.Editor ed = sPref.edit();
        ed.putString("name", et_name.getText().toString());
        ed.putString("surname", et_surname.getText().toString());
        ed.putString("vater", et_vater.getText().toString());
        ed.putString("data", et_date.getText().toString());
        ed.putInt("oblast", spinner_stat.getSelectedItemPosition());
        ed.putString("syti", et_syti.getText().toString());
        ed.putString("school", et_school.getText().toString());
        ed.putString("class", et_class.getText().toString());
        ed.putString("kurator", et_kuraot.getText().toString());
        if(imageUri!=null)
            ed.putString("key", String.valueOf(imageUri));

        ed.commit();
    }


}
