package ru.learningandroid.application03_notes.domain;

import java.util.List;

public interface NotesRepository {

    List<Note> getAllNotes();

    void addNote(Note note);

    void removeNote(Note note);
}
