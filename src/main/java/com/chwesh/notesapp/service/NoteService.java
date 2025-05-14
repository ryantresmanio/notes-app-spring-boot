package com.chwesh.notesapp.service;

import com.chwesh.notesapp.model.Note;
import com.chwesh.notesapp.repository.NoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {


    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    /*public NoteService() {



        notes.add(new Note(1, "Buy Milk", "Remember to buy milk"));
        notes.add(new Note(2, "Finish Homework", "Complete the math exercises"));
        notes.add(new Note(3, "Call Mom", "Check in with Mom about weekend plans"));
    }*/

    /*@PostConstruct
    public void initData() {
        // Only add if DB is empty to avoid duplication on restart
        if (noteRepository.count() == 0) {
            noteRepository.save(new Note(1, "Buy Milk", "Remember to buy milk"));
            noteRepository.save(new Note(2, "Finish Homework", "Complete the math exercises"));
            noteRepository.save(new Note(3, "Call Mom", "Check in with Mom about weekend plans"));
        }
    }*/

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(Integer id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElse(null);  // Return null if the note is not found
    }

    public void addNote(Note note) {
        noteRepository.save(note);
    }


    public void deleteNoteById(Integer id) {
        noteRepository.deleteById(id);
    }

    public void updateNote(Integer id, Note updatedNote) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
        note.setTitle(updatedNote.getTitle());
        note.setNoteContent(updatedNote.getNoteContent());
        noteRepository.save(note);
    }
}
