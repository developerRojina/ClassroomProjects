package com.aadim.classroom.notebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.aadim.classroom.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class NotesActivity extends AppCompatActivity {

    ArrayList<Note> notes;
    NotebookDbHelper helper;

    ActivityResultLauncher<Intent> launchSomeActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                String title = data.getExtras().getString("note_title");
                String description = data.getExtras().getString("note_description");
                String category = data.getExtras().getString("note_category");
                Note note = new Note(title, description, category);
                notesAdapter.addNote(note);
                helper.addNote(note);


            }
        }
    });

    FloatingActionButton btnAddNote;

    RecyclerView rvNotes;

    NotesAdapter notesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        helper = new NotebookDbHelper(getApplicationContext());

        notes = new ArrayList<>();

        notes.addAll(helper.getAllNotes());


        notesAdapter = new NotesAdapter(notes);


        btnAddNote = findViewById(R.id.btnAddNote);
        rvNotes = findViewById(R.id.rvNotes);

        rvNotes.setAdapter(notesAdapter);


        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotesActivity.this, AddNotesActivity.class);
                launchSomeActivity.launch(intent);
            }
        });
    }
}