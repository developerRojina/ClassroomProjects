package com.aadim.classroom.notebook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.aadim.classroom.R;

public class AddNotesActivity extends AppCompatActivity {

    EditText etTitle, etDescription;
    Spinner spinnerCategory;
    Button btnSaveNote;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        etTitle = findViewById(R.id.et_title);
        etDescription = findViewById(R.id.et_description);
        spinnerCategory = findViewById(R.id.spinner_category);
        btnSaveNote = findViewById(R.id.btn_save_note);


        String[] categories = new String[]{"General", "Urgent", "Light"};

        ArrayAdapter categoryAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        spinnerCategory.setAdapter(categoryAdapter);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("note_title", etTitle.getText().toString());
                intent.putExtra("note_description", etDescription.getText().toString());
                intent.putExtra("note_category", spinnerCategory.getSelectedItem().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });


    }
}