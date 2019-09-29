package com.demo.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewNotes;
    public static final ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewNotes = findViewById(R.id.recyclerViewNotes);

        if (notes.isEmpty()) {
            notes.add(new Note("Парикмахер", "Сделать прическу", "Понедельник", 2));
            notes.add(new Note("Заголовок2", "Описание2", "Вторник", 2));
            notes.add(new Note("Заголовок3", "Описание3", "Понедельник", 3));
            notes.add(new Note("Заголовок4", "Описание4", "Понедельник", 3));
            notes.add(new Note("Заголовок5", "Описание5", "Среда", 1));
            notes.add(new Note("Заголовок6", "Описание6", "Вторник", 3));
            notes.add(new Note("Заголовок7", "Описание7", "Понедельник", 3));
        }

        NotesAdapter adapter = new NotesAdapter(notes);
//        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewNotes.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewNotes.setAdapter(adapter);

    }

    public void onClickAddNote(View view){

        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);

    }
}