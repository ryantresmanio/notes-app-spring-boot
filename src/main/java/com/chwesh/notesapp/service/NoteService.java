package com.chwesh.notesapp.service;

import com.chwesh.notesapp.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    List<Note> notes = new ArrayList<>();

    public NoteService() {
        notes.add(new Note(1, "Buy Milk", "Remember to buy milk"));
        notes.add(new Note(2, "Finish Homework", "Complete the math exercises"));
        notes.add(new Note(3, "Call Mom", "Check in with Mom about weekend plans"));
    }

    public List<Note> getAllNotes() {
        return notes;
    }

    public Note getNoteById(Integer id) {
        for (Note note : notes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null; // or throw a custom exception if not found
    }

    public void addNote(Note note) {
        int newId = notes.stream()
                .mapToInt(Note::getId)
                .max()
                .orElse(0) + 1; // Get the max ID and add 1 to it
        note.setId(newId);
        notes.add(note);
    }

    public void deleteNoteById(Integer id) {
        notes.removeIf(note -> note.getId().equals(id));
    }
}
