package com.alioua.aktab;

public class NoteModel {
    String titleNote,theNote;

    public String getTitleNote() {
        return titleNote;
    }

    public String getTheNote() {
        return theNote;
    }

    public NoteModel(String titleNote, String theNote) {
        this.titleNote = titleNote;
        this.theNote = theNote;
    }
}
