package ru.learningandroid.application03_notes.ui.list;

import java.util.List;

import ru.learningandroid.application03_notes.domain.Note;
import ru.learningandroid.application03_notes.domain.NotesRepository;

public class NotesListPresenter {

    private NotesListView view;
    private NotesRepository repository;

    public NotesListPresenter(NotesListView view, NotesRepository repository) {

        this.view = view;
        this.repository = repository;
    }

    public void refresh(){

        List<Note> result = repository.getAllNotes();
        view.showNotes(result);
    }
}
