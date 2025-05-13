package com.chwesh.notesapp.model;

public class Note {

    private Integer id;
    private String title;
    private String noteContent;

    public Note() {}

    public Note(Integer id, String title, String noteContent) {
        this.id = id;
        this.title = title;
        this.noteContent = noteContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
