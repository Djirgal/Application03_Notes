package ru.learningandroid.application03_notes.domain;

import java.util.ArrayList;
import java.util.List;

import ru.learningandroid.application03_notes.R;

public class InMemoryNotesRepository implements NotesRepository {

    @Override
    public List<Note> getAllNotes() {
        ArrayList<Note> result = new ArrayList();


        result.add(new Note(R.string.note_header_new, R.string.note_body_new));
        result.add(new Note(R.string.note_header1, R.string.note_body1));
        result.add(new Note(R.string.note_header2, R.string.note_body2));
        result.add(new Note(R.string.note_header3, R.string.note_body3));
        return result;
    }

    @Override
    public void addNote(Note note) {

    }

    @Override
    public void removeNote(Note note) {

    }

}
