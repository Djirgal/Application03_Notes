package ru.learningandroid.application03_notes.ui.detail;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import ru.learningandroid.application03_notes.R;
import ru.learningandroid.application03_notes.domain.Note;
import ru.learningandroid.application03_notes.ui.list.NotesListFragment;

public class NoteDetailFragment extends Fragment {

    public static final String ARG_NOTE= "ARG_NOTE";
    public static final String KEY_RESULT = "NoteDetailsFragment_KEY_RESULT";

    private TextView noteHeader;
    private EditText noteBody;

    public NoteDetailFragment() {

        super(R.layout.fragment_note_detail);
    }

    public static NoteDetailFragment newInstance(Note note) {

        NoteDetailFragment fragment = new NoteDetailFragment();
        Bundle argsBundle = new Bundle();

        argsBundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(argsBundle);
        return fragment;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        noteHeader = view.findViewById(R.id.note_header);

        noteBody = view.findViewById(R.id.note_body);

        if (getArguments() != null && getArguments().containsKey(ARG_NOTE)) {
            displayDetails(getArguments().getParcelable(ARG_NOTE));
        }

        getParentFragmentManager()
                .setFragmentResultListener(KEY_RESULT, getViewLifecycleOwner(), new FragmentResultListener() {
                    @Override
                    public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                        Note note = result.getParcelable(NotesListFragment.ARG_NOTE);

                        displayDetails(note);
                    }
                });
    }

    private void displayDetails(Note note) {
        noteHeader.setText(note.getHeader());
        noteBody.setText(note.getBody());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
