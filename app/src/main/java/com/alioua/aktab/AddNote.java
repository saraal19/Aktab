package com.alioua.aktab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddNote extends AppCompatActivity {
CardView saveNote,datePresent;
TextView textDate;
CalendarView calenderdate;
AlertDialog dialog;
Button btnValider;
EditText titleNote, theNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        Date date= new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        textDate = findViewById(R.id.text_date);
        datePresent = findViewById(R.id.date_presente);
        textDate.setText(simpleDateFormat.format(date));
        saveNote = findViewById(R.id.save_note);
        titleNote = findViewById(R.id.title_NOTE);
        theNote = findViewById(R.id.the_NOTE);
        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHalper myDB = new DBHalper(AddNote.this);
                myDB.addNote(textDate.getText().toString().trim(),
                        titleNote.getText().toString().trim(),
                        theNote.getText().toString().trim()
                );

                Intent i = new Intent(AddNote.this, Home.class);
                startActivity(i);
                finish();
            }
        });
        datePresent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dateDialog = new AlertDialog.Builder(AddNote.this);
                //AlertDialog.Builder builder = new AlertDialog.Builder(this);
                View vpopDate = getLayoutInflater().inflate(R.layout.pop_calender,null);
                calenderdate = vpopDate.findViewById(R.id.calendar_date);
                btnValider = vpopDate.findViewById(R.id.btn_valider);
                calenderdate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                        textDate.setText(String.valueOf(i2)+"/"+String.valueOf(i1+1)+"/"+String.valueOf(i));
                    }
                });
                btnValider.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
                dateDialog.setView(vpopDate);
                dialog= dateDialog.create();
                dialog.show();

            }
        });
    }
}