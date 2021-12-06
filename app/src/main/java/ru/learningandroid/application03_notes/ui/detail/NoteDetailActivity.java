package ru.learningandroid.application03_notes.ui.detail;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.learningandroid.application03_notes.R;
import ru.learningandroid.application03_notes.domain.Note;

public class NoteDetailActivity extends AppCompatActivity {

    public static final String EXTRA_NOTE = "EXTRA_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_details);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
        } else {

            if (savedInstanceState == null) {
                FragmentManager fm = getSupportFragmentManager();

                Note note = getIntent().getParcelableExtra(EXTRA_NOTE);

                fm.beginTransaction()
                        .replace(R.id.container, NoteDetailFragment.newInstance(note))
                        .commit();
            }

        }
    }
}