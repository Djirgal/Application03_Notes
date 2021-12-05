package ru.learningandroid.application03_notes.ui.list;

import java.util.List;

import ru.learningandroid.application03_notes.domain.Note;

public interface NotesListView {

    void showNotes(List<Note> notesList);

}
