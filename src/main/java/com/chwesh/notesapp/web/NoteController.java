package com.chwesh.notesapp.web;

import com.chwesh.notesapp.model.Note;
import com.chwesh.notesapp.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    private final NoteService noteService;


    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String note(){
        return "This is the Note App";
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable Integer id) {
        return noteService.getNoteById(id);
    }

    @PostMapping("/notes")
    public void createNote(@RequestBody Note note) {
        noteService.addNote(note);
    }

    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Integer id) {
        noteService.deleteNoteById(id);
    }
}
