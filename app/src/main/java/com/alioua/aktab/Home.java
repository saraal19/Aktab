package com.alioua.aktab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    RecyclerView noteList;
    CardView addNote;
    DBHalper dbHalper;
    ArrayList<String> aktab_id, aktab_title, aktab_thenote, aktab_dates;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        noteList=findViewById(R.id.note_list);
        addNote=findViewById(R.id.add_note);

        dbHalper = new DBHalper(Home.this);
        aktab_id = new ArrayList<>();
        aktab_title = new ArrayList<>();
        aktab_thenote = new ArrayList<>();
        aktab_dates = new ArrayList<>();


        /*ArrayList<NoteModel> notes = new ArrayList<>();
        notes.add(new NoteModel("First note", "I programme and play games "));
        notes.add(new NoteModel("Hello note", "I watch gray's anatomy it's super "));
        notes.add(new NoteModel("Hi note", "I watch anime HxH it's very good "));

        NoteAdapter adapter = new NoteAdapter(Home.this,notes);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Home.this,2);
        noteList.setLayoutManager(gridLayoutManager);
        noteList.setAdapter(adapter);*/
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, AddNote.class);
                startActivity(i);
                finish();
            }
        });

        storeDataInArrys();

        noteAdapter = new NoteAdapter(Home.this, aktab_id, aktab_title, aktab_thenote, aktab_dates);
        noteList.setAdapter(noteAdapter);
        noteList.setLayoutManager(new GridLayoutManager(Home.this,2));



    }

    void storeDataInArrys(){
        Cursor cursor = dbHalper.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                aktab_id.add(cursor.getString(0));
                aktab_title.add(cursor.getString(1));
                aktab_thenote.add(cursor.getString(2));
                aktab_dates.add(cursor.getString(3));



            }
        }
    }
}