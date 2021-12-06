package ru.learningandroid.application03_notes.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentResultListener;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import ru.learningandroid.application03_notes.R;
import ru.learningandroid.application03_notes.domain.Note;
import ru.learningandroid.application03_notes.ui.detail.NoteDetailActivity;
import ru.learningandroid.application03_notes.ui.detail.NoteDetailFragment;
import ru.learningandroid.application03_notes.ui.list.NotesListFragment;

public class MainActivity extends AppCompatActivity {

    private static final String ARG_NOTE = "ARG_NOTE";
    private Note selectedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(ARG_NOTE)) {
            selectedNote = savedInstanceState.getParcelable(ARG_NOTE);

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                showDetails();
            }
        }

        getSupportFragmentManager()
                .setFragmentResultListener(NotesListFragment.RESULT_KEY, this, new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        selectedNote = result.getParcelable(NotesListFragment.ARG_NOTE);

                        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                            showDetails();
                        } else {
                            Intent intent = new Intent(MainActivity.this, NoteDetailActivity.class);
                            intent.putExtra(NoteDetailActivity.EXTRA_NOTE, selectedNote);
                            startActivity(intent);
                        }
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if (selectedNote != null) {
            outState.putParcelable(ARG_NOTE, selectedNote);
        }
    }

    private void showDetails() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(NoteDetailFragment.ARG_NOTE, selectedNote);
        getSupportFragmentManager()
                .setFragmentResult(NoteDetailFragment.KEY_RESULT, bundle);
    }
}