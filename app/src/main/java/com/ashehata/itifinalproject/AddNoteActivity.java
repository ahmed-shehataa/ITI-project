package com.ashehata.itifinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class AddNoteActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    Button increase;
    Button decrease;
    Button save;
    int maxNotesNumber = 10;
    int counter = 0;
    private View view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        linearLayout = findViewById(R.id.linear);
        increase = findViewById(R.id.btn_increase);
        decrease = findViewById(R.id.btn_decrease);
        save = findViewById(R.id.btn_save_notes);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!(counter > maxNotesNumber - 2)) {
                    view1 = LayoutInflater.from(AddNoteActivity.this).inflate(R.layout.add_note, linearLayout, false);
                    view1.findViewById(R.id.btn_increase).setOnClickListener(this);
                    linearLayout.addView(view1);
                    counter++;
                }


            }
        });

        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter != 0) {
                    view1.findViewById(R.id.btn_decrease).setOnClickListener(this);
                    linearLayout.removeViewAt(counter);
                    counter--;
                }
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> notes = readAllNotes();
                for (int i = 0; i < notes.size(); i++) {
                    Toast.makeText(AddNoteActivity.this, notes.get(i
                    ), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private ArrayList<String> readAllNotes() {
        ArrayList<String> notes = new ArrayList<>();
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View view = linearLayout.getChildAt(i);
            if (view instanceof LinearLayout) {
                LinearLayout linearLayout = (LinearLayout) view;
                for (int j = 0; j < linearLayout.getChildCount(); j++) {
                    View mView = linearLayout.getChildAt(j);
                    if (mView instanceof EditText) {
                        EditText editText = (EditText) mView;
                        String etNote = editText.getText().toString().trim();
                        if (!etNote.equals("")) {
                            notes.add(etNote);
                        }
                    }

                }
            }
        }
        return notes;
    }
}